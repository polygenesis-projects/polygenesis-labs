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

/**
 * One of the most essential parts of PolyGenesis is the GoalType. Based on the GoalType, deducers
 * are able to instantiate the technology models.
 *
 * <p>It is highly preferable to use one of the constants provided at {@link GoalStandardType}, in
 * order to instantiate a GoalType.
 *
 * <p>For the rare cases that available types in {@link GoalStandardType} are not adequate to
 * describe your goal, it is possible to pass any goal type as string.
 *
 * <p>Be aware though, that PolyGenesis will not be able to use your custom goal and it is your
 * responsibility to utilize it in your generators, deducers and instantiation of technology models.
 *
 * @author Christos Tsakostas
 */
public class GoalType extends Text {

  // ===============================================================================================
  // CONSTRUCTOR(S)
  // ===============================================================================================

  /**
   * Instantiates a new GoalType.
   *
   * @param goalType the goal type
   */
  public GoalType(String goalType) {
    super(goalType);
  }
}
