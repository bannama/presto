/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.facebook.presto.memory;

import io.airlift.configuration.Config;
import io.airlift.units.DataSize;

import javax.validation.constraints.NotNull;

import static io.airlift.units.DataSize.Unit.BYTE;

// This is separate from MemoryManagerConfig because it's difficult to test the default value of maxQueryMemoryPerNode
public class NodeMemoryConfig
{
    public static final String QUERY_MAX_MEMORY_PER_NODE_CONFIG = "query.max-memory-per-node";

    private DataSize maxQueryMemoryPerNode = new DataSize(Runtime.getRuntime().maxMemory() * 0.1, BYTE);

    @NotNull
    public DataSize getMaxQueryMemoryPerNode()
    {
        return maxQueryMemoryPerNode;
    }

    @Config(QUERY_MAX_MEMORY_PER_NODE_CONFIG)
    public NodeMemoryConfig setMaxQueryMemoryPerNode(DataSize maxQueryMemoryPerNode)
    {
        this.maxQueryMemoryPerNode = maxQueryMemoryPerNode;
        return this;
    }
}
