package or.dnyanyog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import or.dnyanyog.dto.request.AppointmentRequest;
import or.dnyanyog.dto.response.AppointmentData;
import or.dnyanyog.dto.response.AppointmentResponse;
import or.dnyanyog.entity.Appointments;
import or.dnyanyog.repository.AppointmentRepo;

@Component
@Service
public class AppointmentServiceImpl implements AppointmentService {

  @Autowired AppointmentResponse response;

  @Autowired Appointments appointments;

  @Autowired AppointmentData data;

  @Autowired AppointmentRepo repo;

  public ResponseEntity<AppointmentResponse> addAppointments(AppointmentRequest request) {

    if (repo.findByExaminationDateAndPatientName(
        request.getExaminationDate(), request.getPatientName())!=null) {
      response = new AppointmentResponse();
      response.setResponseCode(HttpStatus.UNAUTHORIZED.value());
      response.setResponseMsg("Appointment Already exist");
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }
    if (!(request.getAppointmentTime().isEmpty()
        && request.getExaminationDate().isEmpty()
        && request.getPatientName().isEmpty()
        && request.getPatientId().isEmpty())) {
    	 Appointments appointments=
    			 Appointments.getInstance()
    			 .setAppointmentTime(request.getAppointmentTime())
    			 .setExaminationDate(request.getExaminationDate())
    			 .setPatientId(request.getPatientId())
    			 .setPatientName(request.getPatientName());
    	 appointments=repo.save(appointments);
    			 
    	 response.setResponseCode(HttpStatus.CREATED.value());
         response.setResponseMsg("Appointment added successfully");
          
         AppointmentData data = AppointmentData.getInstance()
        		 .setAppointmentId(appointments.getAppointmentId())
        		 .setAppointmentTime(appointments.getAppointmentTime())
    			 .setExaminationDate(appointments.getExaminationDate())
    			 .setPatientid(appointments.getPatientId())
    			 .setPatientName(appointments.getPatientName());
    	response.setData(data);
    }
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }
}
