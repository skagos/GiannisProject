package com.ikhGiannis.GiannisProject.Controller;

import com.ikhGiannis.GiannisProject.Repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.ikhGiannis.GiannisProject.Repository.GroupRepository;
import com.ikhGiannis.GiannisProject.Model.Group;
import java.util.List;

@RestController
@RequestMapping("/api/group")
public class GroupController {

    @Autowired
    private GroupRepository groupRepository;




    }






