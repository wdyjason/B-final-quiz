package com.example.demo.service;

import com.example.demo.domain.Trainer;
import com.example.demo.entity.TrainerEntity;
import com.example.demo.exception.NotSupportOperationException;
import com.example.demo.repository.TrainerRepository;
import com.example.demo.utils.Entity2Domain;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.example.demo.utils.Domain2Dto.toDto;
import static com.example.demo.utils.Domain2Entity.toEntity;
import static com.example.demo.utils.Entity2Domain.toDomain;

@Service
public class TrainerService {

    private final TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public Trainer saveTrainer(Trainer trainer) {
        TrainerEntity saved = trainerRepository.save(toEntity(trainer));
        return toDomain(saved);
    }

    public List<Trainer> getTrainers(Boolean grouped) throws NotSupportOperationException {

        if (!grouped) {
            return trainerRepository.findByGroupId(0L).stream()
                    .map(Entity2Domain::toDomain)
                    .collect(Collectors.toList());
        }

        throw new NotSupportOperationException("Not Supported operation!");
    }

    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll().stream()
                .map(Entity2Domain::toDomain)
                .collect(Collectors.toList());
    }
}
