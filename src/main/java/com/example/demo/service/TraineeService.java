package com.example.demo.service;

import com.example.demo.domain.Trainee;
import com.example.demo.entity.TraineeEntity;
import com.example.demo.repository.TraineeRepository;
import org.springframework.stereotype.Service;

import static com.example.demo.utils.Domain2Entity.toEntity;
import static com.example.demo.utils.Entity2Domain.toDomain;

@Service
public class TraineeService {

    private final TraineeRepository traineeRepository;

    public TraineeService(TraineeRepository traineeRepository) {
        this.traineeRepository = traineeRepository;
    }

    public Trainee createTrainee(Trainee trainee) {
        TraineeEntity saved = traineeRepository.save(toEntity(trainee));
        return toDomain(saved);
    }
}
