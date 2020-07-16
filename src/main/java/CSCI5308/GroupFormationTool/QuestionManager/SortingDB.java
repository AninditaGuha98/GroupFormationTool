package CSCI5308.GroupFormationTool.QuestionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;

public class SortingDB implements IQuestionSorters {
	IQuestionsPersistence interfaceQuestionDB = QManagerDbFactory.FactorySingleton().createQuestionDB();

	public List<InterfaceQuestionModel> sort(String bannerID, InterfaceSorters interfaceSorters) {
		List<InterfaceQuestionModel> questions = new ArrayList<>();
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spGetSortedQuestions(?,?,?)");
			proc.setParameter(1, bannerID);
			proc.setParameter(2, interfaceSorters.getSortField());
			proc.setParameter(3, interfaceSorters.getSortOrder());
			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {
					String title = results.getString(1);
					InterfaceQuestionModel interfaceQuestionModel = QManagerModelFactory.FactorySingleton()
							.createQuestionModel();
					interfaceQuestionModel.setQuestionTitle(title);
					questions.add(interfaceQuestionModel);
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

	public List<InterfaceQuestionModel> clearSort(String bannerID) {
		return interfaceQuestionDB.loadAllQuestionsByID(bannerID);
	}
}
