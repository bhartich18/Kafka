package com.globallogic.springbootkafkaconsumer.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.globallogic.springbootkafkaconsumer.entity.Patient;
import com.globallogic.springbootkafkaconsumer.repo.PatientRepo;
import com.globallogic.springbootkafkaconsumer.repo.RecordRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderNotificationListener {

  @Value("${patient.topic.name}")
  private String topicName;
//  @Autowired
//  RecordRepo recordRepo;
  @Autowired
  PatientRepo patientRepo;


  @KafkaListener(topics = "patient-topic", groupId = "foo")
  public void listenGroupFoo(String message) {
    System.out.println("Received Message in group foo: " + message);
    ObjectMapper object = new ObjectMapper();
    Patient patient = null;
    try {
      patient = object.readValue(message, Patient.class);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
//    Record record = recordRepo.findById(patient.getRecordId()).get();
    patientRepo.save(patient);
//    recordRepo.save(record);

//    if (record.getBalance() > patient.getOrderAmount()) {
//       record.setBalance(record.getBalance() - order.getOrderAmount());
   
//      patientRepo.save(patient);
    }

  }

