/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.karaf.cave.deployer.service.command;

import org.apache.karaf.cave.deployer.DeployerService;
import org.apache.karaf.cave.deployer.service.command.completers.ConnectionCompleter;
import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Argument;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.Completion;
import org.apache.karaf.shell.api.action.lifecycle.Reference;
import org.apache.karaf.shell.api.action.lifecycle.Service;

@Service
@Command(scope = "cave", name = "deployer-feature-uninstall", description = "Uninstall a feature from a remote instance")
public class FeatureUninstallCommand implements Action {

    @Reference
    private DeployerService deployer;

    @Argument(index = 0, name = "connection", description = "The connection to use", required = true, multiValued = false)
    @Completion(ConnectionCompleter.class)
    String connection;

    @Argument(index = 1, name = "feature", description = "The feature to uninstall", required = true, multiValued = false)
    String feature;

    @Override
    public Object execute() throws Exception {
        deployer.uninstallFeature(feature, connection);
        return null;
    }

}
