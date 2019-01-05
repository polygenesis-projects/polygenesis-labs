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

import io.polygenesis.shared.valueobject.Text;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;

/**
 * Identifies functions of things in provided classes.
 *
 * @author Christos Tsakostas
 */
class FunctionIdentifier {

  private static final Logger LOG = LoggerFactory.getLogger(FunctionIdentifier.class);

  private final MethodAnalyzer methodAnalyzer;
  private final RecursiveObjectFiller recursiveObjectFiller;
  private final IoModelDeducer ioModelDeducer;

  // ===============================================================================================
  // CONSTRUCTOR(S)
  // ===============================================================================================

  /**
   * Instantiates a new Function identifier.
   *
   * @param methodAnalyzer the method analyzer
   * @param recursiveObjectFiller the recursive object filler
   * @param ioModelDeducer the io model deducer
   */
  FunctionIdentifier(
      MethodAnalyzer methodAnalyzer,
      RecursiveObjectFiller recursiveObjectFiller,
      IoModelDeducer ioModelDeducer) {
    this.methodAnalyzer = methodAnalyzer;
    this.recursiveObjectFiller = recursiveObjectFiller;
    this.ioModelDeducer = ioModelDeducer;
  }

  // ===============================================================================================
  // FUNCTIONALITY
  // ===============================================================================================

  /**
   * Identify functions of set.
   *
   * @param thing the thing
   * @param classes the classes
   * @return the set
   */
  Set<Function> identifyFunctionsOf(Thing thing, Set<Class<?>> classes) {
    Set<Function> functions = new LinkedHashSet<>();

    classes.forEach(clazz -> functions.addAll(identifyFunctionsOf(thing, clazz)));

    return functions;
  }

  // ===============================================================================================
  // PRIVATE
  // ===============================================================================================

  private Set<Function> identifyFunctionsOf(Thing thing, Class<?> clazz) {
    Set<Function> functions = new LinkedHashSet<>();

    Stream.of(clazz.getMethods())
        .forEach(
            method -> {
              Optional<Function> optionalFunction = this.identifyFunctionInMethod(thing, method);
              optionalFunction.ifPresent(functions::add);
            });

    return functions;
  }

  private Optional<Function> identifyFunctionInMethod(Thing thing, Method method) {
    GFunction annotationGFunction = AnnotationUtils.findAnnotation(method, GFunction.class);
    if (annotationGFunction != null) {
      Thing thingToExamine = new Thing(new Text(annotationGFunction.thingName()));

      if (thing.equals(thingToExamine)) {

        Goal goal = new Goal(annotationGFunction.goal());

        // =========================================================================================
        // METHOD OUTPUT
        // =========================================================================================
        MethodOutputDescriptor methodOutputDescriptor = methodAnalyzer.getMethodOutput(method);
        RecursiveObject output =
            recursiveObjectFiller.fillRecursiveObject(
                methodOutputDescriptor.getGenericType(),
                methodOutputDescriptor.getDataType(),
                "response",
                methodOutputDescriptor.getClazz(),
                null);

        ReturnValue returnValue = new ReturnValue(ioModelDeducer.deduceResponse(output));

        // =========================================================================================
        // METHOD INPUTS
        // =========================================================================================
        Set<Argument> arguments = new LinkedHashSet<>();

        Parameter[] parameters = method.getParameters();
        for (Parameter parameter : parameters) {
          // Maybe have to check if parameter name is present?

          MethodInputDescriptor methodInputDescriptor = methodAnalyzer.getMethodInput(parameter);

          RecursiveObject input =
              recursiveObjectFiller.fillRecursiveObject(
                  null,
                  methodInputDescriptor.getTypeName(),
                  methodInputDescriptor.getName(),
                  methodInputDescriptor.getType(),
                  null);

          LOG.info("{}", input);
          arguments.add(new Argument(ioModelDeducer.deduceResponse(input)));
        }

        Function function =
            new Function(thing, goal, identifyName(annotationGFunction), arguments, returnValue);

        return Optional.of(function);
      } else {
        return Optional.empty();
      }
    } else {
      return Optional.empty();
    }
  }

  /**
   * Identify name.
   *
   * @param annotationGFunction the annotation {@link GFunction}
   * @return the name as {@link Text}
   */
  private Text identifyName(GFunction annotationGFunction) {
    String name = annotationGFunction.name();

    if (name.equals("")) {
      return new Text(
          new Text(annotationGFunction.goal()).getLowerCamel()
              + new Text(annotationGFunction.thingName()).getUpperCamel());
    }

    return new Text(name);
  }
}
