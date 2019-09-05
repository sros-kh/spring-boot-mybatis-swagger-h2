package com.service.springboot.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Bean
    @Profile("h2")
    public DataSource h2DataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScripts("h2/schema.sql")
                .addScripts("h2/data.sql")
                .build();
    }

    @Bean
    @Profile("pgsql")
    public DataSource pgsqlDataSource() {
        return DataSourceBuilder.create()
                .url("")
                .username("")
                .password("")
                .driverClassName("")
                .build();
    }
}
