package com.example.databaseSync;

import com.example.databaseSync.entity.local.EntityB;
import com.example.databaseSync.repository.local.EntityBRepository;
import com.example.databaseSync.repository.remote.EntityARepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DatabaseSyncApplication.class)
@EnableTransactionManagement
public class DatabaseSyncApplicationTests {

    @Autowired
    EntityARepository entityARepository;

    @Autowired
    EntityBRepository entityBRepository;

    @Test
    @Transactional("transactionManager")
    public void createARecord() {
        EntityB local = new EntityB();
        local.setEntityId("unknown");
        local.setName("sync pty ltd");
        local.setType("unknown");
        local.setRiskRating("unknown");
        local.setProcessingDate(Date.valueOf("2024-09-09"));
        local.setRiskCategory("unknown");
        local.setStatus("unknown");
        local.setProcessingDate(Date.valueOf("2023-09-09"));
        local.setNextProcessingDate(Date.valueOf("2023-02-09"));
        local.setActive(false);

        entityBRepository.save(local);
    }
}
