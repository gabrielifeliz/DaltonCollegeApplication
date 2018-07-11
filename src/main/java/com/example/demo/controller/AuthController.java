package com.example.demo.controller;

import com.example.demo.models.Student;
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
//        model.addAttribute("roles", roles.findAllByRoleOrRole("STUDENT", "TEACHER"));
        return "register";
    }@PostMapping("/register")
    public String saveUser(@ModelAttribute("user") Student user, Model model) {
        if(users.existsByUsername(user.getUsername())){
            model.addAttribute("usernameErr", users.existsByUsername(user.getUsername()));
            return "register";
        }
        user.addRole(roles.findByRole("STUDENT"));
        users.save(user);
        return "redirect:/login";
    }

    @PostConstruct() public void allRoles() {
        UserRole role = new UserRole("STUDENT");
        roles.save(role);

        role = new UserRole("TEACHER");
        roles.save(role);

        role = new UserRole("ADMIN");
        roles.save(role);

        AppUser admin = new AppUser();
        admin.setUsername("admin");
        admin.setPassword("pass");
        admin.addRole(roles.findByRole("ADMIN"));

        users.save(admin);
    }
}
