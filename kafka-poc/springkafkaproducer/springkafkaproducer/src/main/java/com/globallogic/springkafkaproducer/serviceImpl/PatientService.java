package com.globallogic.springkafkaproducer.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.globallogic.springkafkaproducer.entity.Patient;
import com.globallogic.springkafkaproducer.repository.PatientRepo;

@Service
public class PatientService {

	@Autowired
	PatientRepo patientRepo;
	
	@Value("${patient.topic.name}")
	private String topicName;
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	
	ObjectMapper om = new ObjectMapper();

	public Patient addPatient(Patient patient) {
		patient = patientRepo.save(patient);
		patient.setStatus("CREATED");
		// after saving order lets release msg for payment service
		String message = null;
		try {
			message = om.writeValueAsString(patient);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		kafkaTemplate.send(topicName, message);
		return patient;
	}

	public List<Patient> getAllPatients() {
		List<Patient> orders = (List<Patient>) patientRepo.findAll();
		return orders;
	}
}
