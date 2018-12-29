/*-
 * ========================LICENSE_START=================================
 * PolyGenesis System
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Copyright (C) 2015 - 2019 OREGOR LTD
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
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
 * =========================LICENSE_END==================================
 */

package io.polygenesis.system.generator.angular;

import io.polygenesis.system.generator.Generator;
import io.polygenesis.system.model.Model;
import java.util.Set;

/**
 * Implement an Angular source code generator.
 *
 * @author Christos Tsakostas
 */
public class AngularMaterialGenerator implements Generator {

  private static final String NAME = "Angular Material";
  private static final String DESCRIPTION =
      "PolyGenesis sample generator for Angular Material & NGRX";

  @Override
  public void generate(Set<Model> models) {
    throw new UnsupportedOperationException();
  }

  @Override
  public String name() {
    return NAME;
  }

  @Override
  public String description() {
    return DESCRIPTION;
  }
}
