package com.example.demo.utils;

import com.example.demo.domain.Trainee;
import com.example.demo.domain.Trainer;
import com.example.demo.dto.TraineeDto;
import com.example.demo.dto.TrainerDto;

public class Dto2Domain {

    public static Trainer toDomain(TrainerDto trainerDto) {
        return Trainer.builder()
                .id(trainerDto.getId())
                .name(trainerDto.getName())
                .build();
    }

    public static Trainee toDomain(TraineeDto traineeDto) {
        return Trainee.builder()
                .id(traineeDto.getId())
                .name(traineeDto.getName())
                .zoomId(traineeDto.getZoomId())
                .office(traineeDto.getOffice())
                .github(traineeDto.getGithub())
                .email(traineeDto.getEmail())
                .build();
    }
}
