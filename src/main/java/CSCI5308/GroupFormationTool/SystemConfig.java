package CSCI5308.GroupFormationTool;

import CSCI5308.GroupFormationTool.AccessControl.IUserPersistence;
import CSCI5308.GroupFormationTool.AccessControl.UserDB;
import CSCI5308.GroupFormationTool.Courses.ICoursePersistence;
import CSCI5308.GroupFormationTool.Courses.CourseDB;
import CSCI5308.GroupFormationTool.Courses.ICourseUserRelationshipPersistence;
import CSCI5308.GroupFormationTool.Courses.CourseUserRelationshipDB;
import CSCI5308.GroupFormationTool.Database.DefaultDatabaseConfiguration;
import CSCI5308.GroupFormationTool.Database.IDatabaseConfiguration;
import CSCI5308.GroupFormationTool.QuestionManager.IQuestionSorters;
import CSCI5308.GroupFormationTool.QuestionManager.IQuestionsPersistence;
import CSCI5308.GroupFormationTool.QuestionManager.InterfaceDeleteQuestionsRepo;
import CSCI5308.GroupFormationTool.QuestionManager.InterfaceListQuestionsRepo;
import CSCI5308.GroupFormationTool.QuestionManager.DeleteQuestionsRepo;
import CSCI5308.GroupFormationTool.QuestionManager.ListQuestionsRepo;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionDB;
import CSCI5308.GroupFormationTool.QuestionManager.SortingDB;
import CSCI5308.GroupFormationTool.Security.DefaultSecurityFactory;
import CSCI5308.GroupFormationTool.Security.ISecurityFactory;
import CSCI5308.GroupFormationTool.PasswordValidationPolicy.IPasswordValidationFactory;
import CSCI5308.GroupFormationTool.PasswordValidationPolicy.DefaultPasswordValidationFactory;


public class SystemConfig {
	private static SystemConfig uniqueInstance = null;
	private IUserPersistence userDB;
	private IDatabaseConfiguration databaseConfiguration;
	private ICoursePersistence courseDB;
	private ICourseUserRelationshipPersistence courseUserRelationshipDB;
	private IQuestionsPersistence questionDB;
	private IQuestionSorters sortersDB;
	private InterfaceListQuestionsRepo listQuestionsRepo;
	private InterfaceDeleteQuestionsRepo deleteQuestionsRepo;
	private IPasswordValidationFactory passwordValidationFactory;
	private ISecurityFactory securityFactory;


	private SystemConfig() {
		userDB = new UserDB();
		databaseConfiguration = new DefaultDatabaseConfiguration();
		courseDB = new CourseDB();
		courseUserRelationshipDB = new CourseUserRelationshipDB();
		questionDB = new QuestionDB();
		sortersDB = new SortingDB();
		listQuestionsRepo = new ListQuestionsRepo();
		deleteQuestionsRepo = new DeleteQuestionsRepo();
		passwordValidationFactory = new DefaultPasswordValidationFactory();
		securityFactory = new DefaultSecurityFactory();
	}

	public static SystemConfig instance() {
		if (null == uniqueInstance) {
			uniqueInstance = new SystemConfig();
		}
		return uniqueInstance;
	}

	public InterfaceListQuestionsRepo getListQuestionsRepo() {
		return listQuestionsRepo;
	}

	public void setListQuestionsRepo(InterfaceListQuestionsRepo listQuestionsRepo) {
		this.listQuestionsRepo = listQuestionsRepo;
	}

	public InterfaceDeleteQuestionsRepo getDeleteQuestionsRepo() {
		return deleteQuestionsRepo;
	}

	public void setDeleteQuestionsRepo(InterfaceDeleteQuestionsRepo deleteQuestionsRepo) {
		this.deleteQuestionsRepo = deleteQuestionsRepo;
	}

	public IUserPersistence getUserDB() {
		return userDB;
	}

	public void setUserDB(IUserPersistence userDB) {
		this.userDB = userDB;
	}

	public IDatabaseConfiguration getDatabaseConfiguration() {
		return databaseConfiguration;
	}

	public void setDatabaseConfiguration(IDatabaseConfiguration databaseConfiguration) {
		this.databaseConfiguration = databaseConfiguration;
	}

	public void setCourseDB(ICoursePersistence courseDB) {
		this.courseDB = courseDB;
	}

	public ICoursePersistence getCourseDB() {
		return courseDB;
	}

	public void setCourseUserRelationshipDB(ICourseUserRelationshipPersistence courseUserRelationshipDB) {
		this.courseUserRelationshipDB = courseUserRelationshipDB;
	}

	public ICourseUserRelationshipPersistence getCourseUserRelationshipDB() {
		return courseUserRelationshipDB;
	}

	public IQuestionsPersistence getQuestionDB() {
		return questionDB;
	}

	public void setQuestionDB(IQuestionsPersistence questionDB) {
		this.questionDB = questionDB;
	}

	public IQuestionSorters getSortersDB() {
		return sortersDB;
	}

	public void setSortersDB(IQuestionSorters sortersDB) {
		this.sortersDB = sortersDB;
	}

	public IPasswordValidationFactory getPasswordValidationFactory() {
		return passwordValidationFactory;
	}

	public void setPasswordValidationFactory(IPasswordValidationFactory passwordValidationFactory) {
		this.passwordValidationFactory = passwordValidationFactory;
	}

	public ISecurityFactory getSecurityFactory() {
		return securityFactory;
	}

	public void setSecurityFactory(ISecurityFactory securityFactory) {
		this.securityFactory = securityFactory;
	}
}
