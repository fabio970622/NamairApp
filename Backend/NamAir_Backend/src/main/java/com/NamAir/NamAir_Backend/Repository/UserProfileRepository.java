package com.NamAir.NamAir_Backend.Repository;

import com.NamAir.NamAir_Backend.Model.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserProfileRepository extends MongoRepository<UserProfile, String> {
}
