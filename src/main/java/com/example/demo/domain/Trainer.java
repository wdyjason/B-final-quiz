package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Trainer {

    private Long id;

    private String name;

    @Builder.Default
    private Long groupId = 0L;
}
