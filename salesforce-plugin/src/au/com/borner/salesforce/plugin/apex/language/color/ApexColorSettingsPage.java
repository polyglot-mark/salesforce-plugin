package au.com.borner.salesforce.plugin.apex.language.color;

import au.com.borner.salesforce.plugin.apex.filetypes.ApexSyntaxHighlighter;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class ApexColorSettingsPage implements ColorSettingsPage {

    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Keyword", DefaultLanguageHighlighterColors.KEYWORD),
            new AttributesDescriptor("Operator", DefaultLanguageHighlighterColors.OPERATION_SIGN),
            new AttributesDescriptor("Line comment", DefaultLanguageHighlighterColors.LINE_COMMENT),
            new AttributesDescriptor("Block comment", DefaultLanguageHighlighterColors.BLOCK_COMMENT),
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return AllIcons.Nodes.Class;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new ApexSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "/**\n" +
                " * This is an example of a block comment\n" +
                " */\n" +
                "public virtual abstract with sharing class MyClass extends MySuperClass implements MyInterface {\n" +
                "\n" +
                "    String = \"This is a string\".   // This is a line comment\n" +
                "    \n" +
                "}";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "Apex";
    }
}
