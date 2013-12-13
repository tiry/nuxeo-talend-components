nuxeo-talend-components
=======================

Here are some sample Talend components for Nuxeo (Sandbox).

The goal is to be able from within Talend OpenStudio to create Job that include Reading/Writing documents inside Nuxeo.

## Building / Installing

There is no automated build, at least for now : this means that everything should be build from within Eclipse/TOS.

### Installation the components

To install the Nuxeo/Talend sample components :

 - from TOS 5.2 go in Window/Preferences/Talend/Component
 - locate *"Directory for User Components"*
   - define a directory for that if not already done (ex: /home/jacky/Talend/components)
 - unzip the nNuxeoXXX directories in this directory (ex: /home/jacky/Talend/components/nNuxeoInput ...)
 - restart TOS

You should end up with 4 Nuxeo Components in the Components Palette under the *"Nuxeo Family"*

### Component Designer

 From TOS Eclipse environment go in Window/Preferences/Talend Component Designer.
 
  - make Component Project point to the same directory as the "User Components" (ex: /home/jacky/Talend/components)

## Configuring the components

Nuxeo supports Complex properties and uses namespaces : this does not make the mapping with Talend schema very easy.

For technical constraints, the Talend schema field names must be java identiers : this excludes ":" and "/" that may used in XPath.

In order to *"walkaround"* this, for now, you can :

 - define Talend schema with "valid java names"
 - use the "comment" field to define the actual xPath to use 

For example, let's say you want to use dc:title :
 - define a field named "dc_title"
 - set comment to "dc:title"

## Status

All of this is testing code :

 - no automated build
 - no unit testing
 - bad packaging


