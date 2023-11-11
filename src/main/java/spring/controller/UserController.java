package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.Model.User;
import spring.service.UserService;

import java.util.List;

@Controller

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String showAllUsers(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("allUsers", userList);
        return "allUsers";
    }

    @GetMapping(value = "/addNewUser")
    public String addNewUser(@ModelAttribute("user") User user) {
        return "addNewUser";
    }

    @PostMapping(value = "/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "/updateInfo")
    public String updateUser(@RequestParam("userId") int id, Model model) {
        System.out.println("Received user id: " + id);
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "addNewUser";
    }

    @GetMapping(value = "/deleteUser")
    public String deleteUser(@RequestParam("userId") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
