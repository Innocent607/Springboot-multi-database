package com.example.databaseSync.config.local;

import com.example.databaseSync.entity.local.EntityB;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
//@PropertySource("file:./src/main/resources/database-sync.properties")
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackageClasses = EntityB.class,
        basePackages = {"com.example.databaseSync.repository.local"},
        entityManagerFactoryRef = "entityManagerFactory")
        //transactionManagerRef = "slaveTransactionManager")

public class SlaveDatabase {

    @Value("${slave.datasource.driver-class-name}")
    private String driver;
    @Value("${slave.datasource.url}")
    private String url;
    @Value("${slave.datasource.username}")
    private String username;
    @Value("${slave.datasource.password}")
    private String password;


    @Autowired
    private Environment env;

    @Primary
    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "slave.datasource")
    public DataSource slaveDataSource() {
        return DataSourceBuilder.create()
                .driverClassName(driver)
                .url(url)
                .username(username)
                .password(password)
                .build();
    }

    @Primary
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory (
            EntityManagerFactoryBuilder builder,
            @Qualifier("dataSource") DataSource dataSource ) {

         HashMap<String, Object> properties = new HashMap<>();
         properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
         properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
         properties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));

         return builder.dataSource(dataSource)
                 .properties(properties)
                 .packages("com.example.databaseSync.entity.local")
                 .persistenceUnit("EntityB")
                 .build();
    }

    @Primary
    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return  new JpaTransactionManager(entityManagerFactory);
    }

}
