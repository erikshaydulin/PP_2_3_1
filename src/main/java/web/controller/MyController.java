package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showAllEmployees(Model model) {

        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);

        return "all-users";
    }
}
