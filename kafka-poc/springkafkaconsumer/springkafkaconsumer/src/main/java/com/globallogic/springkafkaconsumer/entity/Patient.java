package com.globallogic.springkafkaconsumer.entity;

import java.io.Serializable;

import org.springframework.lang.NonNull;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Patient implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	int patientId;

	@NonNull
	private String name;
	@NonNull
	private String city;

	@NonNull
	private double phoneNo;
	@NonNull
	private int recordId;
	
	 private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Patient(int patientId, String name, String city, double phoneNo, int recordId, String status) {
		super();
		this.patientId = patientId;
		this.name = name;
		this.city = city;
		this.phoneNo = phoneNo;
		this.recordId = recordId;
		this.status = status;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
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

	public double getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(double phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getRecordId() {
		return recordId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", name=" + name + ", city=" + city + ", phoneNo=" + phoneNo
				+ ", recordId=" + recordId + ", status=" + status + "]";
	}

}