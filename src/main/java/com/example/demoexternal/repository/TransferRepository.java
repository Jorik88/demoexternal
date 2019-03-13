package com.example.demoexternal.repository;

import com.example.demoexternal.model.RawTransferRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransferRepository extends MongoRepository<RawTransferRequest, String> {
}
