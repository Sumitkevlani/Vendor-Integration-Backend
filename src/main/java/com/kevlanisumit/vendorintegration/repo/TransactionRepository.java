package com.kevlanisumit.vendorintegration.repo;

import com.kevlanisumit.vendorintegration.models.Transaction;
import java.util.Optional;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
    List<Transaction> findByVendorId(String vendorId);
    Optional<Transaction> findByTransactionId(String transactionId);
}