package com.cdeledu.datahub.metadata.mybatis;

public class Video {

	private String videoID;
	private String cwID;

	public String getVideoID() {
		return videoID;
	}
	public void setVideoID(String videoID) {
		this.videoID = videoID;
	}
	public String getCwID() {
		return cwID;
	}
	public void setCwID(String cwID) {
		this.cwID = cwID;
	}

	@Override
	public String toString() {
		return "Video [videoID=" + videoID + ", cwID=" + cwID + "]";
	}

}
