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
import java.util.Set;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * In the context of automatic programming, Function is defined as an activity expressing what has
 * to be done, the {@link GoalType}, written by a programmer in a specific programming language to
 * or the purpose of a {@link Thing} characterized by a Name, and Properties provided as
 * activity&rsquo;s optional arguments and return value.
 *
 * @author Christos Tsakostas
 */
public class Function {

  /** The {@link Thing} the Function belongs to. */
  private Thing thing;

  /** The {@link GoalType} of the Function. */
  private GoalType goalType;

  /**
   * The name of the Function.
   *
   * <p>It will be used in code generation.
   */
  private Text name;

  /** Optional return value of the Function. */
  private ReturnValue returnValue;

  /** Optional arguments of the Function. */
  private Set<Argument> arguments;

  // ===============================================================================================
  // CONSTRUCTOR(S)
  // ===============================================================================================

  private Function(Thing thing, GoalType goalType, Text name) {
    setThing(thing);
    setGoalType(goalType);
    setName(name);
  }

  /**
   * Instantiates a new Function with ReturnValue.
   *
   * @param thing the thing
   * @param goalType the goalType
   * @param name the name
   * @param returnValue the return value
   */
  public Function(Thing thing, GoalType goalType, Text name, ReturnValue returnValue) {
    this(thing, goalType, name);
    setReturnValue(returnValue);
  }

  /**
   * Instantiates a new Function with Arguments.
   *
   * @param thing the thing
   * @param goalType the goalType
   * @param name the name
   * @param arguments the arguments
   */
  public Function(Thing thing, GoalType goalType, Text name, Set<Argument> arguments) {
    this(thing, goalType, name);
    setArguments(arguments);
  }

  /**
   * Instantiates a new Function with ReturnValue and Arguments.
   *
   * @param thing the thing
   * @param goalType the goalType
   * @param name the name
   * @param arguments the arguments
   * @param returnValue the return value
   */
  public Function(
      Thing thing, GoalType goalType, Text name, Set<Argument> arguments, ReturnValue returnValue) {
    this(thing, goalType, name, arguments);
    setReturnValue(returnValue);
  }

  // ===============================================================================================
  // GETTERS
  // ===============================================================================================

  /**
   * Gets thing.
   *
   * @return the thing
   */
  public Thing getThing() {
    return thing;
  }

  /**
   * Gets goalType.
   *
   * @return the goalType
   */
  public GoalType getGoalType() {
    return goalType;
  }

  /**
   * Gets name.
   *
   * @return the name
   */
  public Text getName() {
    return name;
  }

  /**
   * Gets return value.
   *
   * @return the return value
   */
  public ReturnValue getReturnValue() {
    return returnValue;
  }

  /**
   * Gets arguments.
   *
   * @return the arguments
   */
  public Set<Argument> getArguments() {
    return arguments;
  }

  // ===============================================================================================
  // GUARDS
  // ===============================================================================================

  private void setThing(Thing thing) {
    this.thing = thing;
  }

  private void setGoalType(GoalType goalType) {
    this.goalType = goalType;
  }

  private void setName(Text name) {
    this.name = name;
  }

  private void setReturnValue(ReturnValue returnValue) {
    this.returnValue = returnValue;
  }

  private void setArguments(Set<Argument> arguments) {
    this.arguments = arguments;
  }

  // ===============================================================================================
  // OVERRIDES
  // ===============================================================================================

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Function function = (Function) o;

    return new EqualsBuilder()
        .append(thing, function.thing)
        .append(goalType, function.goalType)
        .append(name, function.name)
        .append(returnValue, function.returnValue)
        .append(arguments, function.arguments)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
        .append(thing)
        .append(goalType)
        .append(name)
        .append(returnValue)
        .append(arguments)
        .toHashCode();
  }
}
