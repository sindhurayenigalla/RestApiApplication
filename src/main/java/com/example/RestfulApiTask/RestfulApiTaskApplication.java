package com.example.RestfulApiTask;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.example.bean.Station;
import com.example.controller.StationController;

@SpringBootApplication
@ComponentScan("com.example")
public class RestfulApiTaskApplication implements CommandLineRunner {

	   private Logger logger = LoggerFactory.getLogger(this.getClass());

	    @Autowired
	    StationController repository;
	    public static void main(String[] args) {
	        ApplicationContext ctx=SpringApplication.run(RestfulApiTaskApplication.class, args);
	       
	    }
		@Override
		public void run(String... args) throws Exception {
			// TODO Auto-generated method stub
			logger.info("All stations list by id or name -> {}", repository.findByStationIdName("station3", "Hyd"));
			
			// logger.info("Inserting -> {}", repository.insert(new Station("station3", "Vijayawada", true,"no")));
			  logger.info("Deleted the station"+repository.deleteByStationId("station2"));
			 logger.info("All sttaions that are HdEnabled -> {}", repository.findAllHdEnabled());
			 logger.info("All stations list -> {}", repository.findAll());

			 
		}
		
	   
	}

