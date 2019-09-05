package com.sros.springboot.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.sros.springboot.dao")
public class DatabaseConfig {

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
    @Primary
    @Profile("pgsql")
    public DataSource pgsqlDataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:postgresql://13.229.17.66:5432/postgres")
                .username("postgres")
                .password("Sr0sPa$$w0rd2019")
                .driverClassName("org.postgresql.Driver ")
                .build();
    }
}
