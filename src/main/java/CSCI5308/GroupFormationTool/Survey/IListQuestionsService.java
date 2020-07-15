package CSCI5308.GroupFormationTool.Survey;

import java.util.Dictionary;

public interface IListQuestionsService {
    Dictionary listAllQuestionsforUser(long userID);
    Dictionary listRepeatQuestions();
}
