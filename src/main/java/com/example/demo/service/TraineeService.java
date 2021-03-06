package com.example.demo.service;

import com.example.demo.domain.Trainee;
import com.example.demo.entity.TraineeEntity;
import com.example.demo.repository.TraineeRepository;
import com.example.demo.utils.Entity2Domain;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.demo.utils.Domain2Entity.toEntity;
import static com.example.demo.utils.Entity2Domain.toDomain;

@Service
public class TraineeService {

    private final TraineeRepository traineeRepository;

    public TraineeService(TraineeRepository traineeRepository) {
        this.traineeRepository = traineeRepository;
    }

    public Trainee saveTrainee(Trainee trainee) {
        TraineeEntity saved = traineeRepository.save(toEntity(trainee));
        return toDomain(saved);
    }

    // GTB: - 此处groupId参数没有意义
    public List<Trainee> getTrainees(Boolean grouped, Long groupId) {

        if (!grouped) {
            // GTB: - 将未分组的组Id设置为0不太好，最好为null
            return traineeRepository.findByGroupId(0L).stream()
                    .map(Entity2Domain :: toDomain)
                    .collect(Collectors.toList());
        }

        return traineeRepository.findByGroupId(groupId).stream()
                .map(Entity2Domain :: toDomain)
                .collect(Collectors.toList());
    }

    public List<Trainee> getAllTrainees() {
        return traineeRepository.findAll().stream()
                .map(Entity2Domain :: toDomain)
                .collect(Collectors.toList());
    }
}
