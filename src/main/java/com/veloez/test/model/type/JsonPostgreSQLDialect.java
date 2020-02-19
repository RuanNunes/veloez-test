package com.veloez.test.model.type;

import java.sql.Types;

import org.hibernate.dialect.PostgreSQL9Dialect;

/**
 * Wrap default PostgreSQL9Dialect with 'jsonb' type.
 *
 */
public class JsonPostgreSQLDialect extends PostgreSQL9Dialect {

  public JsonPostgreSQLDialect() {

    super();

    this.registerColumnType(Types.JAVA_OBJECT, "jsonb");
  }
}
