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

package org.apache.shardingsphere.sql.parser.sqlserver.visitor.format.facade;

import org.apache.shardingsphere.infra.util.exception.external.sql.type.generic.UnsupportedSQLOperationException;
import org.apache.shardingsphere.sql.parser.api.visitor.type.DALSQLVisitor;
import org.apache.shardingsphere.sql.parser.api.visitor.type.DCLSQLVisitor;
import org.apache.shardingsphere.sql.parser.api.visitor.type.DDLSQLVisitor;
import org.apache.shardingsphere.sql.parser.api.visitor.type.DMLSQLVisitor;
import org.apache.shardingsphere.sql.parser.api.visitor.type.RLSQLVisitor;
import org.apache.shardingsphere.sql.parser.api.visitor.type.TCLSQLVisitor;
import org.apache.shardingsphere.sql.parser.spi.SQLVisitorFacade;

/**
 * Format SQL Visitor facade for SQLServer.
 */
public final class SQLServerFormatSQLVisitorFacade implements SQLVisitorFacade {
    
    @Override
    public Class<? extends DMLSQLVisitor> getDMLVisitorClass() {
        throw new UnsupportedSQLOperationException("getDMLVisitorClass");
    }
    
    @Override
    public Class<? extends DDLSQLVisitor> getDDLVisitorClass() {
        throw new UnsupportedSQLOperationException("getDDLVisitorClass");
    }
    
    @Override
    public Class<? extends TCLSQLVisitor> getTCLVisitorClass() {
        throw new UnsupportedSQLOperationException("getTCLVisitorClass");
    }
    
    @Override
    public Class<? extends DCLSQLVisitor> getDCLVisitorClass() {
        throw new UnsupportedSQLOperationException("getDCLVisitorClass");
    }
    
    @Override
    public Class<? extends DALSQLVisitor> getDALVisitorClass() {
        throw new UnsupportedSQLOperationException("getDALVisitorClass");
    }
    
    @Override
    public Class<? extends RLSQLVisitor> getRLVisitorClass() {
        throw new UnsupportedSQLOperationException("getRLVisitorClass");
    }
    
    @Override
    public String getDatabaseType() {
        return "SQLServer";
    }
    
    @Override
    public String getVisitorType() {
        return "FORMAT";
    }
}
