package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TraineeDto {

    private Long id;

    @NotBlank(message = "name can be blank")
    private String name;

    @NotBlank(message = "office can be blank")
    private String office;

    @NotBlank(message = "email can be blank")
    @Email
    private String email;

    @NotBlank(message = "github can be blank")
    private String github;

    @NotBlank(message = "zoomId can be blank")
    private String zoomId;
}
