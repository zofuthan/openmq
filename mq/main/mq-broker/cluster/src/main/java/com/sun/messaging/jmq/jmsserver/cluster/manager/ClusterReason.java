/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2000-2017 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://oss.oracle.com/licenses/CDDL+GPL-1.1
 * or LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

/*
 * @(#)ClusterManager.java	1.13 06/28/07
 */ 

package com.sun.messaging.jmq.jmsserver.cluster.manager;

import java.util.Set;
import java.util.Iterator;
import com.sun.messaging.jmq.io.MQAddress;
import java.util.NoSuchElementException;
import com.sun.messaging.jmq.jmsserver.util.BrokerException;
import com.sun.messaging.jmq.util.UID;

// for javadocs
import com.sun.messaging.jmq.jmsserver.Globals;

/**
 * Typesafe enum class which represents a Reason passed into broker changed
 */
public class ClusterReason
{
        
        /**
         * descriptive string associated with the reason
         */
        private final String name;
        
        /**
         * private constructor for ClusterReason
         */
        private ClusterReason(String name) {
            this.name = name;
        }

        /**
         * a string representation of the object
         */
        public String toString() {
            return "ClusterReason["+ name +"]";
        }

        /**
         * A broker has been added to the cluster.
         */
        public static final ClusterReason ADDED = 
                 new ClusterReason("ADDED");

        /**
         * A broker has been removed from the cluster.
         */
        public static final ClusterReason REMOVED = 
                 new ClusterReason("REMOVED");

        /**
         * The status of a broker has changed.
         * @see BrokerStatus
         */
        public static final ClusterReason STATUS_CHANGED = 
                 new ClusterReason("STATUS_CHANGED");

        /**
         * The state of a broker has changed.
         * @see BrokerState
         */
        public static final ClusterReason STATE_CHANGED = 
                 new ClusterReason("STATE_CHANGED");

        /**
         * The protocol version of a broker has changed.
         */
        public static final ClusterReason VERSION_CHANGED = 
                 new ClusterReason("VERSION_CHANGED");

        /**
         * The portmapper address of a broker has changed.
         */
        public static final ClusterReason ADDRESS_CHANGED = 
                 new ClusterReason("ADDRESS_CHANGED");

        /**
         * The address of the master broker in the cluster
         * has changed.
         */
        public static final ClusterReason MASTER_BROKER_CHANGED = 
                 new ClusterReason("MASTER_BROKER_CHANGED");
    
}

