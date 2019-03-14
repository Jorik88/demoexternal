package com.example.demoexternal.repository;

import com.example.demoexternal.model.TransferRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransferRepository extends MongoRepository<TransferRequest, String> {

}
