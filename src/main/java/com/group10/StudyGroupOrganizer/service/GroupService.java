package com.group10.StudyGroupOrganizer.service;

import com.group10.StudyGroupOrganizer.model.Group;
import com.group10.StudyGroupOrganizer.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    public final GroupRepository groupRepository;
    @Autowired
    public GroupService(GroupRepository groupRepository){
        this.groupRepository=groupRepository;
    }
    public void saveGroup(Group group){groupRepository.save(group);}
    public List<Group>  getAllGroups(){return groupRepository.findAll();}
    public Group getGroupById(Long id){return groupRepository.findById(id).orElse(null);}
    public void deleteGroup(Long id){groupRepository.deleteById(id);}
}
