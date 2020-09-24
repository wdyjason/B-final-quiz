package com.example.demo.utils;

import com.example.demo.domain.Group;
import com.example.demo.domain.Trainee;
import com.example.demo.domain.Trainer;
import com.example.demo.entity.GroupEntity;
import com.example.demo.entity.TraineeEntity;
import com.example.demo.entity.TrainerEntity;

public class Domain2Entity {

    public static TrainerEntity toEntity(Trainer trainer) {
        return TrainerEntity.builder()
                .id(trainer.getId())
                .name(trainer.getName())
                .groupId(trainer.getGroupId())
                .build();
    }

    public static TraineeEntity toEntity(Trainee trainee) {
        return TraineeEntity.builder()
                .id(trainee.getId())
                .name(trainee.getName())
                .groupId(trainee.getGroupId())
                .email(trainee.getEmail())
                .github(trainee.getGithub())
                .office(trainee.getOffice())
                .zoomId(trainee.getZoomId())
                .build();
    }

    public static GroupEntity toEntity(Group group) {
        return GroupEntity.builder()
                .id(group.getId())
                .name(group.getName())
                .build();
    }
}
