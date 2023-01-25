package com.globallogic.springbootkafkaproducer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.globallogic.springbootkafkaproducer.bean.Patient;
import com.globallogic.springbootkafkaproducer.repo.PatientRepo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

  @Autowired
  PatientRepo patientRepo;

  @Value("${patient.topic.name}")
  private String topicName;

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  ObjectMapper om=new ObjectMapper();

  public Patient addPatient(Patient patient) {
    patient =patientRepo.save(patient);
    patient.setStatus("CREATED");
    // after saving order lets release msg for payment service
    String message= null;
    try {
      message = om.writeValueAsString(patient);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    kafkaTemplate.send(topicName,message);
    return patient;
  }

  public List<Patient> getAllPatients() {
    List<Patient> patients= (List<Patient>) patientRepo.findAll();
    return patients;
  }
}
