package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TraineeDto {

    private Long id;

    private String name;

    private String office;

    private String email;

    private String github;

    private String zoomId;
}
