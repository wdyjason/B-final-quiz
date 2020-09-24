package com.example.demo.api;

import com.example.demo.dto.TrainerDto;
import com.example.demo.exception.NotSupportOperationException;
import com.example.demo.service.TrainerService;
import com.example.demo.utils.Domain2Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.demo.utils.Domain2Dto.toDto;
import static com.example.demo.utils.Dto2Domain.toDomain;

@RestController
@RequestMapping("/trainers")
public class TrainerApi {

    @Autowired
    private TrainerService trainerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TrainerDto createTrainer(@RequestBody @Valid TrainerDto trainer) {
        return toDto(trainerService.saveTrainer(toDomain(trainer)));
    }

    @GetMapping
    public List<TrainerDto> getTrainer(@RequestParam Boolean grouped) throws NotSupportOperationException {
        return trainerService.getTrainers(grouped, 0L).stream()
                .map(Domain2Dto::toDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void deleteTrainer(@PathVariable Long id) {
    }

}
