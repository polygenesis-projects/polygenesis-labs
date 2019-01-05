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

package io.polygenesis.system;

/**
 * The type Deducer request.
 *
 * @author Christos Tsakostas
 */
public abstract class DeducerRequest {

  private CoreModelRepository coreModelRepository;

  // ===============================================================================================
  // CONSTRUCTOR(S)
  // ===============================================================================================

  /**
   * Instantiates a new Deducer request.
   *
   * @param coreModelRepository the core model repository
   */
  public DeducerRequest(CoreModelRepository coreModelRepository) {
    setCoreModelRepository(coreModelRepository);
  }

  // ===============================================================================================
  // GETTERS
  // ===============================================================================================

  /**
   * Gets core model repository.
   *
   * @return the core model repository
   */
  public CoreModelRepository getCoreModelRepository() {
    return coreModelRepository;
  }

  // ===============================================================================================
  // GUARDS
  // ===============================================================================================

  private void setCoreModelRepository(CoreModelRepository coreModelRepository) {
    this.coreModelRepository = coreModelRepository;
  }
}
