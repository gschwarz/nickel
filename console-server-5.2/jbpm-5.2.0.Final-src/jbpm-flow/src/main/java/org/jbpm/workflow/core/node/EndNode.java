/**
 * Copyright 2005 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jbpm.workflow.core.node;

import org.drools.definition.process.Connection;
import org.jbpm.workflow.core.impl.ExtendedNodeImpl;

/**
 * Default implementation of an end node.
 * 
 * @author <a href="mailto:kris_verlaenen@hotmail.com">Kris Verlaenen</a>
 */
public class EndNode extends ExtendedNodeImpl {

	private static final String[] EVENT_TYPES =
		new String[] { EVENT_NODE_ENTER };
	
    private static final long serialVersionUID = 510l;
    
    private boolean terminate = true;

    public boolean isTerminate() {
		return terminate;
	}

	public void setTerminate(boolean terminate) {
		this.terminate = terminate;
	}

	public String[] getActionTypes() {
		return EVENT_TYPES;
	}
	
    public void validateAddIncomingConnection(final String type, final Connection connection) {
        super.validateAddIncomingConnection(type, connection);
        if (!org.jbpm.workflow.core.Node.CONNECTION_DEFAULT_TYPE.equals(type)) {
            throw new IllegalArgumentException(
                "This type of node only accepts default incoming connection type!");
        }
        if (getFrom() != null) {
            throw new IllegalArgumentException(
                "This type of node cannot have more than one incoming connection!");
        }
    }

	public void validateAddOutgoingConnection(final String type, final Connection connection) {
        throw new UnsupportedOperationException(
            "An end node does not have an outgoing connection!");
    }

    public void validateRemoveOutgoingConnection(final String type, final Connection connection) {
        throw new UnsupportedOperationException(
            "An end node does not have an outgoing connection!");
    }
}
