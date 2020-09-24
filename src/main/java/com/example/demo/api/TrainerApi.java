package com.example.demo.api;

import com.example.demo.dto.TrainerDto;
import com.example.demo.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.demo.utils.Domain2Dto.toDto;
import static com.example.demo.utils.Dto2Domain.toDomain;

@RestController
@RequestMapping("/trainers")
public class TrainerApi {

    @Autowired
    private TrainerService trainerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TrainerDto createTrainer(@RequestBody TrainerDto trainer) {
        return toDto(trainerService.createTrainer(toDomain(trainer)));
    }

    @GetMapping
    public List<TrainerDto> getTrainer(@RequestParam Boolean grouped) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteTrainer(@PathVariable Long id) {
    }

}
