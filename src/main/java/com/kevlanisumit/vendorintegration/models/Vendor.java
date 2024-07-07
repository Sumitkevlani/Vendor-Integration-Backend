package com.kevlanisumit.vendorintegration.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
// import io.swagger.annotations.ApiModelProperty;

@Document(collection = "vendor")
public class Vendor {
    @Id
    // @ApiModelProperty(value = "Vendor ID", example = "60c72b2f9f1b9c6d88f3c8b4")
    private String id;

    // @ApiModelProperty(value = "Vendor name", example = "Acme Corp")
    private String name;

    // @ApiModelProperty(value = "Vendor address", example = "123 Main St")
    private String address;

    // @ApiModelProperty(value = "Vendor contact number", example = "123-456-7890")
    private String contactNumber;

    // @ApiModelProperty(value = "Vendor logo URL", example = "https://example.com/logo.png")
    private String logo;

    // @ApiModelProperty(value = "Type of vendor (Buyer or Seller)", example = "Buyer")
    private String type;

    // @ApiModelProperty(value = "Contract period", example = "1 year")
    private String contractPeriod;

    // @ApiModelProperty(value = "Contract ending date", example = "2025-07-06")
    private String contractEnding;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContractPeriod() {
        return contractPeriod;
    }

    public void setContractPeriod(String contractPeriod) {
        this.contractPeriod = contractPeriod;
    }

    public String getContractEnding() {
        return contractEnding;
    }

    public void setContractEnding(String contractEnding) {
        this.contractEnding = contractEnding;
    }
}
