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
public class ReturnValueTest extends AbstractEqualityTest<ReturnValue> {

  @Test
  public void shouldSucceedToInstantiate() {
    ReturnValue returnValue = new ReturnValue(createIoModelPrimitive1());

    assertThat(returnValue).isNotNull();
    assertThat(returnValue.getModel()).isEqualTo(createIoModelPrimitive1());
  }

  private IoModelPrimitive createIoModelPrimitive1() {
    return new IoModelPrimitive(
        new Text("java.lang.String"), new Text("someVariableName"), new LinkedHashSet<>());
  }

  private IoModelPrimitive createIoModelPrimitive2() {
    return new IoModelPrimitive(
        new Text("java.lang.String"), new Text("someOtherVariableName"), new LinkedHashSet<>());
  }

  @Override
  public ReturnValue createObject1() {
    return new ReturnValue(createIoModelPrimitive1());
  }

  @Override
  public ReturnValue createObject2() {
    return new ReturnValue(createIoModelPrimitive2());
  }
}
