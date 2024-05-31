package org.dnyanyog.repository;

import org.dnyanyog.entity.Cases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface CaseRepo extends JpaRepository <Cases,Long>{
	Optional<Cases> findByCaseId(Long caseId);
	Optional<Cases> findByCaseNo(String caseNo);

	Optional<Cases> findByPatientId(String patientId);
}
