package com.example.databaseSync.service.impl;

import com.example.databaseSync.entity.local.EntityB;
import com.example.databaseSync.repository.local.EntityBRepository;
import com.example.databaseSync.service.EntityBService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EntityBServiceImpl implements EntityBService {

    @Autowired
    EntityBRepository repository;

//    @Autowired
//    EntityManagerUtils emUtils;

    public void saveEntity (List<EntityB> entities) {
//        emUtils.getJpaFactory("slave").getRepository(EntityA .class);
        for (EntityB entity : entities) {
            repository.save(entity);
        }

    }


}
