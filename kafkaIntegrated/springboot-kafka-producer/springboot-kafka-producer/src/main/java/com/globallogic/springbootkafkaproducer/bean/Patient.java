
package com.globallogic.springbootkafkaproducer.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "patient")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Patient implements Serializable {
	private static final long serialVersionUID = -4551323276601557391L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String city;
	private String status;
	private long phoneNo;
	private int recordId;
//	@OneToOne(cascade = CascadeType.ALL)
//	Record record;

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Patient(int id, String name, String city, String status, long phoneNo, Record record) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.status = status;
		this.phoneNo = phoneNo;
//		this.record = record;
	
	}

//	public Record getRecord() {
//		return record;
//	}
//
//	public void setRecord(Record record) {
//		this.record = record;
//	}



	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
