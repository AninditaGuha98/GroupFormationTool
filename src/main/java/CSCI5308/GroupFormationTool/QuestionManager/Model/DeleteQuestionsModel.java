package CSCI5308.GroupFormationTool.QuestionManager.Model;

public class DeleteQuestionsModel {
	private String[] listQuestions;
	private String[] selectedQuestions;

	public String[] getListQuestions() {
		return listQuestions;
	}

	public void setListQuestions(String[] listQuestions) {
		this.listQuestions = listQuestions;
	}

	public String[] getSelectedQuestions() {
		return selectedQuestions;
	}

	public void setSelectedQuestions(String[] selectedQuestions) {
		this.selectedQuestions = selectedQuestions;
	}
}
