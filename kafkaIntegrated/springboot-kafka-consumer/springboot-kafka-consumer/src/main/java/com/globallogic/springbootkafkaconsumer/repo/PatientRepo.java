package com.globallogic.springbootkafkaconsumer.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.globallogic.springbootkafkaconsumer.entity.Patient;



@Repository
public interface PatientRepo extends CrudRepository<Patient,Integer> {

}
