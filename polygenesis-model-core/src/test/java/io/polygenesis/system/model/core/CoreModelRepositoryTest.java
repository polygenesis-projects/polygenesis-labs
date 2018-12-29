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

import static org.assertj.core.api.Assertions.assertThat;

import io.polygenesis.shared.valueobject.Text;
import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.Test;

/** @author Christos Tsakostas */
public class CoreModelRepositoryTest {

  @Test
  public void shouldSucceedToMakeDeducer() {
    CoreModelRepository repository = new CoreModelRepository(new LinkedHashSet<>());

    assertThat(repository).isNotNull();
    assertThat(repository.getThings().size()).isEqualTo(0);
  }

  @Test
  public void shouldSucceedToGetThingByName() {
    CoreModelRepository repository = new CoreModelRepository(createThings());

    assertThat(repository.getThingByName(new Text("someThing"))).isPresent();
  }

  @Test
  public void shouldSucceedToGetThingFunction() {
    CoreModelRepository repository = new CoreModelRepository(createThings());

    assertThat(repository.getThingFunction(new Text("someThing"), new Text("someFunction")))
        .isPresent();
  }

  @Test
  public void shouldFailToGetThingFunction() {
    CoreModelRepository repository = new CoreModelRepository(createThings());

    assertThat(
            repository.getThingFunction(new Text("someThing"), new Text("someNonExistingFunction")))
        .isEmpty();
  }

  @Test
  public void shouldFailToGetThingFunctionForNonExistingThing() {
    CoreModelRepository repository = new CoreModelRepository(createThings());

    assertThat(
            repository.getThingFunction(
                new Text("someNonExistingThing"), new Text("someNonExistingFunction")))
        .isEmpty();
  }

  private Set<Thing> createThings() {
    Set<Thing> things = new LinkedHashSet<>();

    Thing someThing = new Thing(new Text("someThing"));

    Function someFunction =
        new Function(
            someThing, new Goal("someGoal"), new Text("someFunction"), new LinkedHashSet<>());

    someThing.appendFunction(someFunction);

    things.add(someThing);
    return things;
  }
}
