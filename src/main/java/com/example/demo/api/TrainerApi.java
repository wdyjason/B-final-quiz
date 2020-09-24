package com.example.demo.api;

import com.example.demo.service.TrainerService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainerApi {

    private final TrainerService trainerService;

    public TrainerApi(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

}
