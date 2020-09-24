package com.example.demo.service;

import com.example.demo.domain.Group;
import com.example.demo.entity.GroupEntity;
import com.example.demo.repository.GroupRepository;
import org.assertj.core.util.IterableUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class GroupServiceTest {

    @Mock
    private GroupRepository groupRepository;

    @InjectMocks
    private GroupService groupService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Nested
    class happyPath {

        @Test
        public void should_create_groups_success() {
            Group group = Group.builder().name("group").build();

            GroupEntity toSavedEntity = GroupEntity.builder().name("group").build();

            GroupEntity toReturnEntity = GroupEntity.builder().id(1L).name("group").build();

            Group expect = Group.builder().id(1L).name("group").build();

            when(groupRepository.save(toSavedEntity)).thenReturn(toReturnEntity);

            Group result = groupService.saveGroup(group);

            assertEquals(result, expect);
        }
    }

}