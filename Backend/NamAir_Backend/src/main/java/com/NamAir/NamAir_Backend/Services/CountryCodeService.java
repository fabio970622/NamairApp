package com.NamAir.NamAir_Backend.Services;

import com.NamAir.NamAir_Backend.Model.CountryCode;
import com.NamAir.NamAir_Backend.Repository.CountryCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryCodeService {

    @Autowired
    private CountryCodeRepository countryCodeRepository;

    public List<CountryCode> getAllCountryCodes() {
        return countryCodeRepository.findAll();
    }
//    public CountryCode Add() {
//        CountryCode countryCode = new CountryCode();
//        countryCode.setCode("+44");
//        countryCode.setName("United Kingdom (+44)");
//
//
//        return countryCodeRepository.save(countryCode);
//    }
}
