package com.pracore.user.conf;

import javax.sql.DataSource;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

@Configuration
public class DataSourceConf {
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;
	
	@Bean
	@Primary
	public DataSource dataSource() {
		return DataSourceBuilder
				.create()
				.username(username)
				.password(password)
				.url(url)
				.build();
	}


	@Bean
	public DSLContext jooqDslContext() {
		DSLContext dslContext = DSL.using(
				dataSource(),
				SQLDialect.MYSQL
		);
		return dslContext;
	}

}