package com.NamAir.NamAir_Backend.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Airport {
    @Id
    private String code;
    private String name;
}
