package com.example.demo.utils;

import com.example.demo.domain.Trainer;
import com.example.demo.dto.TrainerDto;

public class Domain2Dto {

    public static TrainerDto toDto(Trainer trainer) {
        return TrainerDto.builder()
                .id(trainer.getId())
                .name(trainer.getName())
                .build();
    }
}
