/*-
 * ========================LICENSE_START=================================
 * PolyGenesis System
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Copyright (C) 2015 - 2019 OREGOR LTD
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

package io.polygenesis.system.model.core.sample;

import java.io.Serializable;

/** @author Christos Tsakostas */
public class SearchCriterion implements Serializable {

  protected static final long serialVersionUID = 1L;

  private String key;

  private String operation;

  private Object value;

  public SearchCriterion() {
    super();
  }

  public SearchCriterion(final String key, final String operation, final Object value) {
    super();
    this.key = key;
    this.operation = operation;
    this.value = value;
  }

  public String getKey() {
    return key;
  }

  public void setKey(final String key) {
    this.key = key;
  }

  public String getOperation() {
    return operation;
  }

  public void setOperation(final String operation) {
    this.operation = operation;
  }

  public Object getValue() {
    return value;
  }

  public void setValue(final Object value) {
    this.value = value;
  }
}
