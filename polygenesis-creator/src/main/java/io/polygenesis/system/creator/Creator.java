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

package io.polygenesis.system.creator;

import io.polygenesis.shared.assertion.Assertion;
import io.polygenesis.system.CoreModelRepository;
import io.polygenesis.system.Deducer;
import io.polygenesis.system.Generator;
import io.polygenesis.system.Model;
import io.polygenesis.system.model.core.CoreDeducer;
import io.polygenesis.system.model.core.CoreDeducerRequest;
import io.polygenesis.system.registry.Registry;
import java.util.Set;

/**
 * The entry point to code generation.
 *
 * @author Christos Tsakostas
 */
public class Creator {

  private CoreDeducer coreDeducer;
  private Set<Model> models;
  private Set<Deducer> deducers;
  private Set<Generator> generators;

  // ===============================================================================================
  // SINGLETON
  // ===============================================================================================
  private static final Creator instance;

  static {
    instance =
        new Creator(
            Registry.getInstance().getCoreDeducer(),
            Registry.getInstance().getModels(),
            Registry.getInstance().getDeducers(),
            Registry.getInstance().getGenerators());
  }

  /**
   * Gets the Creator instance.
   *
   * @return the instance
   */
  public static Creator getInstance() {
    return instance;
  }

  // ===============================================================================================
  // CONSTRUCTOR(S)
  // ===============================================================================================

  /**
   * Instantiates a new Creator.
   *
   * @param coreDeducer the core deducer
   * @param models the models
   * @param deducers the deducers
   * @param generators the generators
   */
  public Creator(
      CoreDeducer coreDeducer,
      Set<Model> models,
      Set<Deducer> deducers,
      Set<Generator> generators) {
    this.coreDeducer = coreDeducer;
    this.models = models;
    this.deducers = deducers;
    this.generators = generators;
  }

  // ===============================================================================================
  // FUNCTIONALITY
  // ===============================================================================================

  /**
   * Generate.
   *
   * @param request the request
   */
  public void generate(CreatorRequest request) {
    Assertion.isNotNull(request, "request is required");
    Assertion.isNotNull(request.getPackagesToScan(), "Packages To Scan is required");
    Assertion.isNotEmpty(
        request.getLocalMachineGenerationPath(), "Local Machine Generation Path is required");

    CoreModelRepository coreModelRepository = coreDeducer.deduce(makeCoreDeducerRequest(request));

    runDeducers(coreModelRepository);
  }

  /** Run deducers. @param coreModelRepository the core model repository */
  public void runDeducers(CoreModelRepository coreModelRepository) {
    deducers.forEach(deducer -> deducer.deduce(coreModelRepository));
  }

  // ===============================================================================================
  // GETTERS
  // ===============================================================================================

  /**
   * Gets core deducer.
   *
   * @return the core deducer
   */
  public CoreDeducer getCoreDeducer() {
    return coreDeducer;
  }

  /**
   * Gets models.
   *
   * @return the models
   */
  public Set<Model> getModels() {
    return models;
  }

  /**
   * Gets deducers.
   *
   * @return the deducers
   */
  public Set<Deducer> getDeducers() {
    return deducers;
  }

  /**
   * Gets generators.
   *
   * @return the generators
   */
  public Set<Generator> getGenerators() {
    return generators;
  }

  // ===============================================================================================
  // PRIVATE
  // ===============================================================================================

  private CoreDeducerRequest makeCoreDeducerRequest(CreatorRequest request) {
    if (request.getInterfacesExcluded().isEmpty() && request.getInterfacesExcluded().isEmpty()) {
      return new CoreDeducerRequest(request.getPackagesToScan());
    } else {
      throw new UnsupportedOperationException();
    }
  }
}
