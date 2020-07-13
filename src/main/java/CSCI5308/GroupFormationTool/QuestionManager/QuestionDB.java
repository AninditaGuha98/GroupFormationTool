package CSCI5308.GroupFormationTool.QuestionManager;


import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;
import CSCI5308.GroupFormationTool.QuestionManager.IQuestionsPersistence;
import CSCI5308.GroupFormationTool.QuestionManager.InterfaceQuestionModel;
import CSCI5308.GroupFormationTool.QuestionManager.InterfaceResponses;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class QuestionDB implements IQuestionsPersistence {
    private Long lastInsertedQuestion;
    IQManagerModelFactory questionFactory = QManagerModelFactory.FactorySingleton();

    public List<InterfaceQuestionModel> loadAllQuestionsByID(String bannerID) {
        List<InterfaceQuestionModel> questions = new ArrayList<>();
        CallStoredProcedure proc = null;
        try {
            proc = new CallStoredProcedure("spGetAllQuestions(?)");
            proc.setParameter(1, bannerID);
            ResultSet results = proc.executeWithResults();
            if (null != results) {
                while (results.next()) {
                    String title = results.getString(1);
                    InterfaceQuestionModel interfaceQuestionModel = questionFactory.createQuestionModel();
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

    public boolean createQuestion(InterfaceQuestionModel interfaceQuestionModel) {
        CallStoredProcedure proc = null;
        try {
            proc = new CallStoredProcedure("spInsertQuestion(?, ?,?,?,?)");
            proc.setParameter(1, interfaceQuestionModel.getUserID());
            proc.setParameter(2, interfaceQuestionModel.getQuestionTitle());
            proc.setParameter(3, interfaceQuestionModel.getQuestionText());
            proc.setParameter(4, interfaceQuestionModel.getTypeSelect());
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

    public boolean insertResponses(InterfaceResponses response) {
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

    public boolean deleteQuestionsFromDB(long userId, String[] selectedQuestions) {
        CallStoredProcedure procedure = null;
        CallStoredProcedure procedure1 = null;
        try {

            for (int i = 0; i < selectedQuestions.length; i++) {
                procedure1 = new CallStoredProcedure("spDeleteFromResponse(?,?)");
                procedure1.setParameter(1, userId);
                procedure1.setParameter(2, selectedQuestions[i]);
                procedure1.execute();

                procedure = new CallStoredProcedure("spDeleteQuestions(?,?)");
                procedure.setParameter(1, userId);
                procedure.setParameter(2, selectedQuestions[i]);
                procedure.execute();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        } finally {
            if (null != procedure) {
                procedure.cleanup();
                procedure1.cleanup();
            }
            return true;
        }
    }

    public List<InterfaceQuestionModel> loadAllQuestionsBycourseID(String courseID) {
        List<InterfaceQuestionModel> questions = new ArrayList<>();
        CallStoredProcedure proc = null;
        try {
            proc = new CallStoredProcedure("spLoadCourseQuestions(?)");
            proc.setParameter(1, "3");
            ResultSet results = proc.executeWithResults();
            if (null != results) {
                while (results.next()) {
                	InterfaceQuestionModel interfaceQuestionModel = questionFactory.createQuestionModel();
                    interfaceQuestionModel.setQuestionText(results.getString(1));
                    interfaceQuestionModel.setTypeSelect(results.getString(2));
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

}
