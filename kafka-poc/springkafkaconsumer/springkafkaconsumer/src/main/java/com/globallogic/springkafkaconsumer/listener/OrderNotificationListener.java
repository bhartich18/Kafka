package com.globallogic.springkafkaconsumer.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.globallogic.springkafkaconsumer.entity.Patient;
import com.globallogic.springkafkaconsumer.repository.MedicalHistoryRepo;
import com.globallogic.springkafkaconsumer.repository.PatientRepo;

@Service
public class OrderNotificationListener {

  @Value("${patient.topic.name}")
  private String topicName;

  @Autowired
   PatientRepo patientRepo ;
  @Autowired
MedicalHistoryRepo medicalHistoryRepo;

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
//    User user = userCRUD.findById(order.getUserId()).get();
//    if (user.getBalance() > order.getOrderAmount()) {
//      user.setBalance(user.getBalance() - order.getOrderAmount());
//      order.setStatus("SUCCESS");
//      userCRUD.save(user);
//      orderCRUD.save(order);
//    } else {
//      order.setStatus("FAILED");
//      orderCRUD.save(order);
//    }

  }
}