/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.elasticsearch.groovy

import org.junit.Test

/**
 * Tests {@link ClosureExtensions}.
 * <p>
 * These tests assume that {@link ClosureToMapConverter} is appropriately tested.
 */
class ClosureExtensionsTests extends AbstractESTestCase {
    @Test
    void testAsMap() {
        String firstName = randomAsciiOfLengthBetween(1, 8)
        String lastName = randomAsciiOfLengthBetween(1, 8)

        Map<String, Object> map = ClosureExtensions.asMap {
            name {
                first = firstName
                last = lastName
            }
        }

        assert map.name.first == firstName
        assert map.name.last == lastName
    }

    @Test
    void testExtensionModuleConfigured() {
        String randomName = randomAsciiOfLengthBetween(1, 8)

        assert { name = randomName }.asMap().name == randomName
    }
}