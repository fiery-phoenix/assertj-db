package org.assertj.db.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.db.api.Assertions.assertThat;

import org.assertj.db.common.AbstractTest;
import org.assertj.db.type.Table;
import org.junit.Test;

/**
 * Test on {@code row} methods on column assert from a table.
 * 
 * @author Régis Pouiller
 * 
 */
public class TableColumnAssert_Row_Test extends AbstractTest {

  /**
   * This method tests the result of {@code row} methods on column assert from a table.
   */
  @Test
  public void test_with_table_and_column() {
    Table table = new Table(source, "test");
    
    TableAssert tableAssert = assertThat(table);
    TableRowAssert tableRowAssert = tableAssert.row(1);
    TableColumnAssert tableColumnAssert = tableAssert.column(1);
    
    assertThat(tableRowAssert).isEqualTo(tableColumnAssert.row(0).row());
    assertThat(tableRowAssert).isEqualTo(tableColumnAssert.row(1));
  }
}