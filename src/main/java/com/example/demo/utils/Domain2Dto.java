package com.example.demo.utils;

import com.example.demo.domain.Group;
import com.example.demo.domain.Trainee;
import com.example.demo.domain.Trainer;
import com.example.demo.dto.GroupDto;
import com.example.demo.dto.TraineeDto;
import com.example.demo.dto.TrainerDto;

import java.util.ArrayList;

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

    public static GroupDto toDto(Group group) {
        return GroupDto.builder()
                .id(group.getId())
                .name(group.getName())
                .trainees(new ArrayList<>())
                .trainers(new ArrayList<>())
                .build();
    }
}
