package com.NamAir.NamAir_Backend.Repository;

import com.NamAir.NamAir_Backend.Model.CountryCode;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CountryCodeRepository extends MongoRepository<CountryCode, String> {
}
