package com.globallogic.springbootkafkaproducer.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

@Entity
@Table(name = "record")
public class Record implements Serializable {

	private static final long serialVersionUID = -4551953276601557391L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	int recordId;

	String diagnosedBy;
	String lastReceivedMedicine;

	public int getRecordId() {
		return recordId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}

	public Record() {
		super();

	}

	public Record(int recordId, String diagnosedBy, String lastReceivedMedicine) {
		super();
		this.recordId = recordId;
		this.diagnosedBy = diagnosedBy;
		this.lastReceivedMedicine = lastReceivedMedicine;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
