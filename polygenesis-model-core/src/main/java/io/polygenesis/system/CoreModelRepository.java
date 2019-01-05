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

package io.polygenesis.system;

import io.polygenesis.shared.valueobject.Text;
import io.polygenesis.system.model.core.Function;
import io.polygenesis.system.model.core.Thing;
import java.util.Optional;
import java.util.Set;

/**
 * The interface Core model repository.
 *
 * @author Christos Tsakostas
 */
public interface CoreModelRepository extends ModelRepository {

  Set<Thing> getThings();

  Optional<Thing> getThingByName(Text thingName);

  Optional<Function> getThingFunction(Text thingName, Text functionName);
}
