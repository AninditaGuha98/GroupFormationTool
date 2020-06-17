package CSCI5308.GroupFormationTool.QuestionManager.Repository;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;
import CSCI5308.GroupFormationTool.QuestionManager.Interface.IQuestionSorters;
import CSCI5308.GroupFormationTool.QuestionManager.Interface.IQuestionsPersistence;
import CSCI5308.GroupFormationTool.QuestionManager.Model.Question;
import CSCI5308.GroupFormationTool.QuestionManager.Model.Sorters;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SortingDB implements IQuestionSorters {
    IQuestionsPersistence questionDb = new QuestionDB();

    public List<Question> sort(String bannerID, Sorters sorters) {
        List<Question> questions = new ArrayList<Question>();
        CallStoredProcedure proc = null;
        try {
            proc = new CallStoredProcedure("spGetSortedQuestions(?,?,?)");
            proc.setParameter(1, bannerID);
            proc.setParameter(2, sorters.getSortField());
            proc.setParameter(3, sorters.getSortOrder());
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

    public List<Question> clearSort(String bannerID) {
        return questionDb.loadAllQuestionsByID(bannerID);
    }
}

