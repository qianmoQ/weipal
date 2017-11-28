/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ioi6.weipal.common.presto;

import com.facebook.presto.client.ClientSession;
import com.facebook.presto.client.QueryResults;
import com.facebook.presto.client.StatementClient;
import com.ioi6.weipal.model.common.HostAndPort;
import com.ioi6.weipal.model.presto.Presto;
import io.airlift.http.client.HttpClientConfig;
import io.airlift.http.client.jetty.JettyHttpClient;
import io.airlift.json.JsonCodec;
import io.airlift.units.Duration;

import java.net.URI;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * presto utils
 * Created by shicheng on 2017/6/1.
 */
public class PrestoUtils {

    /**
     * presto statement client
     *
     * @param config
     * @return
     */
    public static StatementClient getStatementClient(Presto config, HostAndPort host) {
        if (config != null) {
            ClientSession clientSession = getClientSession(config, host);
            HttpClientConfig httpClientConfig = new HttpClientConfig().setConnectTimeout(new Duration(10, TimeUnit.SECONDS));
            JettyHttpClient httpClient = new JettyHttpClient(httpClientConfig);
            JsonCodec<QueryResults> jsonCodec = JsonCodec.jsonCodec(QueryResults.class);
            return new StatementClient(httpClient, jsonCodec, clientSession, config.getQuery());
        }
        return null;
    }

    /**
     * presto client session
     *
     * @param config
     * @return
     */
    public static ClientSession getClientSession(Presto config, HostAndPort host) {
        if (config != null) {
            return new ClientSession(URI.create(config.getCoordinatorServer()),
                    host.getUserName(), config.getSource(), config.getCatalog(), config.getSchema(),
                    TimeZone.getDefault().getID(), Locale.getDefault(), new HashMap<>(), null, false, new Duration(2, TimeUnit.MINUTES));
        }
        return null;
    }

}
