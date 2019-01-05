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

import io.polygenesis.shared.valueobject.Text;
import io.polygenesis.system.CoreModelRepository;
import java.util.Optional;
import java.util.Set;

/**
 * In-memory repository for Things.
 *
 * <p>It also offers convenience query methods.
 *
 * @author Christos Tsakostas
 */
public class CoreModelRepositoryImpl implements CoreModelRepository {

  private Set<Thing> things;

  // ===============================================================================================
  // CONSTRUCTOR(S)
  // ===============================================================================================

  /**
   * Instantiates a new Core deducer result.
   *
   * @param things the things
   */
  public CoreModelRepositoryImpl(Set<Thing> things) {
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
  @Override
  public Optional<Thing> getThingByName(Text thingName) {
    return things.stream().filter(thing -> thing.getName().equals(thingName)).findFirst();
  }

  /**
   * Gets thing goal.
   *
   * @param thingName the thing name
   * @param goalName the goal name
   * @return the thing goal
   */
  @Override
  public Optional<Goal> getThingGoal(Text thingName, Text goalName) {
    Optional<Thing> optionalThing = getThingByName(thingName);

    return optionalThing.flatMap(
        thing ->
            thing.getGoals().stream().filter(goal -> goal.getName().equals(goalName)).findFirst());
  }

  // ===============================================================================================
  // GETTERS
  // ===============================================================================================

  /**
   * Gets things.
   *
   * @return the things
   */
  @Override
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
