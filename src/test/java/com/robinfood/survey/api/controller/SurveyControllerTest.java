package com.robinfood.survey.api.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.robinfood.survey.api.model.QuestionOptions;
import com.robinfood.survey.api.model.Questions;
import com.robinfood.survey.api.model.Survey;
import com.robinfood.survey.api.repository.SurveyRepository;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import org.mockito.Mockito;
import org.junit.Ignore;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = SurveyController.class)
@Import(SurveyController.class)
class SurveyControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private SurveyRepository surveyRepository;

	Survey survey = new Survey();

	@Test
	public void saveSurvey() throws Exception {
		
		Questions questions = new Questions();
		QuestionOptions questionOptions = new QuestionOptions();
		questionOptions.setQuestion("Test question");
		questionOptions.setOptionA(false);
		questionOptions.setOptionB(false);
		questionOptions.setOptionC(false);
		questionOptions.setOptionD(false);
		questions.setQuestionOptions(questionOptions);
		ArrayList<Questions> questionsList = new ArrayList<Questions>();
		questionsList.add(questions);
		survey.setQuestions(questionsList);

		Mockito.when(surveyRepository.save(Mockito.any(Survey.class))).thenReturn(survey);

		mockMvc.perform(post("/addSurvey").content(asJsonString(survey))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andDo(print());

	}

	@Test
	public void getSurvey() throws Exception {
		given(surveyRepository.findById("1")).willReturn(Optional.of(survey));
		mockMvc.perform(get("/findSurvey/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$").exists()).andDo(print());
	}

	@Test
	public void getAllSurveys() throws Exception {
		given(surveyRepository.findAll()).willReturn(List.of(survey));
		mockMvc.perform(get("/findAllSurveys").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$").exists()).andDo(print());

	}
	@Ignore
	public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
