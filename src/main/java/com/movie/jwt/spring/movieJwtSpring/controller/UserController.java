package com.movie.jwt.spring.movieJwtSpring.controller;

import com.movie.jwt.spring.movieJwtSpring.model.User;
import com.movie.jwt.spring.movieJwtSpring.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service){
        this.service = service;
    }

    @PostMapping(value = "/add-user")
    public String saveUser(@RequestBody User user){
        return service.saveUser(user);
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
