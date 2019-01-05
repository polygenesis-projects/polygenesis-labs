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

import static org.assertj.core.api.Assertions.assertThat;

import io.polygenesis.shared.valueobject.Text;
import io.polygenesis.system.CoreModelRepository;
import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.Test;

/** @author Christos Tsakostas */
public class CoreModelRepositoryTest {

  @Test
  public void shouldSucceedToMakeDeducer() {
    CoreModelRepository repository = new CoreModelRepositoryImpl(new LinkedHashSet<>());

    assertThat(repository).isNotNull();
    assertThat(repository.getThings().size()).isEqualTo(0);
  }

  @Test
  public void shouldSucceedToGetThingByName() {
    CoreModelRepository repository = new CoreModelRepositoryImpl(createThings());

    assertThat(repository.getThingByName(new Text("someThing"))).isPresent();
  }

  @Test
  public void shouldSucceedToGetThingGoal() {
    CoreModelRepository repository = new CoreModelRepositoryImpl(createThings());

    assertThat(repository.getThingGoal(new Text("someThing"), new Text("someGoal"))).isPresent();
  }

  @Test
  public void shouldFailToGetThingGoal() {
    CoreModelRepository repository = new CoreModelRepositoryImpl(createThings());

    assertThat(repository.getThingGoal(new Text("someThing"), new Text("someNonExistingGoal")))
        .isEmpty();
  }

  @Test
  public void shouldFailToGetThingGoalForNonExistingThing() {
    CoreModelRepository repository = new CoreModelRepositoryImpl(createThings());

    assertThat(
            repository.getThingGoal(
                new Text("someNonExistingThing"), new Text("someNonExistingGoal")))
        .isEmpty();
  }

  private Set<Thing> createThings() {
    Set<Thing> things = new LinkedHashSet<>();

    Thing someThing = new Thing(new Text("someThing"));

    Goal someGoal =
        new Goal(someThing, new GoalType("someGoal"), new Text("someGoal"), new LinkedHashSet<>());

    someThing.appendGoal(someGoal);

    things.add(someThing);
    return things;
  }
}
