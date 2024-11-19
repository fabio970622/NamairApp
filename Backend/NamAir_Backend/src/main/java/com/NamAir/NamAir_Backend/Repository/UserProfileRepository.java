package com.NamAir.NamAir_Backend.Repository;

import com.NamAir.NamAir_Backend.Model.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserProfileRepository extends MongoRepository<UserProfile, String> {
    List<UserProfile> findByEmail(String email);
}
