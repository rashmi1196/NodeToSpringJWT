package com.node.jwt.spring.jwt.controller;

import com.node.jwt.spring.jwt.model.User;
import com.node.jwt.spring.jwt.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service){
        this.service = service;
    }

    @PostMapping(value = "/add-user")
    public String signup(@RequestBody User user){
        return service.signup(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, Object> map){
        return service.login(map.get("email").toString(), map.get("password").toString());
    }

    @GetMapping("/get-user")
    public User getUser(HttpServletRequest request){
        ObjectId userId = (ObjectId) request.getAttribute("userId");
        return service.getUser(userId);
    }

    @GetMapping("/get-users")
    public List<User> getUsers(HttpServletRequest request){
        return service.getUsers();
    }

}
