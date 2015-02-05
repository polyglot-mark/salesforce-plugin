# Note: this project is not actively being worked on or supported.  Please feel free to Fork and continue development.

### Develop Apex with Pleasure!
#### An IntelliJ IDEA Plugin for Salesforce Development

This project is a work in progress.  The goal is to provide a Java-like experience for doing full-lifecycle Apex
development using IntelliJ IDEA.

**Features that are (mostly) working:**

* Metadata Explorer Tool  Windows - browse all the metadata for your Salesforce organisation (including the Tooling
 API metadata)
* Data Explorer - browse all the data for your Salesforce organisation (including the Tooling API data)
* New Project Creation - create a new Salesforce project and download your Apex code into the new project
* Apex Syntax Highlighting - keyword highlighting and class structure recognition (this will be an ongoing process to
fine tune the language recognition)
* Click through references for class/interface names
* Auto completion of class/interface names

**Supported File Types:**

* Apex Triggers
* Apex Interfaces
* Apex Classes
* Apex Enums

**Features under development:**

* Execute Anonymous Tool Window
* API Limits Tool Window
* Import existing source code (from Eclipse project) into a Salesforce project
* Rename, Find Usages support

**Future features:**

* Visualforce Page support
* Visualforce Component support
* Creating Trigger from Metadata Explorer Tool Window
* Creating SOQL statement from Metadata Explorer Tool Window
* Run configurations for compile with/without tests, running just tests, etc
* Annotator for highlighting test coverage on class files
* Debugger?
* File synchronisation (changes in cloud get automatically synced locally)
* Delete support (delete file locally deletes in cloud)
* Full Sync / Full Deploy actions
* Download metadata and index for code completion
* Filter results in Data Explorer Tool Window

# How to build and install

Until the plugin is released into the IntelliJ plugins repository, you can following these instructions for manually
building and installing the plugin from GitHub:

1.  Update the ANT script salesforce-plugin-xml with the location of your IntelliJ IDEA install
```
    <!--property name="idea.path" value="C:\Program Files (x86)\JetBrains\IntelliJ IDEA 13.0.2"/-->
    <property name="idea.path" value="/Applications/IntelliJ IDEA 13.app"/>
```
2.  Execute the 'package' target of the ANT script - this will create a salesforce-plugin-#.#.zip
file in the out directory
3.  Go into IntelliJ IDEA settings under Plugins and select "Install plugin from disk".  Select the zip file and click Ok.

*Note: this plugin requires IntelliJ IDEA 13*

# Developers

The following instructions will get your development environment up and running for debugging the plugin:

1.  Clone the repository to your local machine
2.  Select "Import project" from IntelliJ IDEA project
2.1 Select your clone location
2.2 Select "Import from existing sources" and click through the Wizard

