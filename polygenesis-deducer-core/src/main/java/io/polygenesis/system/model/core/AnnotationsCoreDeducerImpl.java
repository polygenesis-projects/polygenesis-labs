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

package io.polygenesis.system.model.core;

import java.util.Set;

/**
 * Currently, the only way to deduce the Core Model is by Java Annotations.
 *
 * <p>Alternatively, you can manually instantiate the Core Model with PolyGenesis DSL.
 *
 * @author Christos Tsakostas
 */
public class AnnotationsCoreDeducerImpl implements CoreDeducer {

  private final ClassScanner classScanner;
  private final ThingScanner thingScanner;
  private final FunctionIdentifier functionIdentifier;

  // ===============================================================================================
  // CONSTRUCTOR(S)
  // ===============================================================================================

  /**
   * Instantiates a new Annotations core deducer.
   *
   * @param classScanner the class scanner
   * @param thingScanner the thing scanner
   * @param functionIdentifier the function identifier
   */
  public AnnotationsCoreDeducerImpl(
      ClassScanner classScanner, ThingScanner thingScanner, FunctionIdentifier functionIdentifier) {
    this.classScanner = classScanner;
    this.thingScanner = thingScanner;
    this.functionIdentifier = functionIdentifier;
  }

  // ===============================================================================================
  // OVERRIDES
  // ===============================================================================================

  @Override
  public CoreModelRepository deduce(CoreDeducerRequest request) {
    Set<Class<?>> classes =
        classScanner.identify(
            request.getPackagesToScan(),
            request.getInterfaces(),
            request.getInterfacesInclusionOrExclusionType());

    Set<Thing> things = thingScanner.identifyThingsInInterfaces(classes);

    things.forEach(
        thing -> thing.appendFunctions(functionIdentifier.identifyFunctionsOf(thing, classes)));

    return new CoreModelRepository(things);
  }
}
