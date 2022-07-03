package com.jmac.api.mongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jmac.api.mongo.models.Booking;
import com.jmac.api.mongo.repository.BookingRepository;



@Service
public class BookingService {
	
	@Autowired
	private BookingRepository bkRepository;
	
	public List<Booking> findAll(){
		return bkRepository.findAll();
	}
	
	public Booking findById(String id) {
		Booking boki = null;
		Optional<Booking> result = bkRepository.findById(id);
		if(result.isPresent()){
			boki= result.get();
		}
		return boki;
		
	}
	
	public Booking add(Booking boki) {
		return bkRepository.save(boki);
	}
	
	public Booking update(Booking boki) {
		return bkRepository.save(boki);
	}
	
	@Transactional
	public void deleteById(String id) {
		bkRepository.deleteById(id);
	}

}
