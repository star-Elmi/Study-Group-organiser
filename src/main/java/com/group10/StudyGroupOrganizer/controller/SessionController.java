package com.group10.StudyGroupOrganizer.controller;

import com.group10.StudyGroupOrganizer.model.Group;
import com.group10.StudyGroupOrganizer.model.SessionDetails;
import com.group10.StudyGroupOrganizer.service.GroupService;
import com.group10.StudyGroupOrganizer.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
@Controller
@RequestMapping("/session-detail")
public class SessionController {
    @Autowired
    private GroupService groupService;
    public final SessionService sessionService;
    @Autowired
    public SessionController(SessionService sessionService){
        this.sessionService=sessionService;
    }

    @GetMapping
    public String getAllSession(Model model){
        List<SessionDetails> sessions=sessionService.getAllSession();
        model.addAttribute("sessions",sessions);
        return "session-detail";
    }
    @GetMapping("/{id}")
    public String getSessionById(@PathVariable Long id,Model model){
        SessionDetails mysession=sessionService.getSessionById(id);
        model.addAttribute("session-detail",mysession);
        return "session-details";
    }
    @GetMapping("/new")
    public String showSessionForm(Model model){
        List<Group> groups =groupService.getAllGroups();
        model.addAttribute("sessionDetail", new SessionDetails());
        model.addAttribute("groups",groups);
        return "session-form";
    }
    @PostMapping("/new")
    public String saveSession(@ModelAttribute("session-detail") SessionDetails mysession){

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy'T'HH:mm");
        sessionService.saveSession(mysession);
        return "redirect:/session-detail";
    }
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id,Model model){
        SessionDetails session=sessionService.getSessionById(id);
        model.addAttribute("session",session);
        return "session-form";
    }
    @PostMapping("/{id}/edit")
    public String updateSession(@ModelAttribute("session-detail") SessionDetails mysesion){
        sessionService.saveSession(mysesion);
        return "redirect:/session-detail";
    }
    @GetMapping("/{id}/delete")
    public String deleteSession(@PathVariable Long id){
        sessionService.deleteSession(id);
        return "redirect:/session-detail";
    }


}
