package CSCI5308.GroupFormationTool.GroupFormationAlgorithm;

public class SurveyScale implements ISurveyScale {
	private String questiontext;
	private String questiontype;
	private String criteria;
	private String threshold;
	private String optionscount;
	private String questionid;

	public String getOptionscount() {
		return optionscount;
	}

	public void setOptionscount(String optionscount) {
		this.optionscount = optionscount;
	}

	public String getQuestionid() {
		return questionid;
	}

	public void setQuestionid(String questionid) {
		this.questionid = questionid;
	}

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
	
	public double distance(ISurveyResponse rp1, ISurveyResponse rp2, int index) {
		return 0;
	}

}