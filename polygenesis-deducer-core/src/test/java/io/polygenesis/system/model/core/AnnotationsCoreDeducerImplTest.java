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

import static org.assertj.core.api.Assertions.assertThat;

import io.polygenesis.shared.valueobject.Text;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;

/** @author Christos Tsakostas */
public class AnnotationsCoreDeducerImplTest {

  private ClassScanner classScanner;
  private ThingScanner thingScanner;
  private MethodAnalyzer methodAnalyzer;
  private TypesAnalyzer typesAnalyzer;
  private FieldsInInterfaceMethodAnalyzer fieldsInInterfaceMethodAnalyzer;
  private RecursiveObjectFiller recursiveObjectFiller;
  private DataTypeConverter dataTypeConverter;
  private IoModelDeducer ioModelDeducer;
  private FunctionIdentifier functionIdentifier;
  private CoreDeducer coreDeducer;
  private CoreModelRepository repository;

  @Before
  public void setUp() {
    classScanner = new ClassScanner();
    thingScanner = new ThingScanner();
    methodAnalyzer = new MethodAnalyzer();
    typesAnalyzer = new TypesAnalyzer();
    fieldsInInterfaceMethodAnalyzer = new FieldsInInterfaceMethodAnalyzer();
    recursiveObjectFiller =
        new RecursiveObjectFiller(typesAnalyzer, fieldsInInterfaceMethodAnalyzer);
    dataTypeConverter = new DataTypeConverter();
    ioModelDeducer = new IoModelDeducer(dataTypeConverter);
    functionIdentifier =
        new FunctionIdentifier(methodAnalyzer, recursiveObjectFiller, ioModelDeducer);
    coreDeducer = new AnnotationsCoreDeducerImpl(classScanner, thingScanner, functionIdentifier);
  }

  @Test
  public void deduce() {
    Set<String> packages = new LinkedHashSet<>();
    packages.add("io.polygenesis.system.model.core.sample");

    Set<String> interfaces = new LinkedHashSet<>();
    interfaces.add("io.polygenesis.system.model.core.sample.TestService");

    CoreDeducerRequest request =
        new CoreDeducerRequest(packages, interfaces, InclusionOrExclusionType.INCLUDE);

    repository = coreDeducer.deduce(request);

    // =============================================================================================
    // BASIC ASSERTIONS
    // =============================================================================================
    assertThat(repository).isNotNull();
    assertThat(repository.getThings()).isNotNull();
    assertThat(repository.getThings().size()).isEqualTo(1);
    assertThat(repository.getThingByName(new Text("someThing"))).isPresent();

    // =============================================================================================
    // ASSERTIONS FOR THING: SOMETHING
    // =============================================================================================
    Optional<Thing> optionalSomeThing = repository.getThingByName(new Text("someThing"));
    if (!optionalSomeThing.isPresent()) {
      throw new IllegalStateException();
    }

    Thing someThing = optionalSomeThing.get();

    assertThat(someThing.getFunctions().size()).isEqualTo(7);

    assertionsForFunctionCalculation(someThing);
  }

  // ===============================================================================================
  // ASSERTIONS FOR THING METHOD: ADD / CALCULATION
  // ===============================================================================================
  private void assertionsForFunctionCalculation(Thing someThing) {
    Optional<Function> optionalFunctionCalculation =
        repository.getThingFunction(someThing.getName(), new Text("calculationSomeThing"));

    if (!optionalFunctionCalculation.isPresent()) {
      throw new IllegalStateException();
    }

    Function functionCalculation = optionalFunctionCalculation.get();

    assertThat(functionCalculation.getReturnValue()).isNotNull();
    assertThat(functionCalculation.getArguments().size()).isEqualTo(2);
  }
}
