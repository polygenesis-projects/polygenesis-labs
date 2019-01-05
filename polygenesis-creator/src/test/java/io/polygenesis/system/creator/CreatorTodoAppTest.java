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

package io.polygenesis.system.creator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

/** @author Christos Tsakostas */
public class CreatorTodoAppTest {

  @Test
  public void shouldGenerateByAnnotations() {
    // 1. Define the set of packages to be scanned for your annotated API.
    Set<String> packagesToScan = new HashSet<>(Arrays.asList("io.polygenesis.demo.todo.api"));

    // 2. Define your local machine generation path were code will be generated.
    String generationPath = "~/polygenesis/todo";

    // 3. Go!
    Creator.getInstance().generate(new CreatorRequest(packagesToScan, generationPath));
  }
}
