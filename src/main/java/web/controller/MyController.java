package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String showAllEmployees(Model model) {

        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);

        return "all-users";
    }

    @RequestMapping("/addNewUser")
    public String addNewUser(Model model) {

        model.addAttribute("user", new User());

        return "user-info";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        System.out.println(user);
        userService.saveUser(user);

        return "redirect:/";
    }
}
