package com.group10.StudyGroupOrganizer.controller;

import com.group10.StudyGroupOrganizer.model.Group;
import com.group10.StudyGroupOrganizer.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/groups")
public class GroupController {
    public final GroupService groupService;
    @Autowired
    public GroupController(GroupService groupService){
        this.groupService=groupService;
    }
    @GetMapping
    public String getAllGroups(Model model){
        List<Group> groups=groupService.getAllGroups();
        model.addAttribute("groups",groups);
        return "groups";
    }
    @GetMapping("/{id}")
    public String getGroupById(@PathVariable Long id,Model model){
        Group group=groupService.getGroupById(id);
        model.addAttribute("group",group);
        return "group-details";
    }
    @GetMapping("/new")
    public String showGroupForm(Model model){
        model.addAttribute("group",new Group());
        return "group-form";
    }
    @PostMapping("/new")
    public String saveGroup(@ModelAttribute("group") Group group){
        groupService.saveGroup(group);
        return "redirect:/groups";
    }
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id,Model model){
        Group group=groupService.getGroupById(id);
        model.addAttribute("group",group);
        return "group-form";
    }
    @PostMapping("/{id}/edit")
    public String updateGroup(@ModelAttribute("group") Group group){
        groupService.saveGroup(group);
        return "redirect:/groups";
    }
    @GetMapping("/{id}/delete")
    public String deleteGroup(@PathVariable Long id){
        groupService.deleteGroup(id);
        return "redirect:/groups";
    }


}
