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

package io.polygenesis.system.registry;

import io.polygenesis.system.Deducer;
import io.polygenesis.system.Generator;
import io.polygenesis.system.Model;
import io.polygenesis.system.model.core.CoreDeducer;
import io.polygenesis.system.model.core.CoreModel;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * The PolyGenesis Registry holds a reference to all of the models, deducers and generators.
 *
 * <p>PolyGenesis is extensible. You can implement your custom {@link Model}, {@link Deducer} or
 * {@link Generator} and register it in the Registry, so it/they can be available at the generation
 * process.
 *
 * @author Christos Tsakostas
 */
public final class Registry {

  private static Set<Model> models;
  private static Set<Deducer> deducers;
  private static Set<Generator> generators;

  // ===============================================================================================
  // SINGLETON
  // ===============================================================================================
  private static final Registry instance;

  static {
    instance = new Registry(initializeModels(), initializeDeducers(), initializeGenerators());
  }

  /**
   * Gets the Registry instance.
   *
   * @return the instance
   */
  public static Registry getInstance() {
    return instance;
  }

  private static Set<Model> initializeModels() {
    Set<Model> models = new LinkedHashSet<>();

    models.add(new CoreModel());

    return models;
  }

  private static Set<Deducer> initializeDeducers() {
    Set<Deducer> deducers = new LinkedHashSet<>();

    return deducers;
  }

  private static Set<Generator> initializeGenerators() {
    return new LinkedHashSet<>();
  }

  // ===============================================================================================
  // CONSTRUCTOR(S)
  // ===============================================================================================

  /**
   * Instantiates a new Registry.
   *
   * @param models the models
   * @param deducers the deducers
   * @param generators the generators
   */
  private Registry(Set<Model> models, Set<Deducer> deducers, Set<Generator> generators) {
    setModels(models);
    setDeducers(deducers);
    setGenerators(generators);
  }

  // ===============================================================================================
  // COMMANDS
  // ===============================================================================================

  // ===============================================================================================
  // QUERIES
  // ===============================================================================================

  /**
   * Gets core deducer.
   *
   * @return the core deducer
   */
  public CoreDeducer getCoreDeducer() {
    return ServiceRegistry.getCoreDeducer();
  }

  // ===============================================================================================
  // GETTERS
  // ===============================================================================================

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
  // GUARDS
  // ===============================================================================================
  private void setModels(Set<Model> models) {
    this.models = models;
  }

  private void setDeducers(Set<Deducer> deducers) {
    this.deducers = deducers;
  }

  private void setGenerators(Set<Generator> generators) {
    this.generators = generators;
  }
}
