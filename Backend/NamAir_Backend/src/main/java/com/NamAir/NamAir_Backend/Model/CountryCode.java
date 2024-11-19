package com.NamAir.NamAir_Backend.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class CountryCode {
    @Id
    private String code;
    private String name;
}
