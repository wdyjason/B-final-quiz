package com.example.demo.repository;

import com.example.demo.entity.TrainerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainerRepository extends CrudRepository<TrainerEntity, Long> {

    List<TrainerEntity> findByGroupId(long groupId);

    List<TrainerEntity> findAll();
}
