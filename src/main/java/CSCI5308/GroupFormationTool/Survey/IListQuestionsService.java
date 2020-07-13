package CSCI5308.GroupFormationTool.Survey;

import java.util.Dictionary;
import java.util.HashMap;

public interface IListQuestionsService {
    Dictionary listAllQuestionsforUser(long userID);
    public Dictionary listRepeatQuestions();
}
