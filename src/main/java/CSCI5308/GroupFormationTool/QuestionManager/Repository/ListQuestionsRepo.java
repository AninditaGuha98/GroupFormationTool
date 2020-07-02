package CSCI5308.GroupFormationTool.QuestionManager.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;
import CSCI5308.GroupFormationTool.QuestionManager.Interface.InterfaceDeleteQuestionsModel;
import CSCI5308.GroupFormationTool.QuestionManager.Interface.InterfaceListQuestionsRepo;
import CSCI5308.GroupFormationTool.QuestionManager.Model.DeleteQuestionsModel;

public class ListQuestionsRepo implements InterfaceListQuestionsRepo {

    @Override
    public InterfaceDeleteQuestionsModel listQuestionsFromDB(long userId) {
        ArrayList<String> questionText = new ArrayList<>();

        CallStoredProcedure procedure = null;
        try {
            procedure = new CallStoredProcedure("spListQuestions(?)");
            procedure.setParameter(1, userId);
            ResultSet results = procedure.executeWithResults();
            if (null != results) {
                while (results.next()) {
                    questionText.add(results.getString(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (null != procedure) {
                procedure.cleanup();
            }
        }
        String[] array = questionText.toArray(new String[0]);
        InterfaceDeleteQuestionsModel interfaceDeleteQuestionsModel = new DeleteQuestionsModel();
        interfaceDeleteQuestionsModel.setListQuestions(array);
        return interfaceDeleteQuestionsModel;
    }
}
