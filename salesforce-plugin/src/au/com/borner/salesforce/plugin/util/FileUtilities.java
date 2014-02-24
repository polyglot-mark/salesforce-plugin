package au.com.borner.salesforce.plugin.util;

import au.com.borner.salesforce.client.rest.domain.AbstractSourceCode;
import au.com.borner.salesforce.client.rest.domain.SourceFileMetaData;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.util.Pair;
import com.intellij.openapi.vfs.VfsUtilCore;
import com.intellij.openapi.vfs.VirtualFile;

import java.io.File;
import java.io.IOException;

/**
 * A utility class with common file methods for working with VirtualFiles
 *
 * @author mark
 */
public abstract class FileUtilities {

    private static final Logger logger = Logger.getInstance(FileUtilities.class);

    public static boolean createLocalFile(String path, AbstractSourceCode sObject) {
        String fileNameWithExtension = sObject.getFullyQualifiedFileName(sObject.getName());

        File localFile = new File(path + File.separator +  fileNameWithExtension);
        double crcResult;
        try {
            org.apache.commons.io.FileUtils.writeStringToFile(localFile, sObject.getBody());
            crcResult = org.apache.commons.io.FileUtils.checksumCRC32(localFile);
        } catch (IOException e) {
            logger.error("Error creating file " + localFile.getPath());
            return false;
        }
        if (sObject.getBodyCRC() != null && !sObject.getBodyCRC().equals(crcResult)) {
            logger.error("Body CRC does not match for class " + localFile.getPath());
            localFile.delete();
            return false;
        }

        try {
            createMetadataFile(path, fileNameWithExtension, sObject);
        } catch (Exception e) {
            logger.error("Error creating metadata file " + path + File.separator +  fileNameWithExtension + ".sfmd", e);
            localFile.delete();
            return false;
        }
        return true;
    }

    public static File createMetadataFile(String path, String fileNameWithExtension, AbstractSourceCode sObject) throws Exception {
        File metadataFile = new File(path + File.separator +  fileNameWithExtension + ".sfmd");
        SourceFileMetaData sourceFileMetaData = new SourceFileMetaData(fileNameWithExtension, sObject.getId(), sObject.getApiVersion());
        org.apache.commons.io.FileUtils.writeStringToFile(metadataFile, sourceFileMetaData.toString());
        return metadataFile;
    }

    public static Pair<String,SourceFileMetaData> getFileContents(VirtualFile file) throws Exception {
        String body = VfsUtilCore.loadText(file);
        String metadataFilePath = file.getPath() + ".sfmd";
        VirtualFile metadataFile = file.getFileSystem().findFileByPath(metadataFilePath);
        if (metadataFile == null) {
            throw new IllegalStateException("Unable to find metadata file at " + metadataFilePath);
        }
        String metadataContents = VfsUtilCore.loadText(metadataFile);
        SourceFileMetaData metadata = new SourceFileMetaData(metadataContents);
        return new Pair<String, SourceFileMetaData>(body, metadata);
    }
}
