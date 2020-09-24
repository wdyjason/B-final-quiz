package com.example.demo.service;

import com.example.demo.domain.Group;
import com.example.demo.domain.Trainee;
import com.example.demo.domain.Trainer;
import com.example.demo.dto.GroupDto;
import com.example.demo.dto.TraineeDto;
import com.example.demo.dto.TrainerDto;
import com.example.demo.entity.GroupEntity;
import com.example.demo.exception.ItemsNotEnoughException;
import com.example.demo.exception.NotSupportOperationException;
import com.example.demo.repository.GroupRepository;
import com.example.demo.utils.Domain2Dto;
import com.example.demo.utils.Entity2Domain;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.demo.utils.Domain2Dto.toDto;
import static com.example.demo.utils.Domain2Entity.toEntity;
import static com.example.demo.utils.Entity2Domain.toDomain;

@Service
public class GroupService {
    private final GroupRepository groupRepository;

    private final TraineeService traineeService;

    private final TrainerService trainerService;

    public GroupService(GroupRepository groupRepository, TraineeService traineeService, TrainerService trainerService) {
        this.groupRepository = groupRepository;
        this.traineeService = traineeService;
        this.trainerService = trainerService;
    }

    public Group saveGroup(Group group) {
        GroupEntity groupEntity = groupRepository.save(toEntity(group));
        return toDomain(groupEntity);
    }

    public List<GroupDto> getGroups() throws NotSupportOperationException {
        List<GroupDto> groups = groupRepository.findAll().stream()
                .map(Entity2Domain::toDomain)
                .map(Domain2Dto::toDto)
                .collect(Collectors.toList());
        for (GroupDto group : groups) {
            long groupId = group.getId();
            List<TrainerDto> trainers = trainerService.getTrainers(true, groupId).stream()
                    .map(Domain2Dto::toDto)
                    .collect(Collectors.toList());

            List<TraineeDto> trainees = traineeService.getTrainees(true, groupId).stream()
                    .map(Domain2Dto::toDto)
                    .collect(Collectors.toList());

            group.setTrainers(trainers);
            group.setTrainees(trainees);
        }

        return groups;
    }

    @Transactional
    public List<GroupDto> autoGrouping() throws ItemsNotEnoughException {
        List<Trainer> allTrainers = trainerService.getAllTrainers();

        if (allTrainers.size() <= 1) {
            throw new ItemsNotEnoughException("trainers not enough!");
        }

        List<Trainee> allTrainees = traineeService.getAllTrainees();

        if (allTrainees.isEmpty()) {
            throw new ItemsNotEnoughException("trainees not enough!");
        }

        int groupCount = allTrainers.size() / 2;
        List<GroupDto> groups = initGroups(groupCount);

        addTrainersToGroups(groups, allTrainers);

        addTraineesToGroups(groups, allTrainees);

        return groups;
    }

    private List<GroupDto> initGroups(int groupCount) {

        List<GroupDto> groups = new ArrayList<>();
        for (int i = 0; i < groupCount; i++) {
            Group saved =  toDomain(groupRepository.save(GroupEntity.builder().name((i + 1) + "组").build()));
            groups.add(toDto(saved));
        }
        return groups;
    }

    private void addTrainersToGroups(List<GroupDto> groups, List<Trainer> trainers) {
        Collections.shuffle(trainers);
        if (trainers.size() % 2 != 0) {
            trainers.remove(0);
        }
        int groupIndex = 0;
        int groupCount = groups.size();

        for (Trainer trainer : trainers) {

            groups.get(groupIndex).getTrainers().add(toDto(trainer));

            trainer.setGroupId( groups.get(groupIndex).getId());

            trainerService.saveTrainer(trainer);

            if (groupIndex == groupCount - 1) {
                groupIndex = 0;
            } else {
                groupIndex ++;
            }
        }
    }

    private void addTraineesToGroups(List<GroupDto> groups, List<Trainee> trainees) {
        Collections.shuffle(trainees);

        int groupIndex = 0;
        int groupCount = groups.size();

        for (Trainee trainee: trainees) {

            groups.get(groupIndex).getTrainees().add(toDto(trainee));

            trainee.setGroupId( groups.get(groupIndex).getId());

            traineeService.saveTrainee(trainee);

            if (groupIndex == groupCount - 1) {
                groupIndex = 0;
            } else {
                groupIndex ++;
            }
        }
    }


}
