package com.example.demoexternal.service;

import com.example.demoexternal.enums.TransferRequestStatus;
import com.example.demoexternal.model.TransferRequest;
import com.example.demoexternal.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class TransferService {

    private final TransferRepository transferRepository;

    @Autowired
    public TransferService(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }

    @Transactional
    public void first() {
        Optional<TransferRequest> byId = transferRepository.findById("5c8a1513875d333e2961ba1b");
        updateStatus(byId.get().getId());

        throw new IllegalStateException("exception happened");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateStatus(String transferId) {
        TransferRequest transferRequest = transferRepository.findById(transferId).get();
        transferRequest.setPaymentSystem("Bepaid");
        transferRequest.setStatus(TransferRequestStatus.PROCESSED);
        transferRepository.save(transferRequest);
        throw new IllegalStateException("");
    }
}
