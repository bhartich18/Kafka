package com.globallogic.springkafkaconsumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globallogic.springkafkaconsumer.entity.MedicalHistory;



@Repository
public interface MedicalHistoryRepo extends JpaRepository<MedicalHistory, Integer> {
}
