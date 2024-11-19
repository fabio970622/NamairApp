package com.NamAir.NamAir_Backend.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "userProfiles")
@Data
public class UserProfile {

    @Id
    private String id;

    private String name;

    private String surname;

    private String email;

    private String password;

    private String phoneNumber;

    private String idNumber;

    private LocalDateTime dateCreated = LocalDateTime.now();

    // No-argument constructor
    public UserProfile() {
    }

    // All-arguments constructor
    public UserProfile(String name, String surname, String email, String phoneNumber, String idNumber) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.idNumber = idNumber;
    }
}
