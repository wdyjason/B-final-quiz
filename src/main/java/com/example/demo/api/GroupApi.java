package com.example.demo.api;

import com.example.demo.dto.GroupDto;
import com.example.demo.exception.ItemsNotEnoughException;
import com.example.demo.exception.NotSupportOperationException;
import com.example.demo.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupApi {

    @Autowired
    // GTB: - 推荐使用构造器注入
    private GroupService groupService;

    @PostMapping("/auto-grouping")
    public List<GroupDto> autoGrouping() throws ItemsNotEnoughException {
        return groupService.autoGrouping();
    }

    @GetMapping
    public List<GroupDto> getGroups() throws NotSupportOperationException {
        return groupService.getGroups();
    }
}
