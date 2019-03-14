package com.example.demoexternal.repository;

import com.example.demoexternal.enums.TransferRequestStatus;
import com.example.demoexternal.model.TransferRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;

@Slf4j
@Repository
public class TransferRepositoryDao implements ITransferRepositoryDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public boolean findAndModifyByIdAndStatus(String transferRequestId, String status) {
        Query query = new Query(new Criteria().andOperator(Criteria.where("_id").is(transferRequestId), Criteria.where("status").is(status)));
        Update update = new Update().set("status", TransferRequestStatus.PROCESSED).set("updateDate", LocalDateTime.now());
        FindAndModifyOptions findAndModifyOptions = new FindAndModifyOptions();
        findAndModifyOptions.upsert(false);
        try{
            TransferRequest updated = mongoTemplate.findAndModify(query, update, findAndModifyOptions ,TransferRequest.class);
            if (update != null) {
                return true;
            }
        }catch (DuplicateKeyException e) {
            return false;
        }
        return false;
    }
}
