package or.dnyanyog.dto.response;

import org.springframework.stereotype.Component;

@Component
public class AppointmentData {
  private Long appointmentId;

  private String patientName;

  private String patientid;

  private String examinationDate;

  private String appointmentTime;

  public static AppointmentData getInstance() {
    return new AppointmentData();
  }

  public Long getAppointmentId() {
    return appointmentId;
  }

  public AppointmentData setAppointmentId(Long appointmentId) {
    this.appointmentId = appointmentId;
    return this;
  }

  public String getPatientName() {
    return patientName;
  }

  public AppointmentData setPatientName(String patientName) {
    this.patientName = patientName;
    return this;
  }

  public String getPatientid() {
    return patientid;
  }

  public AppointmentData setPatientid(String patientid) {
    this.patientid = patientid;
    return this;
  }

  public String getExaminationDate() {
    return examinationDate;
  }

  public AppointmentData setExaminationDate(String examinationDate) {
    this.examinationDate = examinationDate;
    return this;
  }

  public String getAppointmentTime() {
    return appointmentTime;
  }

  public AppointmentData setAppointmentTime(String appointmentTime) {
    this.appointmentTime = appointmentTime;
    return this;
  }
}
