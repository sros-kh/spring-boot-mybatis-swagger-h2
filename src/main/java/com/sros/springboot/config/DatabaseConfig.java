package com.sros.springboot.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@MapperScan("com.sros.springboot.repos")
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
        return new HikariDataSource(new HikariConfig(properties()));
    }

    private Properties properties() {
        Properties props = new Properties();
        props.setProperty("dataSource.driverClassName", "org.postgresql.Driver");
        props.setProperty("dataSource.user", "postgres");
        props.setProperty("dataSource.password", "Sr0sPa$$w0rd2019");
        props.setProperty("jdbcUrl", "jdbc:postgresql://13.229.17.66:5432/postgres");
        return props;
    }
}
