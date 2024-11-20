package com.NamAir.NamAir_Backend.Controller;

import com.NamAir.NamAir_Backend.Model.UserProfile;
import com.NamAir.NamAir_Backend.Services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/profiles")
public class UserProfileController {
    @Autowired
    private UserProfileService userProfileService;

    @PostMapping("/create-profile")
    public UserProfile createProfile(@RequestBody UserProfile userProfile) {
        return userProfileService.createProfile(userProfile);
    }

    @GetMapping("/{id}")
    public UserProfile getProfile(@PathVariable String id) {
        return userProfileService.getProfile(id);
    }
}
