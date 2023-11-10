package com.devsuperior.sam.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.sam.dto.DtoEcomp;
import com.devsuperior.sam.entity.SubjectsEcompEntity;
import com.devsuperior.sam.repository.SubjectsEcompRepository;

@Service
public class SubjectsEcompService {
	
	private SubjectsEcompRepository subjsRepository;
	
	@Autowired
    public SubjectsEcompService(SubjectsEcompRepository subjsRepository) {
        this.subjsRepository = subjsRepository;
    }
	
	@Transactional
	public String addAllSubjects(List<DtoEcomp> subjects) {
	    for (DtoEcomp dto : subjects) {
	        int aux = subjsRepository.insertSubject(dto.getCurricular_unit(), dto.getWorkload(), dto.getCredit());
	        Long subjectId = subjsRepository.findSubjectIdsByCurricularUnit(dto.getCurricular_unit());
	        
	        for (String prerequisite : dto.getPrerequisites()) {
	            subjsRepository.insertPrerequisite(subjectId, prerequisite);
	        }
	        for (Integer position : dto.getPosition()) {
	            subjsRepository.insertPosition( subjectId, position);
	        }
	    }
	    return "Subjects added successfully";
	}

	
	public List<DtoEcomp> getAllSubjects() {
        List<SubjectsEcompEntity> subjects = subjsRepository.findAllSubjects();
        List<DtoEcomp> dtos = new ArrayList<>();

        for (SubjectsEcompEntity subject : subjects) {
            List<String> prerequisites = subjsRepository.findPrerequisitesBySubjectId(subject.getSubjectId());
            List<Integer> positions = subjsRepository.findPositionsBySubjectId(subject.getSubjectId());

            DtoEcomp dto = new DtoEcomp();
            dto.setCurricular_unit(subject.getCurricularUnit());
            dto.setWorkload(subject.getWorkload());
            dto.setPrerequisites(prerequisites);
            dto.setPosition(positions);
            dto.setCredit(subject.getCredit());

            dtos.add(dto);
        }

        return dtos;
    }
	
}