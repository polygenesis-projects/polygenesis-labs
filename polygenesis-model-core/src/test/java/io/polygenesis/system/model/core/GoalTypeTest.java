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
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Test;

/** @author Christos Tsakostas */
public class GoalTypeTest {

  @Test
  public void shouldSucceed() {
    GoalType goalType = new GoalType("someGoal");

    assertThat(goalType).isNotNull();
    assertThat(goalType.getOriginal()).isEqualTo("someGoal");
  }

  @Test
  public void shouldThrowExceptionForNull() {
    assertThatThrownBy(() -> new GoalType(null)).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void shouldThrowExceptionForEmpty() {
    assertThatThrownBy(() -> new GoalType("")).isInstanceOf(IllegalArgumentException.class);
  }

  // ===============================================================================================
  // Equality and Hash
  // ===============================================================================================
  @Test
  public void equalityShouldSucceedForTwoEqualObjects() {
    GoalType goalType1 = new GoalType("xxx");
    GoalType goalType2 = new GoalType("xxx");

    assertThat(goalType1.equals(goalType2)).isTrue();
  }

  @Test
  public void equalityShouldSucceedForSameObject() {
    GoalType goalType1 = new GoalType("xxx");

    assertThat(goalType1.equals(goalType1)).isTrue();
  }

  @Test
  public void equalityShouldFailForNotEqualObjects() {
    GoalType goalType1 = new GoalType("xxx");
    GoalType goalType2 = new GoalType("yyy");

    assertThat(goalType1.equals(goalType2)).isFalse();
  }

  @Test
  public void equalityShouldFailForNullInput() {
    GoalType goalType1 = new GoalType("xxx");

    assertThat(goalType1.equals(null)).isFalse();
  }

  @Test
  public void equalityShouldFailForDifferentObject() {
    GoalType goalType1 = new GoalType("xxx");
    Object object = new Object();

    assertThat(goalType1.equals(object)).isFalse();
  }

  @Test
  public void hashCodeShouldNotBeNull() {
    GoalType goalType1 = new GoalType("xxx");

    assertThat(goalType1.hashCode()).isNotNull();
  }
}
