package com.cdeledu.datahub.metadata.mybatis;

import java.io.Serializable;
import java.util.List;

public class Question implements Serializable {

	private int questionID;
	private String content;
	private List<Option> option;
	private Video video;

	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<Option> getOption() {
		return option;
	}
	public void setOption(List<Option> option) {
		this.option = option;
	}
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}

	@Override
	public String toString() {
		return "Question [questionID=" + questionID + ", content=" + content
				+ ", option=" + option + ", video=" + video + "]";
	}

}
