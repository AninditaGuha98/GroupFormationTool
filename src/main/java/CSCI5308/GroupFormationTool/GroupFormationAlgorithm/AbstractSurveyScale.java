package CSCI5308.GroupFormationTool.GroupFormationAlgorithm;

import CSCI5308.GroupFormationTool.MyGroupFormation.ISurveyResponse;

public abstract class AbstractSurveyScale {
	private String questiontext;
	private String questiontype;
	private String criteria;
	private String threshold;
	
	public String getQuestiontext() {
		return questiontext;
	}
	public void setQuestiontext(String questiontext) {
		this.questiontext = questiontext;
	}
	public String getQuestiontype() {
		return questiontype;
	}
	public void setQuestiontype(String questiontype) {
		this.questiontype = questiontype;
	}
	public String getCriteria() {
		return criteria;
	}
	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}
	public String getThreshold() {
		return threshold;
	}
	public void setThreshold(String threshold) {
		this.threshold = threshold;
	}
	
	abstract public double distance(ISurveyResponse rp1, ISurveyResponse rp2, int index);
}
