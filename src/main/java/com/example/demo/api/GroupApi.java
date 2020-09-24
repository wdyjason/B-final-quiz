package com.example.demo.api;

import com.example.demo.dto.GroupDto;
import com.example.demo.exception.ItemsNotEnoughException;
import com.example.demo.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupApi {

    @Autowired
    private GroupService groupService;

    @PostMapping("/auto-grouping")
    public List<GroupDto> autoGrouping() throws ItemsNotEnoughException {
        return groupService.autoGrouping();
    }
}
