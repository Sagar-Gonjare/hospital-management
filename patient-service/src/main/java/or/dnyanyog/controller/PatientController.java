package or.dnyanyog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import or.dnyanyog.dto.request.PatientRequest;
import or.dnyanyog.dto.response.PatientResponse;
import or.dnyanyog.repository.PatientRepo;
import or.dnyanyog.service.PatientServiceImpl;

@RestController
public class PatientController {
  @Autowired PatientServiceImpl service;
  @Autowired PatientResponse response;
  @Autowired PatientRepo repo;

  @PostMapping(
      path = "api/patients/v1/addPatient",
      consumes = {"application/json", "application/xml"},
      produces = {"application/json", "application/xml"})
  public ResponseEntity<PatientResponse> addPatient(@RequestBody PatientRequest request) {
    return service.addPatient(request);
  }

  @PostMapping(
      path = "api/patients/v1/updatePatient",
      consumes = {"application/json", "application/xml"},
      produces = {"application/json", "application/xml"})
  public ResponseEntity<PatientResponse> updatePatient(@RequestBody PatientRequest request) {
    return service.updatePatiet(request);
  }

  @GetMapping(path = "api/patients/v1/getAllPatient")
  public ResponseEntity<List<PatientResponse>> getAllPatients() {

    return service.getAllPateins();
  }

  @GetMapping(path = "api/patients/v1/getPatientByName/{patientName}")
  public ResponseEntity<PatientResponse> getPatientByName(@PathVariable String pateintName) {
    return service.getPatientByPatientName(pateintName);
  }

  @GetMapping(path = "api/patients/v1/getPatientById/{patientId}")
  public ResponseEntity<PatientResponse> getPatientByName(@RequestParam Long pateintId) {
    return service.getPateintsById(pateintId);
  }

  @DeleteMapping(path = "api/patients/v1/deletePatient/{patientId}")
  public ResponseEntity<PatientResponse> deletePatient(@PathVariable Long patientId) {
    PatientResponse patientResponse = service.deletePatient(patientId);
    return ResponseEntity.status(patientResponse.getResponseCode()).body(patientResponse);
  }
}
