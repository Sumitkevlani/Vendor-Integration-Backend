package com.kevlanisumit.vendorintegration.controller;

import com.kevlanisumit.vendorintegration.models.Vendor;
import com.kevlanisumit.vendorintegration.repo.VendorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/vendors")
public class VendorController {
    @Autowired
    private VendorRepository vendorRepository;

    // Create a new vendor
    @PostMapping
    public ResponseEntity<Vendor> createVendor(@RequestBody Vendor vendor) {
        Vendor savedVendor = vendorRepository.save(vendor);
        return new ResponseEntity<>(savedVendor, HttpStatus.CREATED);
    }

    // Get all vendors
    @GetMapping
    public ResponseEntity<List<Vendor>> getAllVendors() {
        List<Vendor> vendors = vendorRepository.findAll();
        return new ResponseEntity<>(vendors, HttpStatus.OK);
    }

    // Get one vendor detail by its ID
    @GetMapping("/{id}")
    public ResponseEntity<Vendor> getVendorById(@PathVariable String id) {
        Optional<Vendor> vendor = vendorRepository.findById(id);
        return vendor.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                     .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update vendor details
    @PutMapping("/{id}")
    public ResponseEntity<Vendor> updateVendor(@PathVariable String id, @RequestBody Vendor vendorDetails) {
        Optional<Vendor> vendorOptional = vendorRepository.findById(id);
        if (vendorOptional.isPresent()) {
            Vendor vendor = vendorOptional.get();

            // Update only the fields that are provided in the request
            vendor.setName(
                vendorDetails.getName() != null ? vendorDetails.getName() : vendor.getName()
            );
            vendor.setAddress(
                vendorDetails.getAddress() != null ? vendorDetails.getAddress() : vendor.getAddress()
            );
            vendor.setContactNumber(
                vendorDetails.getContactNumber() != null ? vendorDetails.getContactNumber() : vendor.getContactNumber()
            );
            vendor.setLogo(
                vendorDetails.getLogo() != null ? vendorDetails.getLogo() : vendor.getLogo()
            );
            vendor.setType(
                vendorDetails.getType() != null ? vendorDetails.getType() : vendor.getType()
            );
            vendor.setContractPeriod(
                vendorDetails.getContractPeriod() != null ? vendorDetails.getContractPeriod() : vendor.getContractPeriod()
            );
            vendor.setContractEnding(
                vendorDetails.getContractEnding() != null ? vendorDetails.getContractEnding() : vendor.getContractEnding()
            );

            Vendor updatedVendor = vendorRepository.save(vendor);
            return new ResponseEntity<>(updatedVendor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    // Delete a vendor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVendor(@PathVariable String id) {
        Optional<Vendor> vendorOptional = vendorRepository.findById(id);
        if (vendorOptional.isPresent()) {
            vendorRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
