package com.example.demo.api;

import com.example.demo.dto.TraineeDto;
import com.example.demo.service.TraineeService;
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
@RequestMapping("/trainees")
public class TraineeApi {

    @Autowired
    // GTB: - 推荐使用构造器注入
    private TraineeService traineeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TraineeDto createTrainee(@RequestBody @Valid TraineeDto trainee) {
        return toDto(traineeService.saveTrainee(toDomain(trainee)));
    }

    @GetMapping
    // GTB: - @RequestParam应该显式写明value属性
    public List<TraineeDto> getTrainees(@RequestParam Boolean grouped) {
        return traineeService.getTrainees(grouped, 0L).stream()
                .map(Domain2Dto::toDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    // GTB: - @PathVariable应该显式写明value属性
    public void deleteTrainee(@PathVariable Long id) {
    }

}
