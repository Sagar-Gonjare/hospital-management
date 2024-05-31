package org.dnyanyog.entity;

import org.springframework.stereotype.Component;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Entity
@Table
public class Cases {
  @Column @Id @GeneratedValue private Long caseId;

  @Column private String patientName;
  @Column private String patientId;
  @Column private String caseNo;
  @Column private String examinationDate;
  @Column private String symptoms;
  @Column private String prescription;
  @Column private String status;

  public static Cases getInsatnce() {
    return new Cases();
  }

  public Long getCaseId() {
    return caseId;
  }

  public Cases setCaseId(Long caseId) {
    this.caseId = caseId;
    return this;
  }

  public String getPatientName() {
    return patientName;
  }

  public Cases setPatientName(String patientName) {
    this.patientName = patientName;
    return this;
  }

  public String getPatientId() {
    return patientId;
  }

  public Cases setPatientId(String patientId) {
    this.patientId = patientId;
    return this;
  }

  public String getCaseNo() {
    return caseNo;
  }

  public Cases setCaseNo(String caseNo) {
    this.caseNo = caseNo;
    return this;
  }

  public String getExaminationDate() {
    return examinationDate;
  }

  public Cases setExaminationDate(String examinationDate) {
    this.examinationDate = examinationDate;
    return this;
  }

  public String getSymptoms() {
    return symptoms;
  }

  public Cases setSymptoms(String symptoms) {
    this.symptoms = symptoms;
    return this;
  }

  public String getPrescription() {
    return prescription;
  }

  public Cases setPrescription(String prescription) {
    this.prescription = prescription;
    return this;
  }

  public String getStatus() {
    return status;
  }

  public Cases setStatus(String status) {
    this.status = status;
    return this;
  }
}
