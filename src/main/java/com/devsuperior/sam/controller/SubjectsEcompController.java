package com.devsuperior.sam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.devsuperior.sam.dto.DtoEcomp;
import com.devsuperior.sam.service.SubjectsEcompService;

import java.util.List;

@RestController
@RequestMapping("/api/subjects_ecomp")
public class SubjectsEcompController {
	
	
	private final SubjectsEcompService subjectService;

    @Autowired
    public SubjectsEcompController(SubjectsEcompService subjectService) {
        this.subjectService = subjectService;
    }
    
	@GetMapping
	public ResponseEntity<String> verify_route() {
	    return ResponseEntity.ok("Teste de R@ta");
	}

    @PostMapping
    @RequestMapping("/addSubjects")
    public ResponseEntity<String> addSubjects(@RequestBody List<DtoEcomp> subjects) {
    	String addedSubjects = subjectService.addAllSubjects(subjects);
        return ResponseEntity.ok(addedSubjects);
    }
    
    @GetMapping
    @RequestMapping("/getSubjects")
    public ResponseEntity<List<DtoEcomp>> getAllSubjects() {
        List<DtoEcomp> dtos = subjectService.getAllSubjects();
        return ResponseEntity.ok(dtos);
    }
    
}