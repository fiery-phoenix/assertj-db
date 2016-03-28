/**
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2015 the original author or authors.
 */
package org.assertj.db.api.assertions.impl;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.WritableAssertionInfo;
import org.assertj.db.api.TableAssert;
import org.assertj.db.common.AbstractTest;
import org.assertj.db.type.Table;
import org.junit.Test;

import static org.assertj.db.api.Assertions.assertThat;
import static org.junit.Assert.fail;

/**
 * Tests on {@link  AssertionsOnValueCloseness} class :
 * {@link  AssertionsOnValueCloseness#isCloseTo(org.assertj.db.api.AbstractAssert, org.assertj.core.api.WritableAssertionInfo, org.assertj.db.type.Value, Number, Number)} method.
 *
 * @author Régis Pouiller
 *
 */
public class AssertionsOnValueCloseness_IsCloseTo_Number_Test extends AbstractTest {

  /**
   * This method tests the {@code isCloseTo} assertion method.
   */
  @Test
  public void test_is_close_to() throws Exception {
    WritableAssertionInfo info = new WritableAssertionInfo();
    Table table = new Table();
    TableAssert tableAssert = assertThat(table);
    TableAssert tableAssert2 = AssertionsOnValueCloseness.isCloseTo(tableAssert, info, getValue(null, 8), 9, 1);
    Assertions.assertThat(tableAssert2).isSameAs(tableAssert);
    tableAssert2 = AssertionsOnValueCloseness.isCloseTo(tableAssert, info, getValue(null, null), (Number) null, 1);
    Assertions.assertThat(tableAssert2).isSameAs(tableAssert);
  }

  /**
   * This method should fail because the value is not close to.
   */
  @Test
  public void should_fail_because_value_is_not_close_to() throws Exception {
    WritableAssertionInfo info = new WritableAssertionInfo();
    info.description("description");
    Table table = new Table();
    TableAssert tableAssert = assertThat(table);
    try {
      AssertionsOnValueCloseness.isCloseTo(tableAssert, info, getValue(null, 9), 8, 0.5);
      fail("An exception must be raised");
    } catch (AssertionError e) {
      Assertions.assertThat(e.getMessage()).isEqualTo(String.format("[description] %n"
                                                                    + "Expecting:%n"
                                                                    + "  <9>%n"
                                                                    + "to be close to: %n"
                                                                    + "  <8> %n"
                                                                    + " with tolerance <0.5>"));
    }
    try {
      AssertionsOnValueCloseness.isCloseTo(tableAssert, info, getValue(null, 9), (Number) null, 1);
      fail("An exception must be raised");
    } catch (AssertionError e) {
      Assertions.assertThat(e.getMessage()).isEqualTo(String.format("[description] %n"
                                                                    + "Expecting:%n"
                                                                    + "  <9>%n"
                                                                    + "to be close to: %n"
                                                                    + "  <null> %n"
                                                                    + " with tolerance <1>"));
    }
  }

  /**
   * This method should fail because the value is not a number.
   */
  @Test
  public void should_fail_because_value_is_not_a_number() throws Exception {
    WritableAssertionInfo info = new WritableAssertionInfo();
    info.description("description");
    Table table = new Table();
    TableAssert tableAssert = assertThat(table);
    try {
      AssertionsOnValueCloseness.isCloseTo(tableAssert, info, getValue(null, false), 8, 0);
      fail("An exception must be raised");
    } catch (AssertionError e) {
      Assertions.assertThat(e.getMessage()).isEqualTo(String.format("[description] %n"
                                                                    + "Expecting:%n"
                                                                    + "  <false>%n"
                                                                    + "to be of type%n"
                                                                    + "  <NUMBER>%n"
                                                                    + "but was of type%n"
                                                                    + "  <BOOLEAN>"));
    }
  }
}