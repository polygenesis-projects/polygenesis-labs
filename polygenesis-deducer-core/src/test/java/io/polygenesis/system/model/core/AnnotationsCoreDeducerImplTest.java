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
import io.polygenesis.system.CoreModelRepository;
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
  private GoalIdentifier goalIdentifier;
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
    goalIdentifier = new GoalIdentifier(methodAnalyzer, recursiveObjectFiller, ioModelDeducer);
    coreDeducer = new AnnotationsCoreDeducerImpl(classScanner, thingScanner, goalIdentifier);
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

    assertThat(someThing.getGoals().size()).isEqualTo(7);

    assertionsForGoalCalculation(someThing);
  }

  // ===============================================================================================
  // ASSERTIONS FOR THING METHOD: ADD / CALCULATION
  // ===============================================================================================
  private void assertionsForGoalCalculation(Thing someThing) {
    Optional<Goal> optionalGoalCalculation =
        repository.getThingGoal(someThing.getName(), new Text("calculationSomeThing"));

    if (!optionalGoalCalculation.isPresent()) {
      throw new IllegalStateException();
    }

    Goal goalCalculation = optionalGoalCalculation.get();

    assertThat(goalCalculation.getReturnValue()).isNotNull();
    assertThat(goalCalculation.getArguments().size()).isEqualTo(2);
  }
}
