package com.movie.jwt.spring.movieJwtSpring.service;

import com.movie.jwt.spring.movieJwtSpring.model.User;
import com.movie.jwt.spring.movieJwtSpring.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    private TokenService tokenService;

    @Autowired
    public UserService(UserRepository userRepository, TokenService tokenService) {
        this.userRepository = userRepository;
        this.tokenService = tokenService;
    }

    public User getUser(ObjectId id) {
        Optional<User> optionalUser = userRepository.findById(id);

        return optionalUser.orElseGet(optionalUser::get);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }


    public String signup(User user){

        User savedUser = userRepository.save(user);
        return "{" +
                "\"message\":"+"\"Successfully Created User\",\n"+
                "\"data\":"+savedUser+",\n"+
                "}";
    }

    public String login(String email, String password){
        List<User> foundUsers = userRepository.getUsersByEmail(email);

        if(foundUsers.isEmpty()){
            return "{\n" +
                    "\"message\":"+"\" Authentication Failed !!! (USER NOT FOUND) \",\n"+
                    "}";
        }

        else if(!foundUsers.get(0).getPassword().equals(password)){
            return "{\n" +
                    "\"message\":"+"\" Password Incorrect !!!\",\n"+
                    "}";
        }
        return "{\n" +
                "\"message\":"+"\" Successfully Logged-in\",\n"+
                "\"data\": {\n"+" Name : "+foundUsers.get(0).getName()+",\n"+
                            "Email : "+foundUsers.get(0).getEmail()+"\n"+
                "\"token\":\""+tokenService.createToken(foundUsers.get(0).getId())+"\"" +
                "}";

    }

}
