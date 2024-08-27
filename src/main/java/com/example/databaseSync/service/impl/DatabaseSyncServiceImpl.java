package com.example.databaseSync.service.impl;

import com.example.databaseSync.entity.remote.EntityA;
import com.example.databaseSync.entity.local.EntityB;
import com.example.databaseSync.service.DatabaseSyncService;
import com.example.databaseSync.service.EntityAService;
import com.example.databaseSync.service.EntityBService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Slf4j
@Service
@EnableAsync
@EnableScheduling
@RequiredArgsConstructor
public class DatabaseSyncServiceImpl implements DatabaseSyncService {

    @Autowired
    private EntityAService source; // Repository for source database

    @Autowired
    private EntityBService target; // Repository for target database

    @Transactional
    @Scheduled(fixedRate = 10000)
    public void syncData() {

        List<EntityA> sourceData = source.getAllEntities();
        // Mapping source data to target data (if needed)
        List<EntityB> targetData = mapSourceToTarget(sourceData);
        // Save target data to target database
        //targetRepository.saveAll(targetData);
        target.saveEntity(targetData);
    }

    private List<EntityB> mapSourceToTarget (List<EntityA> sourceData) {
        // Implement mapping logic here
        EntityB slave = new EntityB();
        List<EntityB> entities = new ArrayList<>();
        log.info("mapSourceToTarget{}", sourceData);

        for (EntityA data : sourceData) {
            slave.setEntityId(data.getID_NO());
            slave.setName(data.getCompanyname());
            slave.setType("unknown");
            slave.setRiskRating(returnString(data.getRiskcategory()));
            slave.setRegistrationDate(Date.valueOf("2016-07-28"));
            slave.setRiskCategory(returnString(data.getRiskcategory()));
            slave.setStatus("unknown");
            slave.setProcessingDate(Date.valueOf("2016-07-28"));
            slave.setNextProcessingDate(Date.valueOf("2016-07-28"));
            slave.setActive(false);

            entities.add(slave);
        }
        log.info("entities{}", entities);
        return entities;
    }
    @SneakyThrows
    private java.sql.Date buildSqlDate(String dateOfBirth) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        java.sql.Date dated = (Date) formatter.parse(dateOfBirth);
        return dated;
    }

    private String returnString (int value) {
        if (value==1)
            return "HIGH";
        if (value==2)
            return "MEDIUM";
        if (value==3)
            return "LOW";
        log.info("null {}" ,value);
        return null;
    }

    private String biuldConnectionDateProperly(String date) {
        String new_date = date.replace("/","-");
        System.out.println(new_date);
        return new_date;
    }
}

