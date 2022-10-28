package com.node.jwt.spring.jwt.repository;

import com.node.jwt.spring.jwt.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
    @Query("{email:\"?0\"}")
    List<User> getUsersByEmail(String email);
}
