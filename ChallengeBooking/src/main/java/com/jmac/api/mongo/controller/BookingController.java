package com.jmac.api.mongo.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmac.api.mongo.models.Booking;
import com.jmac.api.mongo.service.BookingService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/v1/booking")

public class BookingController {
	
	@Autowired
	private BookingService bkService;
	
	@GetMapping
	public ResponseEntity<List<Booking>> get(){
		HttpStatus status = null;
		List<Booking> notiList = new ArrayList<>();
		try {
			notiList = bkService.findAll();
			if(notiList.size()>0) {
				status = HttpStatus.OK;
				
			}else {
				status = HttpStatus.NO_CONTENT;
			}
		}catch(Exception e) {
		   log.error("Exception",e);
		   status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<List<Booking>>(notiList, status);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Booking>  getById(@PathVariable("id") String id){
		HttpStatus status = null;
		Booking bki = new Booking();
		try {
			bki = bkService.findById(id);
			if(bki != null) {
				status = HttpStatus.OK;
				
			}else {
				status = HttpStatus.NOT_FOUND;
			}
		}catch(Exception e) {
		   log.error("Exception",e);
		   status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Booking>(bki, status);
	}
	
	@PostMapping
	public ResponseEntity<Booking> post(@RequestBody Booking booking){
		HttpStatus status = null;
		Booking bki = new Booking();
		
		System.out.println(booking.getDeparture());
		
		try {
			bki = bkService.add(booking);
			status = HttpStatus.CREATED;
			
		}catch(Exception e) {
		   log.error("Exception",e);
		   status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return  ResponseEntity.status(status).body(bki);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Booking> put(@RequestBody Booking booking,@PathVariable("id")String id){
		HttpStatus status = null;
		Booking bki = new Booking();
		try {
			bki.setId(id);
			bki = bkService.update(booking);
			status=HttpStatus.CREATED;
			
			
		}catch(Exception e) {
			log.error("Exception",e);
			status=HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return ResponseEntity.status(status).body(bki);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Booking> delete(@PathVariable("id")String id){
		HttpStatus status = null;
		try {
			bkService.deleteById(id);
			status = HttpStatus.NO_CONTENT;
		} catch(Exception e) {
			log.error("Exception",e);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Booking>(status);
	}
	
	

}
