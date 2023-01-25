package com.globallogic.springbootkafkaproducer.controller;

import com.globallogic.springbootkafkaproducer.bean.Patient;
import com.globallogic.springbootkafkaproducer.service.PatientService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/patient")
public class PatientController {


  @Autowired
  private PatientService patientService;

  @PostMapping(value = "/create")
  public Patient addPatient(@RequestBody Patient patient) {

    patient=patientService.addPatient(patient);
    return patient;
  }

  @GetMapping("/all")
  public List<Patient> getPatients() {

    return patientService.getAllPatients();
  }
}
