package com.example.demo.repository;

import com.example.demo.entity.GroupEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends CrudRepository<GroupEntity, Long> {

    List<GroupEntity> findAll();
}
