package com.cdeledu.datahub.metadata.mybatis;

import java.io.Serializable;

public class Option implements Serializable {

	private int questionID;
	private String quesOption;
	private String quesValue;

	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
	public String getQuesOption() {
		return quesOption;
	}
	public void setQuesOption(String quesOption) {
		this.quesOption = quesOption;
	}
	public String getQuesValue() {
		return quesValue;
	}
	public void setQuesValue(String quesValue) {
		this.quesValue = quesValue;
	}

	@Override
	public String toString() {
		return "Option [questionID=" + questionID + ", quesOption="
				+ quesOption + ", quesValue=" + quesValue + "]";
	}

}
