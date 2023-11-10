package com.devsuperior.sam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.sam.entity.SubjectsEcompEntity;

@Repository
public interface SubjectsEcompRepository extends JpaRepository<SubjectsEcompEntity, Long> {
	
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO SAM_ECOMPSUBJECTS (CURRICULARUNIT, WORKLOAD, CREDIT) VALUES (:curricularUnit, :workload, :credit)", nativeQuery = true)
	int insertSubject(@Param("curricularUnit") String curricularUnit,
	                  @Param("workload") Integer workload,
	                  @Param("credit") Integer credit);

	@Transactional
	@Modifying
	@Query(value = "INSERT INTO SUBJECT_PREREQUISITES (IDSUBJECTS, PREREQUISITE) VALUES (:id, :prerequisite)", nativeQuery = true)
	int insertPrerequisite(@Param("id") Long id,
	                       @Param("prerequisite") String prerequisite);

	@Transactional
	@Modifying
	@Query(value = "INSERT INTO SUBJECT_POSITIONS (IDSUBJECTS, POSITION) VALUES (:id, :position)", nativeQuery = true)
	int insertPosition(@Param("id") Long id,
	                   @Param("position") Integer position);

	@Query(value = "SELECT IDSUBJECTS FROM SAM_ECOMPSUBJECTS WHERE CURRICULARUNIT = :curricularUnit", nativeQuery = true)
	Long findSubjectIdsByCurricularUnit(@Param("curricularUnit") String curricularUnit);
	
	@Query("SELECT s FROM SubjectsEcompEntity s")
	List<SubjectsEcompEntity> findAllSubjects();

	@Query("SELECT p FROM SubjectsEcompEntity s JOIN s.preRequisites p WHERE s.subjectId = :subjectId")
	List<String> findPrerequisitesBySubjectId(@Param("subjectId") Long subjectId);

	@Query("SELECT p FROM SubjectsEcompEntity s JOIN s.position p WHERE s.subjectId = :subjectId")
	List<Integer> findPositionsBySubjectId(@Param("subjectId") Long subjectId);


}