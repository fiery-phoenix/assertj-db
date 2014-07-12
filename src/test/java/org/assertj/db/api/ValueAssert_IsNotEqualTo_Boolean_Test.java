package org.assertj.db.api;

import static org.assertj.db.api.Assertions.assertThat;

import org.assertj.db.common.AbstractTest;
import org.assertj.db.type.Table;
import org.junit.Test;

/**
 * Tests on the methods which verifies if a value is not equal to a boolean.
 * 
 * @author Régis Pouiller
 * 
 */
public class ValueAssert_IsNotEqualTo_Boolean_Test extends AbstractTest {

  /**
   * This method tests that the value is not equal to a boolean.
   */
  @Test
  public void test_if_value_is_equal_to_boolean() {
    Table table = new Table(source, "test");
    assertThat(table).column("var2")
        .value().isNotEqualTo(false).returnToRow()
        .value().isNotEqualTo(true);
  }

  /**
   * This method should fail because the value is equal to the boolean.
   */
  @Test(expected = AssertionError.class)
  public void should_fail_because_value_is_equal() {
    Table table = new Table(source, "test");
    assertThat(table).column("var2")
        .value().isNotEqualTo(true);
  }

  /**
   * This method should fail because the value is not a boolean.
   */
  @Test(expected = AssertionError.class)
  public void should_fail_because_value_is_not_a_boolean() {
    Table table = new Table(source, "test");
    assertThat(table).column("var1")
        .value().as("var1").isNotEqualTo(true);
  }

}
