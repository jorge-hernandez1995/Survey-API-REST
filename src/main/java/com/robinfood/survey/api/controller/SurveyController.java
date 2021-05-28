package com.robinfood.survey.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.robinfood.survey.api.model.Survey;
import com.robinfood.survey.api.repository.SurveyRepository;

@RestController
public class SurveyController {
	
	@Autowired
	private SurveyRepository repository;
	
	//Save a Client's Survey
	@PostMapping("/addSurvey")
	public String saveSurvey(@RequestBody Survey survey) {
		repository.save(survey);
		return "Survey saved successfully. Id Generated: " + survey.getUserId();
	}
	
	//Find a Survey by UserId
	@GetMapping("/findSurvey/{id}")
	public Optional<Survey> getSurvey(@PathVariable String id){
		return repository.findById(id);
	}
	
	//List all Clients Surveys at MongoDB
	@GetMapping("/findAllSurveys")
	public List<Survey> getAllSurveys(){
		return repository.findAll(); 
	}

}
