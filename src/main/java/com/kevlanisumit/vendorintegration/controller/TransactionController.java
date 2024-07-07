package com.kevlanisumit.vendorintegration.controller;

import com.kevlanisumit.vendorintegration.models.Transaction;
import com.kevlanisumit.vendorintegration.repo.TransactionRepository;

// import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/transactions")
public class TransactionController {

    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private TransactionRepository transactionRepository;

    // Create a new transaction
    @PostMapping
    // @ApiOperation(value = "Add a new transaction", notes = "Add a new transaction")
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        Transaction savedTransaction = transactionRepository.save(transaction);
        return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
    }

    // Get all transactions
    @GetMapping
    // @ApiOperation(value = "Get all transactions", notes = "Retrieve all transactions")
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    // Get one transaction by its ID
    @GetMapping("/{id}")
    // @ApiOperation(value = "Get a transaction by ID", notes = "Retrieve a specific transaction by its ID")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable String id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        return transaction.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                         .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update transaction details
    // Update transaction details
    @PutMapping("/{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable String id, @RequestBody Transaction transactionDetails) {
        logger.info("Updating transaction with ID: {}", id);
        Optional<Transaction> transactionOptional = transactionRepository.findById(id);
        if (transactionOptional.isPresent()) {
            Transaction transaction = transactionOptional.get();
    
            // Update only the fields that are provided in the request
            transaction.setTransactionId(
                transactionDetails.getTransactionId() != null ? transactionDetails.getTransactionId() : transaction.getTransactionId()
            );
            transaction.setAmount(
                transactionDetails.getAmount() != null ? transactionDetails.getAmount() : transaction.getAmount()
            );
            transaction.setVendorId(
                transactionDetails.getVendorId() != null ? transactionDetails.getVendorId() : transaction.getVendorId()
            );
            transaction.setStatus(
                transactionDetails.getStatus() != null ? transactionDetails.getStatus() : transaction.getStatus()
            );
            transaction.setTime(
                transactionDetails.getTime() != null ? transactionDetails.getTime() : transaction.getTime()
            );
            transaction.setType(
                transactionDetails.getType() != null ? transactionDetails.getType() : transaction.getType()
            );
            transaction.setPaymentMethod(
                transactionDetails.getPaymentMethod() != null ? transactionDetails.getPaymentMethod() : transaction.getPaymentMethod()
            );
            transaction.setContactEmail(
                transactionDetails.getContactEmail() != null ? transactionDetails.getContactEmail() : transaction.getContactEmail()
            );
            transaction.setBillingAddress(
                transactionDetails.getBillingAddress() != null ? transactionDetails.getBillingAddress() : transaction.getBillingAddress()
            );
            transaction.setNotes(
                transactionDetails.getNotes() != null ? transactionDetails.getNotes() : transaction.getNotes()
            );
            transaction.setAttachments(
                transactionDetails.getAttachments() != null ? transactionDetails.getAttachments() : transaction.getAttachments()
            );
    
            Transaction updatedTransaction = transactionRepository.save(transaction);
            logger.info("Transaction updated: {}", updatedTransaction);
            return new ResponseEntity<>(updatedTransaction, HttpStatus.OK);
        } else {
            logger.warn("Transaction with ID {} not found", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // Delete a transaction
    @DeleteMapping("/{id}")
        // @ApiOperation(value = "Delete a transaction", notes = "Delete a specific transaction by its ID")
    public ResponseEntity<Void> deleteTransaction(@PathVariable String id) {
        try {
            Optional<Transaction> transactionOptional = transactionRepository.findById(id);
            System.out.println(transactionOptional);
            if (transactionOptional.isPresent()) {
                Transaction deletedTransaction = transactionOptional.get();
                transactionRepository.deleteById(id);
                // Log statement for successful deletion
                logger.info("Deleted transaction with ID: {}", id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                // Log statement for transaction not found
                logger.warn("Transaction with ID {} not found", id);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // Log statement for any unexpected errors
            logger.error("Error deleting transaction with ID {}: {}", id, e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get transactions by Vendor ID
    @GetMapping("/vendor/{vendorId}")
    // @ApiOperation(value = "Get transactions by Vendor ID", notes = "Retrieve all transactions for a specific vendor")
    public ResponseEntity<List<Transaction>> getTransactionsByVendorId(@PathVariable String vendorId) {
        List<Transaction> transactions = transactionRepository.findByVendorId(vendorId);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    @GetMapping("/transaction/{transactionId}")
    public ResponseEntity<Transaction> getTransactionByTransactionId(@PathVariable String transactionId) {
        Optional<Transaction> transaction = transactionRepository.findByTransactionId(transactionId);
        return transaction.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PutMapping("/transaction/{transactionId}")
    public ResponseEntity<Transaction> updateTransactionByTransactionId(
            @PathVariable String transactionId,
            @RequestBody Transaction transactionDetails) {
        logger.info("Updating transaction with transactionId: {}", transactionId);
        Optional<Transaction> transactionOptional = transactionRepository.findByTransactionId(transactionId);
        
        if (transactionOptional.isPresent()) {
            Transaction transaction = transactionOptional.get();

            // Update fields from transactionDetails if they are not null
            if (transactionDetails.getTransactionId() != null) {
                transaction.setTransactionId(transactionDetails.getTransactionId());
            }
            // Add other fields here similarly for update

            Transaction updatedTransaction = transactionRepository.save(transaction);
            logger.info("Transaction updated: {}", updatedTransaction);
            return new ResponseEntity<>(updatedTransaction, HttpStatus.OK);
        } else {
            logger.warn("Transaction with transactionId {} not found", transactionId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    

}
