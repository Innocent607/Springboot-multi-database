//package com.example.databaseSync.utils;
//
//import jakarta.persistence.EntityManager;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
//import org.springframework.stereotype.Component;
//
//
//@Slf4j
//@Component
//public class EntityManagerUtils {
//
//    @Autowired
//    @Qualifier("entityManagerFactory")
//    private EntityManager masterEntityManager;
//
//    @Autowired
//    @Qualifier("slaveEntityManager")
//    private EntityManager slaveEntityManager;
//
//    public EntityManager getEm(String url) {
//        log.info("url [{}]", url);
//        if (url.contains("master"))
//            return masterEntityManager;
//        if (url.contains("slave"))
//            return slaveEntityManager;
//        return slaveEntityManager;
//    }
//
//    public JpaRepositoryFactory getJpaFactory(String url){
//        return new JpaRepositoryFactory(getEm(url));
//    }
//}
