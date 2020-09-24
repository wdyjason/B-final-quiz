package com.example.demo.repository;

import com.example.demo.entity.TraineeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraineeRepository extends CrudRepository<TraineeEntity, Long> {
}
