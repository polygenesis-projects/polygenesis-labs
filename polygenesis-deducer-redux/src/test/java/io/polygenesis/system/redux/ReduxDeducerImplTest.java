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

package io.polygenesis.system.redux;

import static org.assertj.core.api.Assertions.assertThat;

import io.polygenesis.system.CoreModelRepository;
import io.polygenesis.system.model.core.CoreModelRepositoryImpl;
import java.util.LinkedHashSet;
import org.junit.Test;

/** @author Christos Tsakostas */
public class ReduxDeducerImplTest {

  @Test
  public void deduce() {
    ReduxStoreDeducer reduxStoreDeducer = new ReduxStoreDeducer();
    ReduxDeducer reduxDeducer = new ReduxDeducerImpl(reduxStoreDeducer);
    CoreModelRepository coreModelRepository = new CoreModelRepositoryImpl(new LinkedHashSet<>());

    ReduxRepository reduxRepository = reduxDeducer.deduce(coreModelRepository);

    assertThat(reduxRepository).isNotNull();
    assertThat(reduxRepository.getStores()).isNotNull();
    assertThat(reduxRepository.getStores().size()).isEqualTo(0);
  }
}
