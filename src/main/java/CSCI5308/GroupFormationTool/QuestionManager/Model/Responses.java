package CSCI5308.GroupFormationTool.QuestionManager.Model;

import CSCI5308.GroupFormationTool.QuestionManager.Interface.IQuestionsPersistence;

public class Responses {
	private String response_txt;
	private String score_txt;

	public String getResponse_txt() {
		return response_txt;
	}

	public void setResponse_txt(String response_txt) {
		this.response_txt = response_txt;
	}

	public String getScore_txt() {
		return score_txt;
	}

	public void setScore_txt(String score_txt) {
		this.score_txt = score_txt;
	}

	public boolean insertResponses(IQuestionsPersistence questionDB) {
		return questionDB.insertResponses(this);
	}

}
