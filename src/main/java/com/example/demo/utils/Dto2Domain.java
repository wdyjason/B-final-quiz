package com.example.demo.utils;

import com.example.demo.domain.Trainer;
import com.example.demo.dto.TrainerDto;

public class Dto2Domain {

    public static Trainer toDomain(TrainerDto trainerDto) {
        return Trainer.builder()
                .id(trainerDto.getId())
                .name(trainerDto.getName())
                .build();
    }
}
