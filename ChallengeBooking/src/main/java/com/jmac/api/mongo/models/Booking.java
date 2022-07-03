package com.jmac.api.mongo.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;


// anotaciones de lombok


@Document(collection="bookings")
@Data
@NoArgsConstructor
public class Booking {
	
	@Id
	private String id;
	
	private String name;
	
	private String email;
	
	private String origin;
	
	private String destination;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime departure;
	
	// in minutes is the duration
	private int duration;
	

}
