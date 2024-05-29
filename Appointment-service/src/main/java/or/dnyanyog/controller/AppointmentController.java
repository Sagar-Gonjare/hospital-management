package or.dnyanyog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import or.dnyanyog.dto.request.AppointmentRequest;
import or.dnyanyog.dto.response.AppointmentResponse;
import or.dnyanyog.repository.AppointmentRepo;
import or.dnyanyog.service.AppointmentServiceImpl;

@RestController
public class AppointmentController {
	
	@Autowired AppointmentResponse response;
	@Autowired AppointmentServiceImpl service;
	@Autowired AppointmentRepo repo;

	@PostMapping ( path = "api/appointments/v1/addAppointment",
      consumes = {"application/json", "application/xml"},
      produces = {"application/json", "application/xml"})
	public ResponseEntity<AppointmentResponse>addAppointment(@RequestBody AppointmentRequest request){
		return service.addAppointments(request);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
