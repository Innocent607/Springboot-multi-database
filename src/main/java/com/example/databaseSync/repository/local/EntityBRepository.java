package com.example.databaseSync.repository.local;

import com.example.databaseSync.entity.local.EntityB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityBRepository extends JpaRepository<EntityB, Integer > {
}
