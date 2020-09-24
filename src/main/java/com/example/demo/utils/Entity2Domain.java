package com.example.demo.utils;

import com.example.demo.domain.Trainer;
import com.example.demo.entity.TrainerEntity;

public class Entity2Domain {

    public static Trainer toDomain(TrainerEntity entity) {
        return Trainer.builder()
                .id(entity.getId())
                .name(entity.getName())
                .groupId(entity.getGroupId())
                .build();
    }
}
