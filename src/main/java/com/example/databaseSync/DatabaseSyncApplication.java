package com.example.databaseSync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

//@ComponentScan
//@EnableAutoConfiguration
//@EnableJpaRepositories
//@EntityScan("com.example.databaseSync.entity.*")
@EnableScheduling
@SpringBootApplication
public class DatabaseSyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseSyncApplication.class, args);
	}

}
