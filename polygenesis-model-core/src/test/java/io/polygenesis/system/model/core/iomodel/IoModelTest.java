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

package io.polygenesis.system.model.core.iomodel;

import static org.assertj.core.api.Assertions.assertThat;

import io.polygenesis.shared.valueobject.Text;
import io.polygenesis.system.model.core.AbstractEqualityTest;
import org.junit.Test;

/** @author Christos Tsakostas */
public class IoModelTest extends AbstractEqualityTest<TestIoModel> {

  @Test
  public void shouldInitializeTestIoModel() {
    IoModelGroup parent =
        new IoModelGroup(
            new Text("java.util.list"), new Text("java.lang.String"), new Text("someVariableName"));

    TestIoModel testIoModel =
        new TestIoModel(new Text("java.lang.String"), new Text("someVariableName"), parent);

    assertThat(testIoModel).isNotNull();
    assertThat(testIoModel.getGenericType()).isNull();
    assertThat(testIoModel.getDataType()).isEqualTo(new Text("java.lang.String"));
    assertThat(testIoModel.getVariableName()).isEqualTo(new Text("someVariableName"));
  }

  // ===============================================================================================
  // Equality and Hash
  // ===============================================================================================
  @Override
  public TestIoModel createObject1() {
    return new TestIoModel(new Text("genericType"), new Text("dataType"), new Text("variableName"));
  }

  @Override
  public TestIoModel createObject2() {
    return new TestIoModel(
        new Text("genericType"), new Text("dataType"), new Text("someOtherVariableName"));
  }
}
