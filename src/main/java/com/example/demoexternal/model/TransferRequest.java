package com.example.demoexternal.model;

import com.example.demoexternal.enums.TransferRequestStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("transferRequest")
public class TransferRequest {

    @Id
    private String id;
    private String transferRequestId;
    private String paymentSystem;
    private String currency;
    private String targetWallet;
    private BigDecimal amount;
    private boolean taxFromSender;
    private TransferRequestStatus status;
}
