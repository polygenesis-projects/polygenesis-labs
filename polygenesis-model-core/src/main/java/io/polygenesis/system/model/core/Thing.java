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

  private Set<Function> functions;

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
    setFunctions(new LinkedHashSet<>());
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
    setFunctions(new LinkedHashSet<>());
  }

  // ===============================================================================================
  // APPENDERS
  // ===============================================================================================

  /**
   * Append function.
   *
   * @param function the function
   */
  void appendFunction(Function function) {
    this.functions.add(function);
  }

  /**
   * Append functions.
   *
   * @param functions the functions
   */
  void appendFunctions(Set<Function> functions) {
    this.functions.addAll(functions);
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
   * Gets functions.
   *
   * @return the functions
   */
  Set<Function> getFunctions() {
    return functions;
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

  private void setFunctions(Set<Function> functions) {
    this.functions = functions;
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
