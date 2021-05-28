package com.robinfood.survey.api.model;

public class QuestionOptions {

	private String question;
	private boolean optionA;
	private boolean optionB;
	private boolean optionC;
	private boolean optionD;

	public QuestionOptions() {

	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public boolean isOptionA() {
		return optionA;
	}

	public void setOptionA(boolean optionA) {
		this.optionA = optionA;
	}

	public boolean isOptionB() {
		return optionB;
	}

	public void setOptionB(boolean optionB) {
		this.optionB = optionB;
	}

	public boolean isOptionC() {
		return optionC;
	}

	public void setOptionC(boolean optionC) {
		this.optionC = optionC;
	}

	public boolean isOptionD() {
		return optionD;
	}

	public void setOptionD(boolean optionD) {
		this.optionD = optionD;
	}

}
