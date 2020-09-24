package com.example.demo.utils;

import com.example.demo.domain.Trainer;
import com.example.demo.entity.TrainerEntity;

public class Domain2Entity {

    public static TrainerEntity toEntity(Trainer trainer) {
        return TrainerEntity.builder()
                .id(trainer.getId())
                .name(trainer.getName())
                .groupId(trainer.getGroupId())
                .build();
    }
}
