package com.robinfood.survey.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.robinfood.survey.api.model.Survey;

@Repository
public interface SurveyRepository extends MongoRepository<Survey,String> {
	
}
