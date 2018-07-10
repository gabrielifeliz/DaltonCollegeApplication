package com.example.demo.controller;

import com.example.demo.models.authentication.AppUser;
import com.example.demo.models.authentication.UserRole;
import com.example.demo.repositories.AppUserRepository;
import com.example.demo.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

@Controller
public class AuthController {
    @Autowired
    AppUserRepository users;

    @Autowired
    UserRoleRepository roles;

    @RequestMapping("/login") public String showLogin(){
        return "login";
    }

    @GetMapping("/register")
    public String regiter(Model model) {
        model.addAttribute("user", new AppUser());
        model.addAttribute("roles", roles.findAllByRoleAndRole("STUDENT", "TEACHER"));
        return "register";
    }

    @PostMapping("/register")
    public String saveUser(@Valid @ModelAttribute("user") AppUser user, BindingResult result, Model model) {

        AppUser currentUser = ((AppUser)result.getModel().get("user"));

        if(users.existsByUsername(currentUser.getUsername())){
            model.addAttribute("usernameErr", users.existsByUsername(currentUser.getUsername()));
            return "register";
        }

        users.save(user);
        return "redirect:/";
    }

    @PostConstruct() public void allRoles(){
        UserRole role = new UserRole("STUDENT");
        roles.save(role);

        role = new UserRole("TEACHER");
        roles.save(role);
    }
}
