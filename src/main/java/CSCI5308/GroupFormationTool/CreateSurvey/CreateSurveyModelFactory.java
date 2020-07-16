package CSCI5308.GroupFormationTool.CreateSurvey;

public class CreateSurveyModelFactory implements ICreateSurveyModelFactory{

    private static ICreateSurveyModelFactory iCreateSurveyModelFactory=null;
    private ICreateSurveyQuestionsModel createSurveyQuestionsModel;

    public static ICreateSurveyModelFactory FactorySingleton(){
        if( iCreateSurveyModelFactory == null){
            iCreateSurveyModelFactory=new CreateSurveyModelFactory();
        }
        return iCreateSurveyModelFactory;
    }

    @Override
    public ICreateSurveyQuestionsModel createSurveyQuestionsModel(){

        if(null == createSurveyQuestionsModel ){
            createSurveyQuestionsModel=new CreateSurveyQuestionsModel();
        }
        return createSurveyQuestionsModel;
    }
}
