package com.globallogic.springkafkaproducer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.globallogic.springkafkaproducer.entity.MedicalHistory;

@EnableJpaRepositories

@Repository
public interface MedicalHistoryRepo extends JpaRepository<MedicalHistory, Integer> {
}
