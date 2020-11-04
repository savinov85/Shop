package ru.savinov.spring.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.savinov.spring.shop.dto.UserWithRoles;
import ru.savinov.spring.shop.entities.User;
import ru.savinov.spring.shop.services.UserService;
import java.util.List;

@RestController
public class UsersRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<UserWithRoles> getTestUser() {
        List<UserWithRoles> list = userService.getAllUsersWithRoles();
        System.out.println(list);
        return list;
    }
    @PostMapping("/delete_user")
    public @ResponseBody User deleteUser(@RequestBody User user) {
        Long id = user.getId();
        System.out.println(id);
        userService.deleteUserById(id);
        return user;
    }
    @PostMapping("/add_user")
    public @ResponseBody User addUser(@RequestBody User user) {
        userService.createNewUser(user);
        return user;
    }
}
