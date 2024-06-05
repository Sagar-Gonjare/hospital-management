package or.dnyanyog.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Component
@Entity
public class Patients {
  @Column @GeneratedValue @Id private Long patientId;
  @Column private String patientNameEnglish;
  @Column private String patientNameMarathi;
  @Column private String mobileNumber;
  @Column private String gender;
  @Column private String birthDate;
  @Column private String firstExaminationDate;
  @Column private String address;
  @Column private String patientStatus;

  public static Patients getInstance() {
	  return new Patients();
  }
  
  public long getPatientId() {
    return patientId;
  }

  public Patients setPatientId(long patientId) {
    this.patientId = patientId;
    return this;
  }

  public String getPatientNameEnglish() {
    return patientNameEnglish;
  }

  public Patients setPatientNameEnglish(String patientNameEnglish) {
    this.patientNameEnglish = patientNameEnglish;
    return this;
  }

  public String getPatientNameMarathi() {
    return patientNameMarathi;
  }

  public Patients setPatientNameMarathi(String patientNameMarathi) {
    this.patientNameMarathi = patientNameMarathi;
    return this;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public Patients setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
    return this;
  }

  public String getGender() {
    return gender;
  }

  public Patients setGender(String gender) {
    this.gender = gender;
    return this;
  }

  public String getBirthDate() {
    return birthDate;
  }

  public Patients setBirthDate(String birthDate) {
    this.birthDate = birthDate;
    return this;
  }

  public String getFirstExaminationDate() {
    return firstExaminationDate;
  }

  public Patients setFirstExaminationDate(String firstExaminationDate) {
    this.firstExaminationDate = firstExaminationDate;
    return this;
  }

  public String getAdress() {
    return address;
  }

  public Patients setAdress(String adress) {
    this.address = adress;
    return this;
  }

  public String getPatientStatus() {
    return patientStatus;
  }

  public Patients setPatientStatus(String patientStatus) {
    this.patientStatus = patientStatus;
    return this;
  }
}
