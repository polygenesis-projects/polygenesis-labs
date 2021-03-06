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

package io.polygenesis.system.model.core.sample;

import io.polygenesis.system.model.core.GGoal;
import io.polygenesis.system.model.core.GGoalStandardType;
import java.util.List;
import org.springframework.data.domain.Page;

/** @author Christos Tsakostas */
public interface TestService {

  String THING_NAME = "someThing";

  @GGoal(goal = GGoalStandardType.QRY_CALCULATION, thingName = THING_NAME)
  int add(int a, int b);

  @GGoal(goal = GGoalStandardType.QRY_COLLECTION, thingName = THING_NAME)
  List<String> getListOfString(String input);

  @GGoal(goal = GGoalStandardType.QRY_COLLECTION, thingName = THING_NAME)
  void passListOfString(List<String> input);

  @GGoal(goal = GGoalStandardType.QRY_COLLECTION, thingName = THING_NAME)
  List<CollectionDto> getListOfCollectionDto(String input);

  @GGoal(goal = GGoalStandardType.QRY_COLLECTION, thingName = THING_NAME)
  Page<CollectionDto> getSpringPageCollectionDto(String input);

  @GGoal(goal = GGoalStandardType.QRY_COLLECTION, thingName = THING_NAME)
  CollectionApiPageResponse getCollectionApiPageResponse(CollectionApiPageRequest request);

  @GGoal(goal = GGoalStandardType.CMD_CREATE, thingName = THING_NAME)
  CreateResponse create(CreateRequest request);
}
