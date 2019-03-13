package com.example.demoexternal.service;

import com.example.demoexternal.enums.TransferRequestStatus;
import com.example.demoexternal.model.RawTransferRequest;
import com.example.demoexternal.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferService {

    private final TransferRepository transferRepository;

    @Autowired
    public TransferService(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }

    public void first() {

    }

    public void save() {
        RawTransferRequest transferRequest = new RawTransferRequest();
        transferRequest.setPaymentSystem("Bepaid");
        transferRequest.setStatus(TransferRequestStatus.PROCESSED);
        transferRepository.save(transferRequest);
    }
}
