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

import io.polygenesis.system.model.core.AnnotationsCoreDeducerImpl;
import io.polygenesis.system.model.core.ClassScanner;
import io.polygenesis.system.model.core.CoreDeducer;
import io.polygenesis.system.model.core.DataTypeConverter;
import io.polygenesis.system.model.core.FieldsInInterfaceMethodAnalyzer;
import io.polygenesis.system.model.core.GoalIdentifier;
import io.polygenesis.system.model.core.IoModelDeducer;
import io.polygenesis.system.model.core.MethodAnalyzer;
import io.polygenesis.system.model.core.RecursiveObjectFiller;
import io.polygenesis.system.model.core.ThingScanner;
import io.polygenesis.system.model.core.TypesAnalyzer;
import io.polygenesis.system.redux.ReduxDeducer;
import io.polygenesis.system.redux.ReduxDeducerImpl;
import io.polygenesis.system.redux.ReduxStoreDeducer;

/**
 * Singletons of PolyGenesis Services and Components.
 *
 * @author Christos Tsakostas
 */
final class ServiceRegistry {

  private ServiceRegistry() {
    throw new IllegalStateException("Utility class");
  }

  private static ClassScanner classScanner;
  private static ThingScanner thingScanner;
  private static MethodAnalyzer methodAnalyzer;
  private static TypesAnalyzer typesAnalyzer;
  private static FieldsInInterfaceMethodAnalyzer fieldsInInterfaceMethodAnalyzer;
  private static RecursiveObjectFiller recursiveObjectFiller;
  private static DataTypeConverter dataTypeConverter;
  private static IoModelDeducer ioModelDeducer;
  private static GoalIdentifier goalIdentifier;
  private static CoreDeducer coreDeducer;

  // REDUX
  private static ReduxStoreDeducer reduxStoreDeducer;
  private static ReduxDeducer reduxDeducer;

  static {
    classScanner = new ClassScanner();

    thingScanner = new ThingScanner();

    methodAnalyzer = new MethodAnalyzer();

    typesAnalyzer = new TypesAnalyzer();

    fieldsInInterfaceMethodAnalyzer = new FieldsInInterfaceMethodAnalyzer();

    recursiveObjectFiller =
        new RecursiveObjectFiller(typesAnalyzer, fieldsInInterfaceMethodAnalyzer);

    dataTypeConverter = new DataTypeConverter();

    ioModelDeducer = new IoModelDeducer(dataTypeConverter);

    goalIdentifier = new GoalIdentifier(methodAnalyzer, recursiveObjectFiller, ioModelDeducer);

    coreDeducer = new AnnotationsCoreDeducerImpl(classScanner, thingScanner, goalIdentifier);

    // REDUX
    reduxStoreDeducer = new ReduxStoreDeducer();
    reduxDeducer = new ReduxDeducerImpl(reduxStoreDeducer);
  }

  // ===============================================================================================
  // GETTERS
  // ===============================================================================================

  /**
   * Gets core deducer.
   *
   * @return the core deducer
   */
  public static CoreDeducer getCoreDeducer() {
    return coreDeducer;
  }

  /**
   * Gets redux deducer.
   *
   * @return the redux deducer
   */
  public static ReduxDeducer getReduxDeducer() {
    return reduxDeducer;
  }
}
