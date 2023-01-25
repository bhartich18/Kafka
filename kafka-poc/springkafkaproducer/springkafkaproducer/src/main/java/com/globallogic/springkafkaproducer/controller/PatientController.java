package com.globallogic.springkafkaproducer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.springkafkaproducer.entity.Patient;
import com.globallogic.springkafkaproducer.serviceImpl.PatientService;

@RestController
@RequestMapping(value = "/order")
public class PatientController {


  @Autowired
 PatientService patientService;

  @PostMapping(value = "/create")
  public Patient addPatient(@RequestBody Patient patient) {

    patient=patientService.addPatient(patient);
    return patient;
  }

  @GetMapping("/all")
  public List<Patient> getPatient() {

    return patientService.getAllPatients();
  }
}