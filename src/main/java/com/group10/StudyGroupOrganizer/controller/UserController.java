package com.group10.StudyGroupOrganizer.controller;

import com.group10.StudyGroupOrganizer.model.User;
import com.group10.StudyGroupOrganizer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    public final UserService userServices;
    @Autowired
    public UserController(UserService userServices){
        this.userServices = userServices;
    }
    @GetMapping
    public String getAllUser(Model model){
        List<User> users =userServices.getAllUsers();
        model.addAttribute("users" ,users);
        return "users";
    }
    @GetMapping("/{id}")
    public String getUserById(@PathVariable Long id ,Model model ){
        User user= userServices.getUserById(id);
        model.addAttribute("user",user);
        return "user-details";
    }
    @GetMapping("/new")
    public String showUserForm(Model model){
        model.addAttribute("user",new User());
        return "user-form";
    }
    @PostMapping("/new")
    public String saveUser(@ModelAttribute("user")User user){
        userServices.saveUser(user);
        return "redirect:/users";
    }
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id,Model model){
        User user=userServices.getUserById(id);
        model.addAttribute("user" ,user);
        return "user-form";
    }
    @PostMapping("/{id}/edit")
    public String updateUser(@ModelAttribute("user")User user , Model model){
        userServices.saveUser(user);
        String successMessage = "User updated successfully!";
        model.addAttribute("successMessage", successMessage);
        return "redirect:/users";
    }
    @GetMapping("/{id}/delete")
    public  String deleteUser(@PathVariable Long id){
        userServices.deleteUser(id);
        return "redirect:/Users";
    }




}
