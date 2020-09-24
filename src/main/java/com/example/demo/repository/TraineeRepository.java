package com.example.demo.repository;

import com.example.demo.entity.TraineeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TraineeRepository extends CrudRepository<TraineeEntity, Long> {

    List<TraineeEntity> findByGroupId(long groupId);

    List<TraineeEntity> findAll();
}
