package com.globallogic.springkafkaproducer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.springkafkaproducer.entity.MedicalHistory;
import com.globallogic.springkafkaproducer.repository.MedicalHistoryRepo;

@RestController
	@RequestMapping("/patient")
	public class MedicalHistoryController {

	  @Autowired
	  MedicalHistoryRepo medicalHistoryRepo;

	  @GetMapping("/all")
	  public List<MedicalHistory> getAllHistory() {
	    List<MedicalHistory> users = (List<MedicalHistory>) medicalHistoryRepo.findAll();
	    return users;
	  }

	  @PostMapping("/save")
	  public  MedicalHistory saveHistory(@RequestBody MedicalHistory medicalHistory) {
		  medicalHistory = medicalHistoryRepo.save(medicalHistory);
	    return medicalHistory;
	  }

	}

