package com.example.databaseSync.repository.remote;

import com.example.databaseSync.entity.remote.EntityA;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntityARepository extends CrudRepository<EntityA, Integer> {

    @Override
    List<EntityA> findAll();


}
