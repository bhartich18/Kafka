package com.globallogic.springbootkafkaproducer.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.globallogic.springbootkafkaproducer.bean.Patient;

@Repository
public interface PatientRepo extends CrudRepository<Patient,Integer> {

}
