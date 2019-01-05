/*-
 * ==========================LICENSE_START=================================
 * PolyGenesis System
 * ========================================================================
 * Copyright (C) 2015 - 2019 OREGOR LTD
 * ========================================================================
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
 * ===========================LICENSE_END==================================
 */

package io.polygenesis.system.registry;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/** @author Christos Tsakostas */
public class RegistryTest {

  @Test
  public void shouldInstantiateRegistry() {
    Registry registry = Registry.getInstance();

    assertThat(registry.getModels()).isNotNull();
    assertThat(registry.getModels().size()).isEqualTo(1);

    assertThat(registry.getDeducers()).isNotNull();
    assertThat(registry.getDeducers().size()).isEqualTo(0);

    assertThat(registry.getGenerators()).isNotNull();
    assertThat(registry.getGenerators().size()).isEqualTo(0);
  }
}
