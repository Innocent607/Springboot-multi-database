package com.example.databaseSync.config.remote;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableTransactionManagement
//@ComponentScan("com.example.databaseSync.config.remote")
//@PropertySource("file:./src/main/resources/database-sync.properties")
@EnableJpaRepositories(
        //basePackageClasses = EntityA.class,
        basePackages = "com.example.databaseSync.repository.remote",
        entityManagerFactoryRef = "masterEntityManagerFactory",
        transactionManagerRef = "masterTransactionManager")
public class MasterDatabase {

    @Value("${master.datasource.driver-class-name}")
    private String driver;
    @Value("${master.datasource.url}")
    private String url;
    @Value("${master.datasource.username}")
    private String username;
    @Value("${master.datasource.password}")
    private String password;

    @Autowired
    Environment env;

    @Bean(name = "masterDataSource")
    @ConfigurationProperties(prefix = "master.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .driverClassName(driver)
                .url(url)
                .username(username)
                .password(password)
                .build();
    }

    @Bean(name = "masterEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean masterEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("masterDataSource") DataSource dataSource
    ) {
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        properties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));

        return builder.dataSource(dataSource)
                .properties(properties)
                .packages("com.example.databaseSync.entity.remote")
                .persistenceUnit("EntityA")
                .build();
    }

    @Bean(name = "masterTransactionManager")
    public PlatformTransactionManager masterTransactionManager(
            @Qualifier("masterEntityManagerFactory") EntityManagerFactory masterEntityManagerFactory
            ) {
        return new JpaTransactionManager(masterEntityManagerFactory);
    }
}
