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
import io.polygenesis.system.model.core.iomodel.IoModelPrimitive;
import java.util.LinkedHashSet;
import org.junit.Test;

/** @author Christos Tsakostas */
public class GoalTest {

  @Test
  public void shouldcreateGoal() {
    Goal goal1 = createGoal1();

    assertThat(goal1).isNotNull();
    assertThat(goal1.getThing()).isNotNull();
    assertThat(goal1.getGoalType()).isNotNull();
    assertThat(goal1.getName()).isNotNull();
    assertThat(goal1.getReturnValue()).isNotNull();
    assertThat(goal1.getArguments()).isNotNull();
  }

  @Test
  public void shouldcreateGoalWithReturnValue() {
    Goal goal1 = createGoalWithReturnValueAndNoArguments();

    assertThat(goal1).isNotNull();
    assertThat(goal1.getThing()).isNotNull();
    assertThat(goal1.getGoalType()).isNotNull();
    assertThat(goal1.getName()).isNotNull();
    assertThat(goal1.getReturnValue()).isNotNull();

    assertThat(goal1.getArguments()).isNull();
  }

  @Test
  public void shouldcreateGoalWithArguments() {
    Goal goal1 = createGoalWithArgumentsAndNoReturnValue();

    assertThat(goal1).isNotNull();
    assertThat(goal1.getThing()).isNotNull();
    assertThat(goal1.getGoalType()).isNotNull();
    assertThat(goal1.getName()).isNotNull();
    assertThat(goal1.getArguments()).isNotNull();

    assertThat(goal1.getReturnValue()).isNull();
  }

  // ===============================================================================================
  // Equality and Hash
  // ===============================================================================================
  @Test
  public void equalityShouldSucceedForTwoEqualObjects() {
    Goal goal1 = createGoal1();
    Goal goal2 = createGoal1();

    assertThat(goal1.equals(goal2)).isTrue();
  }

  @Test
  public void equalityShouldSucceedForSameObject() {
    Goal goal1 = createGoal1();

    assertThat(goal1.equals(goal1)).isTrue();
  }

  @Test
  public void equalityShouldFailForNotEqualObjects() {
    Goal goal1 = createGoal1();
    Goal goal2 = createGoal2();

    assertThat(goal1.equals(goal2)).isFalse();
  }

  @Test
  public void equalityShouldFailForNullInput() {
    Goal goal1 = createGoal1();

    assertThat(goal1.equals(null)).isFalse();
  }

  @Test
  public void equalityShouldFailForDifferentObject() {
    Goal goal1 = createGoal1();
    Object object = new Object();

    assertThat(goal1.equals(object)).isFalse();
  }

  @Test
  public void hashCodeShouldNotBeNull() {
    Goal goal1 = createGoal1();

    assertThat(goal1.hashCode()).isNotNull();
  }

  // ===============================================================================================
  // Create Goals
  // ===============================================================================================

  private Goal createGoal1() {
    return new Goal(
        new Thing(new Text("thingName")),
        new GoalType("someGoal"),
        new Text("goalName"),
        new LinkedHashSet<>(),
        new ReturnValue(createIoModelPrimitive()));
  }

  private Goal createGoal2() {
    return new Goal(
        new Thing(new Text("thingName")),
        new GoalType("someGoal"),
        new Text("anotherGoalName"),
        new LinkedHashSet<>(),
        new ReturnValue(createIoModelPrimitive()));
  }

  private Goal createGoalWithReturnValueAndNoArguments() {
    return new Goal(
        new Thing(new Text("thingName")),
        new GoalType("someGoal"),
        new Text("goalName"),
        new ReturnValue(createIoModelPrimitive()));
  }

  private Goal createGoalWithArgumentsAndNoReturnValue() {
    return new Goal(
        new Thing(new Text("thingName")),
        new GoalType("someGoal"),
        new Text("goalName"),
        new LinkedHashSet<>());
  }

  private IoModelPrimitive createIoModelPrimitive() {
    return new IoModelPrimitive(
        new Text("datatype"), new Text("variableName"), new LinkedHashSet<>());
  }
}
