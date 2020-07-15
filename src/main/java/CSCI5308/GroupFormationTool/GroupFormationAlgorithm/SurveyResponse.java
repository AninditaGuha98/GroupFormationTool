package CSCI5308.GroupFormationTool.GroupFormationAlgorithm;

import java.util.HashMap;

public class SurveyResponse implements ISurveyResponse{
	String bannerID;
	String firstName;
	String lastName;
	HashMap<String, String> questionResponses = new HashMap<String, String>();

	public String getBannerID() {
		return bannerID;
	}

	public void setBannerID(String bannerID) {
		this.bannerID = bannerID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public HashMap<String, String> getQuestionResponses() {
		return questionResponses;
	}

	public void setQuestionResponses(HashMap<String, String> questionResponses) {
		this.questionResponses = questionResponses;
	}

}
