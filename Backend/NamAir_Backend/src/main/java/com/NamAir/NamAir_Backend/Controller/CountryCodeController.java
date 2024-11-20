package com.NamAir.NamAir_Backend.Controller;

import com.NamAir.NamAir_Backend.Model.CountryCode;
import com.NamAir.NamAir_Backend.Services.CountryCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryCodeController {

    @Autowired
    private CountryCodeService countryCodeService;

    @GetMapping("/api/auth/country-codes")
    public List<CountryCode> getAllCountryCodes() {
        //countryCodeService.Add();
        return countryCodeService.getAllCountryCodes();
    }
}
