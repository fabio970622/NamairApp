package com.NamAir.NamAir_Backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.NamAir.NamAir_Backend.Model.UserProfile;
import com.NamAir.NamAir_Backend.Repository.UserProfileRepository;

import java.util.Collections;
import java.util.List;

@Service
public class UserProfileService implements UserDetailsService {
    @Autowired
    private UserProfileRepository userProfileRepository;

    public UserProfile createProfile(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    public UserProfile getProfile(String id) {
        return userProfileRepository.findById(id).orElse(null);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<UserProfile> getUser = userProfileRepository.findByEmail(username);

        UserProfile user = getUser.get(0);
        if (user.getEmail().equals(username)) {
            return new User(user.getEmail(), new BCryptPasswordEncoder().encode(user.getPassword()), Collections.emptyList());
        }
        throw new UsernameNotFoundException("User not found");
    }
}
