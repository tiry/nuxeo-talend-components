package org.nuxeo.talend.extension.automation;

import org.nuxeo.ecm.automation.client.Session;
import org.nuxeo.ecm.automation.client.jaxrs.impl.HttpAutomationClient;
import org.nuxeo.talend.extension.model.nuxeo.NuxeoConnection;

public class NuxeoServer {
	
	public static Session getSession(NuxeoConnection conn) {		
		String server = "http://" + conn.getHost() + ":" + conn.getPort() + "/" + conn.getContextPath() + "/"; 			
		HttpAutomationClient client = new HttpAutomationClient(server +  "site/automation");  
		return client.getSession(conn.getUsername(), conn.getPassword());
	}

}
