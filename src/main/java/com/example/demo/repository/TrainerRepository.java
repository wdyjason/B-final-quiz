package com.example.demo.repository;

import com.example.demo.entity.TrainerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends CrudRepository<TrainerEntity, Long> {
}
