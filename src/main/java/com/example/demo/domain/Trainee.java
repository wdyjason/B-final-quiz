package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Trainee {

    private Long id;

    private String name;

    private String office;

    private String email;

    private String github;

    private String zoomId;

    @Builder.Default
    private Long groupId = 0L;
}
