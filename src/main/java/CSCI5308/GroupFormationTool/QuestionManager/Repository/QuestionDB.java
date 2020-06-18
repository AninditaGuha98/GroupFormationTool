package CSCI5308.GroupFormationTool.QuestionManager.Repository;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;
import CSCI5308.GroupFormationTool.QuestionManager.Interface.IQuestionsPersistence;
import CSCI5308.GroupFormationTool.QuestionManager.Model.Question;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import CSCI5308.GroupFormationTool.QuestionManager.Model.QuestionModel;
import CSCI5308.GroupFormationTool.QuestionManager.Model.Responses;
import java.util.List;

public class QuestionDB implements IQuestionsPersistence {
	private Long lastInsertedQuestion;

	public List<Question> loadAllQuestionsByID(String bannerID) {
		List<Question> questions = new ArrayList<Question>();
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spGetAllQuestions(?)");
			proc.setParameter(1, bannerID);
			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {
					String title = results.getString(1);
					Question q = new Question();
					q.setQuestionTitle(title);
					questions.add(q);
				}
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return questions;
	}

	public boolean createQuestion(QuestionModel questionModel) {
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spInsertQuestion(?, ?,?,?,?)");
			proc.setParameter(1, questionModel.getUserID());
			proc.setParameter(2, questionModel.getQuestionTitle());
			proc.setParameter(3, questionModel.getQuestionText());
			proc.setParameter(4, questionModel.getTypeSelect());
			proc.registerOutputParameterLong(5);
			proc.execute();
			lastInsertedQuestion = proc.getStatement().getLong(5);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return true;
	}

	public boolean insertResponses(Responses response) {
		CallStoredProcedure proc = null;
		String[] response_text = response.getResponse_txt().split(",");
		String[] score_text = response.getScore_txt().split(",");
		try {
			for (int i = 0; i < response_text.length; i++) {
				proc = new CallStoredProcedure("spInsertResponse(?, ?,?)");
				proc.setParameter(1, lastInsertedQuestion);
				proc.setParameter(2, response_text[i]);
				proc.setParameter(3, score_text[i]);
				proc.execute();
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return true;

	}
}
