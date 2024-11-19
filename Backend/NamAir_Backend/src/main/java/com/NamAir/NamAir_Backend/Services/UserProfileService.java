package com.NamAir.NamAir_Backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NamAir.NamAir_Backend.Model.UserProfile;
import com.NamAir.NamAir_Backend.Repository.UserProfileRepository;

@Service
public class UserProfileService {
    @Autowired
    private UserProfileRepository userProfileRepository;

    public UserProfile createProfile(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    public UserProfile getProfile(String id) {
        return userProfileRepository.findById(id).orElse(null);
    }
}
