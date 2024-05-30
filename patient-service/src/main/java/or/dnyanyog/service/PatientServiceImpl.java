package or.dnyanyog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import or.dnyanyog.dto.request.PatientRequest;
import or.dnyanyog.dto.response.PatientData;
import or.dnyanyog.dto.response.PatientResponse;
import or.dnyanyog.entity.Patients;
import or.dnyanyog.repository.PatientRepo;



@Service
@Component
public class PatientServiceImpl  {

  @Autowired PatientResponse response;

  @Autowired Patients patient;

  @Autowired PatientRepo repo;

  public ResponseEntity<PatientResponse> addPatient(PatientRequest request) {
    response = new PatientResponse();
    response.setData( new PatientData());

    if (repo.existsByMobileNumber(request.getMobileNumber())) {
      response = new PatientResponse();
      response.setResponseCode(HttpStatus.UNAUTHORIZED.value());
      response.setResponseMsg("Patient already exist");
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    if (!(request.getAdress().isEmpty()
        && request.getBirthDate().isBlank()
        && request.getFirstExaminationDate().isEmpty()
        && request.getGender().isEmpty()
        && request.getMobileNumber().isEmpty()
        && request.getPatientNameEnglish().isEmpty())) {

      Patients patients =
          Patients.getInstance()
              .setPatientNameEnglish(request.getPatientNameEnglish())
              .setPatientNameMarathi(request.getPatientNameMarathi())
              .setGender(request.getGender())
              .setMobileNumber(request.getMobileNumber())
              .setAdress(request.getAdress())
              .setBirthDate(request.getBirthDate())
              .setPatientStatus("Active")
              .setFirstExaminationDate(request.getFirstExaminationDate());

      patient = repo.save(patients);

      response.setResponseCode(HttpStatus.CREATED.value());
      response.setResponseMsg("Patient added successfully");
      PatientData patientsData =
          PatientData.getInstance()
              .setPatientId(patients.getPatientId())
              .setPatientNameEnglish(patients.getPatientNameEnglish())
              .setPatientNameMarathi(patients.getPatientNameMarathi())
              .setGender(patients.getGender())
              .setMobileNumber(patients.getMobileNumber())
              .setAdress(patients.getAdress())
              .setBirthDate(patients.getBirthDate())
              .setPatientStatus(patients.getPatientStatus())
              .setFirstExaminationDate(patients.getFirstExaminationDate());
      response.setData( patientsData);
    }
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  public ResponseEntity<PatientResponse> updatePatiet(PatientRequest request) {

    Optional<Patients> pat = repo.findByPatientId(request.getPatientId());

    if (pat.isPresent()) {
      Patients updatedPatient = pat.get();

      if (request.getAdress() != null) {
        updatedPatient.setAdress(request.getAdress());
      }

      if (request.getPatientNameEnglish() != null) {
        updatedPatient.setPatientNameEnglish(request.getPatientNameEnglish());
      }
      if (request.getFirstExaminationDate() != null) {
        updatedPatient.setFirstExaminationDate(request.getFirstExaminationDate());
      }
      if (request.getGender() != null) {
        updatedPatient.setGender(request.getGender());
      }

      if (request.getMobileNumber() != null) {
        updatedPatient.setMobileNumber(request.getMobileNumber());
      }

      if (request.getPatientNameMarathi() != null) {
        updatedPatient.setPatientNameMarathi(request.getPatientNameMarathi());
      }

      PatientData patientsData =
          PatientData.getInstance()
              .setPatientId(updatedPatient.getPatientId())
              .setPatientNameEnglish(updatedPatient.getPatientNameEnglish())
              .setPatientNameMarathi(updatedPatient.getPatientNameMarathi())
              .setGender(updatedPatient.getGender())
              .setMobileNumber(updatedPatient.getMobileNumber())
              .setAdress(updatedPatient.getAdress())
              .setBirthDate(updatedPatient.getBirthDate())
              .setPatientStatus(updatedPatient.getPatientStatus())
              .setFirstExaminationDate(updatedPatient.getFirstExaminationDate());
      repo.save(updatedPatient);
      response.setResponseCode(HttpStatus.CREATED.value());
      response.setResponseMsg("Patient Updated Successfully");
      response.setData( patientsData);

      return ResponseEntity.status(HttpStatus.CREATED).body(response);

    } else {
      response = new PatientResponse();
      response.setResponseCode(HttpStatus.NOT_FOUND.value());
      response.setResponseMsg("Patient with the provided ID not found");
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
  }

  public PatientResponse deletePatient(Long patientId) {
    Optional<Patients> pat = repo.findById(patientId);

    response = new PatientResponse();

    if (pat.isPresent()) {
      Patients deletedPatient = pat.get();
      deletedPatient.setPatientStatus("Inactive");
      repo.save(deletedPatient);

      response.setResponseCode(HttpStatus.OK.value());
      response.setResponseMsg("Payient saved as Inactive");
    } else {
      response.setResponseCode(HttpStatus.NOT_FOUND.value());
      
      response.setResponseMsg("Patient not found");
    }
    return response;
  }

  public ResponseEntity<List<PatientResponse>> getAllPateins() {
    List<Patients> patients = repo.findAll();
    List<PatientResponse> patientList = new ArrayList<>();
    for (Patients patient : patients) {
      response = new PatientResponse();
      response.setResponseCode(HttpStatus.FOUND.value());
      response.setResponseMsg("Patient data found");
      PatientData patientsData =
          PatientData.getInstance()
              .setPatientId(patient.getPatientId())
              .setPatientNameEnglish(patient.getPatientNameEnglish())
              .setPatientNameMarathi(patient.getPatientNameMarathi())
              .setGender(patient.getGender())
              .setMobileNumber(patient.getMobileNumber())
              .setAdress(patient.getAdress())
              .setBirthDate(patient.getBirthDate())
              .setPatientStatus(patient.getPatientStatus())
              .setFirstExaminationDate(patient.getFirstExaminationDate());
      patientList.add(response);
      response.setData( patientsData);
    }
    return ResponseEntity.status(HttpStatus.OK).body(patientList);
  }

  public ResponseEntity<PatientResponse> getPateintsById(Long patientId) {
    Optional<Patients> patient = repo.findById(patientId);

    if (patient.isPresent()) {
      Patients patients = patient.get();
      PatientData patientsData =
          PatientData.getInstance()
              .setPatientId(patients.getPatientId())
              .setPatientNameEnglish(patients.getPatientNameEnglish())
              .setPatientNameMarathi(patients.getPatientNameMarathi())
              .setGender(patients.getGender())
              .setMobileNumber(patients.getMobileNumber())
              .setAdress(patients.getAdress())
              .setBirthDate(patients.getBirthDate())
              .setPatientStatus(patients.getPatientStatus())
              .setFirstExaminationDate(patients.getFirstExaminationDate());
      response = new PatientResponse();
      response.setData( patientsData);
      response.setResponseMsg("patient found");
      response.setResponseCode(HttpStatus.FOUND.value());
      
      return ResponseEntity.status(HttpStatus.OK).body(response);

    } else {
      response = new PatientResponse();
      response.setResponseCode(HttpStatus.NOT_FOUND.value());
      response.setResponseMsg("Patient not found  with this Id");

      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
  }

  public ResponseEntity<PatientResponse> getPatientByPatientName(String patientName) {
    List<Patients> patients = repo.findByPatientNameEnglishContainingIgnoreCase(patientName);
    List<PatientData> patientList = new ArrayList<>();

    for (Patients patient : patients) {
      PatientData patientsData =
          PatientData.getInstance()
              .setPatientId(patient.getPatientId())
              .setPatientNameEnglish(patient.getPatientNameEnglish())
              .setPatientNameMarathi(patient.getPatientNameMarathi())
              .setGender(patient.getGender())
              .setMobileNumber(patient.getMobileNumber())
              .setAdress(patient.getAdress())
              .setBirthDate(patient.getBirthDate())
              .setPatientStatus(patient.getPatientStatus())
              .setFirstExaminationDate(patient.getFirstExaminationDate());
      patientList.add(patientsData);
    }
    if (patientList.isEmpty()) {
      response = new PatientResponse();
      response.setResponseCode(HttpStatus.NOT_FOUND.value());
      response.setResponseMsg("Patient not found");

      return ResponseEntity.status(HttpStatus.OK).body(response);
    } else {
      response = new PatientResponse();
    //  response.setData(patientList);
      response.setResponseCode(HttpStatus.FOUND.value());
      ;
      response.setResponseMsg("Patient found");
      return ResponseEntity.status(HttpStatus.OK).body(response);
    }
  }
}
