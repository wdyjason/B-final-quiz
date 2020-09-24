package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TraineeEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String office;

    private String email;

    private String github;

    private String zoomId;

    @Builder.Default
    private Long groupId = 0L;
}
