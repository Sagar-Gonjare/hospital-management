package or.dnyanyog.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import or.dnyanyog.entity.Patients;

@Component
@Repository
public interface PatientRepo extends JpaRepository<Patients, Long> {
  Optional<Patients> findByPatientId(long patientId);

  boolean existsByMobileNumber(String patientMobile);
  List<Patients> findByPatientNameEnglishContainingIgnoreCase(String patientNameEnglish);

  
}
