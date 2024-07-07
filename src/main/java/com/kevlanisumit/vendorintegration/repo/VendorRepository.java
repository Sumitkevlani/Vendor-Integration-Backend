package com.kevlanisumit.vendorintegration.repo;

import com.kevlanisumit.vendorintegration.models.Vendor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VendorRepository extends MongoRepository<Vendor, String> {
}