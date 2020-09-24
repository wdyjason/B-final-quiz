package com.example.demo.service;

import com.example.demo.domain.Group;
import com.example.demo.entity.GroupEntity;
import com.example.demo.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.utils.Domain2Entity.toEntity;
import static com.example.demo.utils.Entity2Domain.toDomain;

@Service
public class GroupService {

    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public Group saveGroup(Group group) {
        GroupEntity groupEntity = groupRepository.save(toEntity(group));
        return toDomain(groupEntity);
    }
}
