package com.globallogic.springbootkafkaproducer.controller;


import com.globallogic.springbootkafkaproducer.bean.Record;
import com.globallogic.springbootkafkaproducer.repo.RecordRepo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/record")
public class RecordController {

  @Autowired
  RecordRepo recordRepo;

  @GetMapping("/all")
  public List<Record> getAllUser() {
    List<Record> records = (List<Record>) recordRepo.findAll();
    return records;
  }

  @PostMapping("/save")
  public Record saveUser(@RequestBody Record record) {
    record = recordRepo.save(record);
    return record;
  }

}
