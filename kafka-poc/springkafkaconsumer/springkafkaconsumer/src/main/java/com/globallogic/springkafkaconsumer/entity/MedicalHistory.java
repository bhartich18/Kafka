package com.globallogic.springkafkaconsumer.entity;

import java.time.LocalDate;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class MedicalHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int recordId;
	LocalDate lastAppointmentDate;
	String diagnosedBy;
	String lastReceivedMedicine;

	
	public int getRecordId() {
		return recordId;
	}
	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}
	public LocalDate getLastAppointmentDate() {
		return lastAppointmentDate;
	}
	public void setLastAppointmentDate(LocalDate lastAppointmentDate) {
		this.lastAppointmentDate = lastAppointmentDate;
	}
	public String getDiagnosedBy() {
		return diagnosedBy;
	}
	public void setDiagnosedBy(String diagnosedBy) {
		this.diagnosedBy = diagnosedBy;
	}
	public String getLastReceivedMedicine() {
		return lastReceivedMedicine;
	}
	public void setLastReceivedMedicine(String lastReceivedMedicine) {
		this.lastReceivedMedicine = lastReceivedMedicine;
	}
	public MedicalHistory(int id, LocalDate lastAppointmentDate, String diagnosedBy, String lastReceivedMedicine) {
		super();
		this.recordId = recordId;
		this.lastAppointmentDate = lastAppointmentDate;
		this.diagnosedBy = diagnosedBy;
		this.lastReceivedMedicine = lastReceivedMedicine;
	}
	@Override
	public String toString() {
		return "MedicalHistory [recordId=" + recordId + ", lastAppointmentDate=" + lastAppointmentDate + ", diagnosedBy="
				+ diagnosedBy + ", lastReceivedMedicine=" + lastReceivedMedicine + "]";
	}
	public MedicalHistory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
