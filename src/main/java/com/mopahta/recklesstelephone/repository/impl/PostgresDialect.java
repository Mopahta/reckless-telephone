package com.mopahta.recklesstelephone.repository.impl;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Component;

@Component
public class PostgresDialect extends Dialect {

    public PostgresDialect() {
        super();
        registerFunction("regexp", new SQLFunctionTemplate(StandardBasicTypes.STRING, "?1 REGEXP ?2"));
    }
}
