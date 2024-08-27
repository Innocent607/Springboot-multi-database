package com.example.databaseSync.service.impl;

import com.example.databaseSync.entity.remote.EntityA;
import com.example.databaseSync.repository.remote.EntityARepository;
import com.example.databaseSync.service.EntityAService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EntityAServiceImpl implements EntityAService {

    @Autowired
    EntityARepository repository;

//    @Autowired
//    EntityManagerUtils emUtils;

    @Transactional("transactionManager")
    public List<EntityA> getAllEntities () {
//        emUtils.getJpaFactory("master").getRepository(EntityA.class);
        return repository.findAll();
    }

}
