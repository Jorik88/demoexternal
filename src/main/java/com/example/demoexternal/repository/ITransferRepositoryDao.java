package com.example.demoexternal.repository;

import com.example.demoexternal.model.TransferRequest;

public interface ITransferRepositoryDao {

    boolean findAndModifyByIdAndStatus(String transferRequestId, String status);
}
