package com.example.demo.utils;

import com.example.demo.domain.Trainee;
import com.example.demo.domain.Trainer;
import com.example.demo.dto.TraineeDto;
import com.example.demo.dto.TrainerDto;

public class Domain2Dto {

    public static TrainerDto toDto(Trainer trainer) {
        return TrainerDto.builder()
                .id(trainer.getId())
                .name(trainer.getName())
                .build();
    }

    public static TraineeDto toDto(Trainee trainee) {
        return TraineeDto.builder()
                .id(trainee.getId())
                .name(trainee.getName())
                .github(trainee.getGithub())
                .email(trainee.getEmail())
                .office(trainee.getOffice())
                .zoomId(trainee.getZoomId())
                .build();
    }
}
