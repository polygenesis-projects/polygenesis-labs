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
import io.polygenesis.system.model.core.iomodel.IoModelPrimitive;
import java.util.LinkedHashSet;
import org.junit.Test;

/** @author Christos Tsakostas */
public class FunctionTest {

  @Test
  public void shouldCreateFunction() {
    Function function1 = createFunction1();

    assertThat(function1).isNotNull();
    assertThat(function1.getThing()).isNotNull();
    assertThat(function1.getGoal()).isNotNull();
    assertThat(function1.getName()).isNotNull();
    assertThat(function1.getReturnValue()).isNotNull();
    assertThat(function1.getArguments()).isNotNull();
  }

  @Test
  public void shouldCreateFunctionWithReturnValue() {
    Function function1 = createFunctionWithReturnValueAndNoArguments();

    assertThat(function1).isNotNull();
    assertThat(function1.getThing()).isNotNull();
    assertThat(function1.getGoal()).isNotNull();
    assertThat(function1.getName()).isNotNull();
    assertThat(function1.getReturnValue()).isNotNull();

    assertThat(function1.getArguments()).isNull();
  }

  @Test
  public void shouldCreateFunctionWithArguments() {
    Function function1 = createFunctionWithArgumentsAndNoReturnValue();

    assertThat(function1).isNotNull();
    assertThat(function1.getThing()).isNotNull();
    assertThat(function1.getGoal()).isNotNull();
    assertThat(function1.getName()).isNotNull();
    assertThat(function1.getArguments()).isNotNull();

    assertThat(function1.getReturnValue()).isNull();
  }

  // ===============================================================================================
  // Equality and Hash
  // ===============================================================================================
  @Test
  public void equalityShouldSucceedForTwoEqualObjects() {
    Function function1 = createFunction1();
    Function function2 = createFunction1();

    assertThat(function1.equals(function2)).isTrue();
  }

  @Test
  public void equalityShouldSucceedForSameObject() {
    Function function1 = createFunction1();

    assertThat(function1.equals(function1)).isTrue();
  }

  @Test
  public void equalityShouldFailForNotEqualObjects() {
    Function function1 = createFunction1();
    Function function2 = createFunction2();

    assertThat(function1.equals(function2)).isFalse();
  }

  @Test
  public void equalityShouldFailForNullInput() {
    Function function1 = createFunction1();

    assertThat(function1.equals(null)).isFalse();
  }

  @Test
  public void equalityShouldFailForDifferentObject() {
    Function function1 = createFunction1();
    Object object = new Object();

    assertThat(function1.equals(object)).isFalse();
  }

  @Test
  public void hashCodeShouldNotBeNull() {
    Function function1 = createFunction1();

    assertThat(function1.hashCode()).isNotNull();
  }

  // ===============================================================================================
  // Create Functions
  // ===============================================================================================

  private Function createFunction1() {
    return new Function(
        new Thing(new Text("thingName")),
        new Goal("someGoal"),
        new Text("functionName"),
        new LinkedHashSet<>(),
        new ReturnValue(createIoModelPrimitive()));
  }

  private Function createFunction2() {
    return new Function(
        new Thing(new Text("thingName")),
        new Goal("someGoal"),
        new Text("anotherFunctionName"),
        new LinkedHashSet<>(),
        new ReturnValue(createIoModelPrimitive()));
  }

  private Function createFunctionWithReturnValueAndNoArguments() {
    return new Function(
        new Thing(new Text("thingName")),
        new Goal("someGoal"),
        new Text("functionName"),
        new ReturnValue(createIoModelPrimitive()));
  }

  private Function createFunctionWithArgumentsAndNoReturnValue() {
    return new Function(
        new Thing(new Text("thingName")),
        new Goal("someGoal"),
        new Text("functionName"),
        new LinkedHashSet<>());
  }

  private IoModelPrimitive createIoModelPrimitive() {
    return new IoModelPrimitive(
        new Text("datatype"), new Text("variableName"), new LinkedHashSet<>());
  }
}
