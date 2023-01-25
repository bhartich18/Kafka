package com.globallogic.springbootkafkaproducer.repo;

import org.springframework.data.repository.CrudRepository;

import com.globallogic.springbootkafkaproducer.bean.Record;

public interface RecordRepo extends CrudRepository<Record,Integer> {

}
