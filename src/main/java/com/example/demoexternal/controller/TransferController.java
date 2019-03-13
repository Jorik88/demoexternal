package com.example.demoexternal.controller;

import com.example.demoexternal.model.TransferRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;

@RestController
public class TransferController {

    @GetMapping("/transfer")
    public TransferRequest getRequest() {
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.setAmount(BigDecimal.TEN);
        transferRequest.setCurrency("USD");
        transferRequest.setPaymentSystem("Bepaid");
        transferRequest.setTargetWallet("34242354345346546");
        transferRequest.setTransferRequestId("some id");
        return transferRequest;
    }

    @PostMapping("/check")
    public ResponseEntity check(@RequestBody TransferRequest transferRequest) {
        System.out.println(transferRequest);
        return ResponseEntity.ok().build();
    }
}
