package CSCI5308.GroupFormationTool.QuestionManager.Repository;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;
import CSCI5308.GroupFormationTool.QuestionManager.Interface.IQuestionsPersistence;
import CSCI5308.GroupFormationTool.QuestionManager.Model.Question;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDB implements IQuestionsPersistence {

    public List<Question> loadAllQuestionsByID(String bannerID) {
        List<Question> questions = new ArrayList<Question>();
        CallStoredProcedure proc = null;
        try {
            proc = new CallStoredProcedure("spGetAllQuestions(?)");
            proc.setParameter(1, bannerID);
            ResultSet results = proc.executeWithResults();
            if (null != results)
            {
                while (results.next())
                {
                    String title = results.getString(1);
                    Question q = new Question();
                    q.setQuestionTitle(title);
                    questions.add(q);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally
        {
            if (null != proc)
            {
                proc.cleanup();
            }
        }
        return questions;
    }
}
