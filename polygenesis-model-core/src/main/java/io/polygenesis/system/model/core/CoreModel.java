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

package io.polygenesis.system.model.core;

import io.polygenesis.system.model.Model;
import java.util.LinkedHashSet;

/**
 * Core Model details.
 *
 * @author Christos Tsakostas
 */
public class CoreModel implements Model<CoreModelRepository> {

  @Override
  public CoreModelRepository repository() {
    return new CoreModelRepository(new LinkedHashSet<>());
  }

  @Override
  public String name() {
    return "CORE";
  }

  @Override
  public String description() {
    StringBuilder strBuilder = new StringBuilder();
    strBuilder.append("Core model is the most essential component of PolyGenesis. Things, ");
    strBuilder.append("Functions and Goals are defined here. Deducers use this information, ");
    strBuilder.append("in order to populate the TechnologyModels");
    return strBuilder.toString();
  }
}
