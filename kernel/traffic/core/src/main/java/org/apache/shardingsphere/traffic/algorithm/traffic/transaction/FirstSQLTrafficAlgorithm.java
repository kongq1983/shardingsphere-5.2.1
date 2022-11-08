/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.traffic.algorithm.traffic.transaction;

import lombok.Getter;
import org.apache.shardingsphere.traffic.api.traffic.identifier.SimplifiedTrafficAlgorithm;
import org.apache.shardingsphere.traffic.api.traffic.transaction.TransactionTrafficAlgorithm;
import org.apache.shardingsphere.traffic.api.traffic.transaction.TransactionTrafficValue;

import java.util.Properties;

/**
 * First SQL traffic algorithm.
 */
@Getter
public final class FirstSQLTrafficAlgorithm implements TransactionTrafficAlgorithm, SimplifiedTrafficAlgorithm {
    
    private Properties props;
    
    @Override
    public void init(final Properties props) {
        this.props = props;
    }
    
    @Override
    public boolean match(final TransactionTrafficValue transactionTrafficValue) {
        return false;
    }
    
    @Override
    public String getType() {
        return "FIRST_SQL";
    }
}
