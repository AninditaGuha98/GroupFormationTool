package CSCI5308.GroupFormationTool.GroupFormationAlgorithm;

import java.util.HashMap;

public interface ISurveyResponse {

	public String getBannerID() ;

	public void setBannerID(String bannerID) ;

	public String getFirstName() ;

	public void setFirstName(String firstName) ;

	public String getLastName() ;

	public void setLastName(String lastName) ;

	public HashMap<String, String> getQuestionResponses() ;

	public void setQuestionResponses(HashMap<String, String> questionResponses) ;
	
}
