package CSCI5308.GroupFormationTool.QuestionManager.Model;

public class DeleteQuestionsModel implements CSCI5308.GroupFormationTool.QuestionManager.Interface.InterfaceDeleteQuestionsModel {
	private String[] listQuestions;
	private String[] selectedQuestions;

	@Override
	public String[] getListQuestions() {
		return listQuestions;
	}

	@Override
	public void setListQuestions(String[] listQuestions) {
		this.listQuestions = listQuestions;
	}

	@Override
	public String[] getSelectedQuestions() {
		return selectedQuestions;
	}

	@Override
	public void setSelectedQuestions(String[] selectedQuestions) {
		this.selectedQuestions = selectedQuestions;
	}
}
