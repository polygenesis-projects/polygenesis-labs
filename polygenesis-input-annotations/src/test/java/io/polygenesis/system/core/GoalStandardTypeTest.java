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

package io.polygenesis.system.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import io.polygenesis.system.model.core.GoalStandardType;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.junit.Test;

/** @author Christos Tsakostas */
public class GoalStandardTypeTest {

  @Test
  public void shouldFailToInstantiate() throws NoSuchMethodException {
    Constructor<GoalStandardType> constructor = GoalStandardType.class.getDeclaredConstructor();
    constructor.setAccessible(true);

    assertThatThrownBy(() -> constructor.newInstance())
        .isInstanceOf(InvocationTargetException.class);
  }

  @Test
  public void shouldSucceed() {
    assertThat(GoalStandardType.CMD_CREATE).isEqualTo("CREATE");
    assertThat(GoalStandardType.CMD_UPDATE).isEqualTo("UPDATE");
    assertThat(GoalStandardType.CMD_DELETE).isEqualTo("DELETE");
    assertThat(GoalStandardType.CMD_RESET).isEqualTo("RESET");

    assertThat(GoalStandardType.QRY_DETAIL).isEqualTo("DETAIL");
    assertThat(GoalStandardType.QRY_COLLECTION).isEqualTo("COLLECTION");
    assertThat(GoalStandardType.QRY_VALIDATION).isEqualTo("VALIDATION");
    assertThat(GoalStandardType.QRY_CALCULATION).isEqualTo("CALCULATION");
  }
}
