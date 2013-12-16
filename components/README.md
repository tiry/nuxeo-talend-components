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

## Provided componets 

`nNuxeoCreateOrUpdate` : output component that can be used to create or Update documents inside Nuxeo

`nNuxeoInput` : simple components that allows to query Nuxeo to retrieve documents and use them inside Talend

`nNuxeoGenericInput` : same as `nNuxeoInput`, but let you choose the target Operation on the Nuxeo side

This is just a minimal set of components and we could almost generate one Talend component for each Nuxeo Automation Operation.

For now, we decided to keep it simple, for now, because : 

 - JavaJet is a real a pain : this code should be generated !
 - we should build an additional component to handle mapping outside of JavaJet
 - I don't like writting code, if I don't have a way to share the code and to test it 

## Using the components

If you want to create or update documents inside Nuxeo from Talend, please see the [Create/Update sample](../doc/create_update.md).

If you want fetch documents from Nuxeo in Talend, please see the [Fetch sample](../doc/fetch.md).

## Status

All of this is testing code :

 - no automated build
 - no unit testing
 - bad packaging


