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
public class DataTypeConverterTest {

  @Test
  public void shouldConvert() {
    DataTypeConverter dataTypeConverter = new DataTypeConverter();

    assertThat(dataTypeConverter.convert("void")).isEqualTo(DataType.VOID);
    assertThat(dataTypeConverter.convert("java.lang.String")).isEqualTo(DataType.STRING);
    assertThat(dataTypeConverter.convert("int")).isEqualTo(DataType.INTEGER);
    assertThat(dataTypeConverter.convert("java.lang.Integer")).isEqualTo(DataType.INTEGER);
    assertThat(dataTypeConverter.convert("long")).isEqualTo(DataType.LONG);
    assertThat(dataTypeConverter.convert("java.lang.Long")).isEqualTo(DataType.LONG);
    assertThat(dataTypeConverter.convert("boolean")).isEqualTo(DataType.BOOLEAN);
    assertThat(dataTypeConverter.convert("java.lang.Boolean")).isEqualTo(DataType.BOOLEAN);
    assertThat(dataTypeConverter.convert("java.util.List")).isEqualTo(DataType.ARRAY);
  }

  @Test
  public void shouldFailToConvert() {
    DataTypeConverter dataTypeConverter = new DataTypeConverter();

    assertThatThrownBy(() -> dataTypeConverter.convert("abc"))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
