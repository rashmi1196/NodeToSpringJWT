package com.movie.jwt.spring.movieJwtSpring.repository;

import com.movie.jwt.spring.movieJwtSpring.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
//  @Query("{email:\"?0\", password:\"?1\"}")
@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
    @Query("{email:\"?0\"}")
    List<User> getUsersByEmail(String email);
}
