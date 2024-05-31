package org.dnyanyog.controller;

import java.util.List;

import org.dnyanyog.dto.request.CaseRequest;
import org.dnyanyog.dto.response.CaseResponse;
import org.dnyanyog.repository.CaseRepo;
import org.dnyanyog.service.CaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CaseController {
	
	 @Autowired CaseServiceImpl service;
	  @Autowired CaseResponse response;
	  @Autowired CaseRepo repo;

	  @PostMapping(
	      path = "api/cases/v1/addCase",
	      consumes = {"application/json", "application/xml"},
	      produces = {"application/json", "application/xml"})
	  public ResponseEntity<CaseResponse> addCase(@RequestBody CaseRequest request) throws Exception {
	    return service.addCase(request);
	  }

	  @PostMapping(
	      path = "api/cases/v1/updateCase",
	      consumes = {"application/json", "application/xml"},
	      produces = {"application/json", "application/xml"})
	  public ResponseEntity<CaseResponse> updatePatient(@RequestBody CaseRequest request) throws Exception {
	    return service.updateCase(request);
	  }

	  @GetMapping(path = "api/cases/v1/getAllCase")
	  public ResponseEntity<List<CaseResponse>> getAllPatients() {

	    return service.getAllCases();
	  }

	  

	  @GetMapping(path = "api/cases/v1/getcaseIdById/{caseId}")
	  public ResponseEntity<CaseResponse> getPatientByName(@RequestParam Long caseId) {
	    return service.getCaseByCaseID(caseId);
	  }

	  @DeleteMapping(path = "api/cases/v1/deleteCase/{caseId}")
	  public ResponseEntity<CaseResponse> deletePatient(@PathVariable Long caseId) {
		  CaseResponse caseResponse = service.deleteCase(caseId);
	    return ResponseEntity.status(caseResponse.getResponseCode()).body(caseResponse);
	  }
}
