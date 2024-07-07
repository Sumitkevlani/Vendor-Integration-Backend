package com.kevlanisumit.vendorintegration.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "transactions")
public class Transaction {

    @Id
    private String id;

    private String transactionId;
    private Double amount;
    private String vendorId;
    private String status;
    private String time;
    private String type;
    private String paymentMethod;
    private String contactEmail;
    private String billingAddress;
    private String notes;
    private List<Attachment> attachments;

    // Constructors, getters, and setters

    public Transaction() {
    }

    public Transaction(String id, String transactionId, double amount, String vendorId, String status, String time, String type, String paymentMethod, String contactEmail, String billingAddress, String notes, List<Attachment> attachments) {
        this.id = id;
        this.transactionId = transactionId;
        this.amount = amount;
        this.vendorId = vendorId;
        this.status = status;
        this.time = time;
        this.type = type;
        this.paymentMethod = paymentMethod;
        this.contactEmail = contactEmail;
        this.billingAddress = billingAddress;
        this.notes = notes;
        this.attachments = attachments;
    }

    // Getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    // Inner class for Attachment
    public static class Attachment {
        private String name;
        private String url;

        // Constructors, getters, and setters for Attachment

        public Attachment() {
        }

        public Attachment(String name, String url) {
            this.name = name;
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
