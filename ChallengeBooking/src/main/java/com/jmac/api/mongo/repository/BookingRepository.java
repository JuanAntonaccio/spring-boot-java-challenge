package com.jmac.api.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jmac.api.mongo.models.Booking;





@Repository
public interface BookingRepository extends MongoRepository<Booking, String> {

}
