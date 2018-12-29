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

import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.Test;

/** @author Christos Tsakostas */
public class ClassScannerTest {

  @Test
  public void identify() {
    ClassScanner classScanner = new ClassScanner();

    Set<String> packages = new LinkedHashSet<>();
    packages.add("io.polygenesis.system.model.core.sample");
    Set<Class<?>> classes =
        classScanner.identify(packages, new LinkedHashSet<>(), InclusionOrExclusionType.NONE);

    assertThat(classes).isNotNull();
    assertThat(classes.size()).isEqualTo(6);
  }

  @Test
  public void identifyWithIncludedInterfaces() {
    ClassScanner classScanner = new ClassScanner();

    Set<String> packages = new LinkedHashSet<>();
    packages.add("io.polygenesis.system.model.core.sample");

    Set<String> includedInterfaces = new LinkedHashSet<>();
    includedInterfaces.add("io.polygenesis.system.model.core.sample.IncludedService");

    Set<Class<?>> classes =
        classScanner.identify(packages, includedInterfaces, InclusionOrExclusionType.INCLUDE);

    assertThat(classes).isNotNull();
    assertThat(classes.size()).isEqualTo(1);
  }

  @Test
  public void identifyWithExcludedInterfaces() {
    ClassScanner classScanner = new ClassScanner();

    Set<String> packages = new LinkedHashSet<>();
    packages.add("io.polygenesis.system.model.core.sample");

    Set<String> excludedInterfaces = new LinkedHashSet<>();
    excludedInterfaces.add("io.polygenesis.system.model.core.sample.ExcludedService");

    Set<Class<?>> classes =
        classScanner.identify(packages, excludedInterfaces, InclusionOrExclusionType.EXCLUDE);

    assertThat(classes).isNotNull();
    assertThat(classes.size()).isEqualTo(5);
  }
}
