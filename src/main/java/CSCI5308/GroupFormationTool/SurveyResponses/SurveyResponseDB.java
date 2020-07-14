package CSCI5308.GroupFormationTool.SurveyResponses;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;
import CSCI5308.GroupFormationTool.QuestionManager.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class SurveyResponseDB implements ISurveyResponseDB {
    IQManagerModelFactory modelFactory = QManagerModelFactory.FactorySingleton();
    List<Long> question_id = new ArrayList<>();

    @Override
    public HashMap<Integer, Integer> checkIfSurveyPublished(long courseID) {
        HashMap<Integer, Integer> surveyAvailable = new HashMap<>();
        CallStoredProcedure proc = null;
        try {
            proc = new CallStoredProcedure("spFindPublishedSurvey(?)");
            proc.setParameter(1, courseID);
            ResultSet results = proc.executeWithResults();
            if (null != results) {
                while (results.next()) {
                    surveyAvailable.put(results.getInt("surveyID"), results.getInt("published"));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (null != proc) {
                proc.cleanup();
            }
        }
        return surveyAvailable;
    }

    public List<InterfaceQuestionModel> getSurveyQuestions(long surveyID) {
        List<InterfaceQuestionModel> surveyQuestions = new ArrayList<>();
        CallStoredProcedure proc = null;
        try {
            proc = new CallStoredProcedure("spGetSurveyQuestions(?)");
            proc.setParameter(1, surveyID);
            ResultSet results = proc.executeWithResults();
            if (null != results) {
                while (results.next()) {
                    InterfaceQuestionModel interfaceQuestionModel = modelFactory.createQuestionModel();
                    long id = results.getLong("question_id");
                    String question_type = results.getString("question_type");
                    interfaceQuestionModel.setQuestionID(id);
                    interfaceQuestionModel.setQuestionText(results.getString("question_heading"));
                    interfaceQuestionModel.setQuestionType(question_type);
                    surveyQuestions.add(interfaceQuestionModel);
                    if (question_type.equals("mcq1") || question_type.equals("mcq2")) {
                        question_id.add(id);
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (null != proc) {
                proc.cleanup();
            }
        }
        return surveyQuestions;
    }

    public Map<Long, ArrayList<InterfaceResponses>> getSurveyResponses() {
        Map<Long, ArrayList<InterfaceResponses>> surveyResponse = new HashMap<>();
        CallStoredProcedure proc = null;
        if(question_id.size()>0) {
            try {
                for (int i = 0; i < question_id.size(); i++) {
                    ArrayList<InterfaceResponses> responses = new ArrayList<>();
                    proc = new CallStoredProcedure("spGetSurveyResponse(?)");
                    proc.setParameter(1, question_id.get(i));
                    ResultSet results = proc.executeWithResults();
                    if (null != results) {
                        while (results.next()) {
                            InterfaceResponses interfaceResponses = modelFactory.createResponses();
                            interfaceResponses.setResponse_txt(results.getString(1));
                            interfaceResponses.setScore_txt(Integer.toString(results.getInt(2)));
                            responses.add(interfaceResponses);
                        }
                        surveyResponse.put(question_id.get(i), responses);
                    }
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                if (null != proc) {
                    proc.cleanup();
                }
            }
        }
        return surveyResponse;
    }
}