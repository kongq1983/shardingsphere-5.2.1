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

package org.apache.shardingsphere.infra.rewrite.parameter.builder.impl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.shardingsphere.infra.rewrite.parameter.builder.ParameterBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Standard parameter builder.
 */
@RequiredArgsConstructor
public final class StandardParameterBuilder implements ParameterBuilder {
    
    private final List<Object> originalParameters;
    
    @Getter
    private final Map<Integer, Collection<Object>> addedIndexAndParameters = new TreeMap<>();
    
    private final Map<Integer, Object> replacedIndexAndParameters = new LinkedHashMap<>();
    
    /**
     * Add added parameters.
     * 
     * @param index parameters index to be added
     * @param parameters parameters to be added
     */
    public void addAddedParameters(final int index, final Collection<Object> parameters) {
        addedIndexAndParameters.put(index, parameters);
    }
    
    /**
     * Add replaced parameter.
     * 
     * @param index parameter index to be replaced
     * @param parameter parameter to be replaced
     */
    public void addReplacedParameters(final int index, final Object parameter) {
        replacedIndexAndParameters.put(index, parameter);
    }
    
    @Override
    public List<Object> getParameters() {
        List<Object> replacedParameters = new ArrayList<>(originalParameters);
        for (Entry<Integer, Object> entry : replacedIndexAndParameters.entrySet()) {
            replacedParameters.set(entry.getKey(), entry.getValue());
        }
        int maxParameterIndex = getMaxParameterIndex(originalParameters, addedIndexAndParameters);
        List<Object> result = new LinkedList<>();
        for (int index = 0; index <= maxParameterIndex; index++) {
            List<Object> currentIndexParameters = new LinkedList<>();
            if (replacedParameters.size() > index) {
                currentIndexParameters.add(replacedParameters.get(index));
            }
            if (addedIndexAndParameters.containsKey(index)) {
                currentIndexParameters.addAll(addedIndexAndParameters.get(index));
            }
            result.addAll(currentIndexParameters);
        }
        return result;
    }
    
    private int getMaxParameterIndex(final List<Object> originalParameters, final Map<Integer, Collection<Object>> addedIndexAndParameters) {
        if (addedIndexAndParameters.isEmpty()) {
            return originalParameters.size() - 1;
        }
        return Math.max(originalParameters.size() - 1, ((TreeMap<Integer, Collection<Object>>) addedIndexAndParameters).descendingMap().firstKey());
    }
}
