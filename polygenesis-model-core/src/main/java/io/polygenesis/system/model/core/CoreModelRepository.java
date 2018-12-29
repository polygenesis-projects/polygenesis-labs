/*-
 * ========================LICENSE_START=================================
 * PolyGenesis System
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Copyright (C) 2015 - 2018 OREGOR LTD
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

package io.polygenesis.system.model.core;

import io.polygenesis.shared.valueobject.Text;
import io.polygenesis.system.model.ModelRepository;
import java.util.Optional;
import java.util.Set;

/**
 * In-memory repository for Things.
 *
 * <p>It also offers convenience query methods.
 *
 * @author Christos Tsakostas
 */
public class CoreModelRepository implements ModelRepository {

  private Set<Thing> things;

  // ===============================================================================================
  // CONSTRUCTOR(S)
  // ===============================================================================================

  /**
   * Instantiates a new Core deducer result.
   *
   * @param things the things
   */
  public CoreModelRepository(Set<Thing> things) {
    setThings(things);
  }

  // ===============================================================================================
  // QUERIES
  // ===============================================================================================

  /**
   * Gets thing by name.
   *
   * @param thingName the thing name
   * @return the thing by name
   */
  public Optional<Thing> getThingByName(Text thingName) {
    return things.stream().filter(thing -> thing.getName().equals(thingName)).findFirst();
  }

  /**
   * Gets thing function.
   *
   * @param thingName the thing name
   * @param functionName the function name
   * @return the thing function
   */
  public Optional<Function> getThingFunction(Text thingName, Text functionName) {
    Optional<Thing> optionalThing = getThingByName(thingName);

    return optionalThing.flatMap(
        thing ->
            thing
                .getFunctions()
                .stream()
                .filter(function -> function.getName().equals(functionName))
                .findFirst());
  }

  // ===============================================================================================
  // GETTERS
  // ===============================================================================================

  /**
   * Gets things.
   *
   * @return the things
   */
  public Set<Thing> getThings() {
    return things;
  }

  // ===============================================================================================
  // GUARDS
  // ===============================================================================================

  private void setThings(Set<Thing> things) {
    this.things = things;
  }
}
