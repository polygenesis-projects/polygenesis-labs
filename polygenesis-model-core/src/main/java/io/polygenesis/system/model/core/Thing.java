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
import java.util.LinkedHashSet;
import java.util.Set;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * {@link Thing} is defined as a concept or an entity on or for which a {@link GoalType} is defined.
 * Most commonly, the names of the domain business concepts will be defined as things, being
 * concrete entities or more abstract concepts.
 *
 * <p>Therefore, a {@link Thing} can be anything that makes sense to code generation.
 *
 * <p>Example of concrete business concepts: Customer, User, LoginContext etc.
 *
 * <p>Example of more abstract concepts: Sum calculation etc.
 *
 * @author Christos Tsakostas
 */
public class Thing {

  /** The name of a {@link Thing}. */
  private Text name;

  /** Optionally a {@link Thing} may be the child of another {@link Thing} acting as the parent. */
  private Thing parent;

  private Set<Goal> goals;

  // ===============================================================================================
  // CONSTRUCTOR(S)
  // ===============================================================================================

  /**
   * Instantiates a new Thing.
   *
   * @param thingName the thing name
   */
  public Thing(Text thingName) {
    setName(thingName);
    setGoals(new LinkedHashSet<>());
  }

  /**
   * Instantiates a new Thing with parent.
   *
   * @param thingName the thing name
   * @param parentThing the parent thing
   */
  public Thing(Text thingName, Thing parentThing) {
    setName(thingName);
    setParent(parentThing);
    setGoals(new LinkedHashSet<>());
  }

  // ===============================================================================================
  // APPENDERS
  // ===============================================================================================

  /**
   * Append goal.
   *
   * @param goal the goal
   */
  void appendGoal(Goal goal) {
    this.goals.add(goal);
  }

  /**
   * Append goals.
   *
   * @param goals the goals
   */
  void appendGoals(Set<Goal> goals) {
    this.goals.addAll(goals);
  }

  // ===============================================================================================
  // GETTERS
  // ===============================================================================================

  /**
   * Gets name.
   *
   * @return the name
   */
  public Text getName() {
    return name;
  }

  /**
   * Gets parent.
   *
   * @return the parent
   */
  public Thing getParent() {
    return parent;
  }

  /**
   * Gets goals.
   *
   * @return the goals
   */
  Set<Goal> getGoals() {
    return goals;
  }

  // ===============================================================================================
  // GUARDS
  // ===============================================================================================

  private void setName(Text name) {
    this.name = name;
  }

  private void setParent(Thing parent) {
    this.parent = parent;
  }

  private void setGoals(Set<Goal> goals) {
    this.goals = goals;
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

    Thing thing = (Thing) o;

    return new EqualsBuilder().append(name, thing.name).append(parent, thing.parent).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37).append(name).append(parent).toHashCode();
  }
}
