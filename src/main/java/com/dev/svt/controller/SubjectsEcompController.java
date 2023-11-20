package com.dev.svt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dev.svt.dto.DtoEcomp;
import com.dev.svt.service.SubjectsEcompService;

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
