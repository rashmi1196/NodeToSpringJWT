package com.movie.jwt.spring.movieJwtSpring.service;

import com.movie.jwt.spring.movieJwtSpring.model.User;
import com.movie.jwt.spring.movieJwtSpring.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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


    public String saveUser(User user){
        /*
            {
	            message: “Successfully Created User”,
	            data: savedUserDocument,
	            token: secretToken
            }
        */

        User savedUser = userRepository.save(user);
        return "{" +
                "\"message\":"+"\"Successfully Created User\",\n"+
                "\"data\":"+savedUser+",\n"+

                "\"token\":\""+tokenService.createToken(savedUser.getId())+"\"" +
                "}";
    }

}
