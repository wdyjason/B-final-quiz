package com.example.demo.api;

import com.example.demo.dto.TraineeDto;
import com.example.demo.service.TraineeService;
import com.example.demo.utils.Domain2Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.demo.utils.Domain2Dto.toDto;
import static com.example.demo.utils.Dto2Domain.toDomain;

@RestController
@RequestMapping("/trainees")
public class TraineeApi {

    @Autowired
    private TraineeService traineeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TraineeDto createTrainee(@RequestBody TraineeDto trainee) {
        return toDto(traineeService.createTrainee(toDomain(trainee)));
    }

    @GetMapping
    public List<TraineeDto> getTrainees(@RequestParam Boolean grouped) {
        return traineeService.getTrainees(grouped).stream()
                .map(Domain2Dto::toDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void deleteTrainee(@PathVariable Long id) {
    }

}
