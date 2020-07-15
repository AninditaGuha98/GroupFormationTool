package CSCI5308.GroupFormationTool.GroupFormationAlgorithm;

import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

public class SurveyResponseTest {

	@Test
	public void getBannerID() {
		ISurveyResponse surveyResponseObj =SurveyScaleObjectFactory.createObject(new SurveyResponseObjectFactory());
		surveyResponseObj.setBannerID("B0012345");
		assertSame("B0012345",surveyResponseObj.getBannerID());
	}
	
	@Test
	public void setBannerID() {
		ISurveyResponse surveyResponseObj =SurveyScaleObjectFactory.createObject(new SurveyResponseObjectFactory());
		surveyResponseObj.setBannerID("B0012345");
		assertSame("B0012345",surveyResponseObj.getBannerID());
	}
	
	@Test
	public void getFirstName() {
		ISurveyResponse surveyResponseObj =SurveyScaleObjectFactory.createObject(new SurveyResponseObjectFactory());
		surveyResponseObj.setFirstName("Test");
		assertSame("Test",surveyResponseObj.getFirstName());
	}
	
	@Test
	public void setFirstName() {
		ISurveyResponse surveyResponseObj =SurveyScaleObjectFactory.createObject(new SurveyResponseObjectFactory());
		surveyResponseObj.setFirstName("Test");
		assertSame("Test",surveyResponseObj.getFirstName());
	}
	
	@Test
	public void getLastName() {
		ISurveyResponse surveyResponseObj =SurveyScaleObjectFactory.createObject(new SurveyResponseObjectFactory());
		surveyResponseObj.setLastName("Test");
		assertSame("Test",surveyResponseObj.getLastName());
	}
	
	@Test
	public void setLastName() {
		ISurveyResponse surveyResponseObj =SurveyScaleObjectFactory.createObject(new SurveyResponseObjectFactory());
		surveyResponseObj.setLastName("Test");
		assertSame("Test",surveyResponseObj.getLastName());
	}
	
}
