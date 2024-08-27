//package com.example.databaseSync.config;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class JdbcTemplateConfig {
//
//    // Configuring JdbcTemplate for the "todos" data source
//    @Bean
//    public JdbcTemplate todosJdbcTemplate(@Qualifier("dataSource") DataSource dataSource) {
//        return new JdbcTemplate(dataSource);
//    }
//
//    // Configuring JdbcTemplate for the "topics" data source
//    @Bean
//    public JdbcTemplate topicsJdbcTemplate(@Qualifier("topicsDataSource") DataSource dataSource) {
//        return new JdbcTemplate(dataSource);
//    }
//}
