package com.example.demo.utils;

import com.example.demo.domain.Group;
import com.example.demo.domain.Trainee;
import com.example.demo.domain.Trainer;
import com.example.demo.entity.GroupEntity;
import com.example.demo.entity.TraineeEntity;
import com.example.demo.entity.TrainerEntity;

public class Entity2Domain {

    public static Trainer toDomain(TrainerEntity entity) {
        return Trainer.builder()
                .id(entity.getId())
                .name(entity.getName())
                .groupId(entity.getGroupId())
                .build();
    }

    public static Trainee toDomain(TraineeEntity entity) {
        return Trainee.builder()
                .id(entity.getId())
                .name(entity.getName())
                .groupId(entity.getGroupId())
                .email(entity.getEmail())
                .github(entity.getGithub())
                .office(entity.getOffice())
                .zoomId(entity.getZoomId())
                .build();
    }

    public static Group toDomain(GroupEntity entity){
        return Group.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }
}
