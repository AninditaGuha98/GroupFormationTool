package CSCI5308.GroupFormationTool.GroupFormationAlgorithmTest;

import CSCI5308.GroupFormationTool.GroupFormationAlgorithm.SurveyScaleMCQ1;

public class SurveyScaleMock1 extends SurveyScaleMCQ1 {
	public SurveyScaleMock1() {
		super();
		setQuestionid("1");
		setQuestiontext("Are you living in Canada?");
		setQuestiontype("mcq1");
		setCriteria("similar,Grtx");
		setOptionscount("2");
	}
}
