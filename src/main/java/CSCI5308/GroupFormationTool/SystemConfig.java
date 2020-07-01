package CSCI5308.GroupFormationTool;

import CSCI5308.GroupFormationTool.AccessControl.IUserPersistence;
import CSCI5308.GroupFormationTool.AccessControl.UserDB;
import CSCI5308.GroupFormationTool.AdminPanel.Interface.ICoursePersistence;
import CSCI5308.GroupFormationTool.AdminPanel.Repository.CourseDB;
import CSCI5308.GroupFormationTool.CourseHomePage.Interface.ICourseUserRelationshipPersistence;
import CSCI5308.GroupFormationTool.CourseHomePage.Repository.CourseUserRelationshipDB;
import CSCI5308.GroupFormationTool.Database.DefaultDatabaseConfiguration;
import CSCI5308.GroupFormationTool.Database.IDatabaseConfiguration;
import CSCI5308.GroupFormationTool.QuestionManager.Interface.IQuestionSorters;
import CSCI5308.GroupFormationTool.QuestionManager.Interface.IQuestionsPersistence;
import CSCI5308.GroupFormationTool.QuestionManager.Interface.InterfaceDeleteQuestionsRepo;
import CSCI5308.GroupFormationTool.QuestionManager.Interface.InterfaceListQuestionsRepo;
import CSCI5308.GroupFormationTool.QuestionManager.Repository.DeleteQuestionsRepo;
import CSCI5308.GroupFormationTool.QuestionManager.Repository.ListQuestionsRepo;
import CSCI5308.GroupFormationTool.QuestionManager.Repository.QuestionDB;
import CSCI5308.GroupFormationTool.QuestionManager.Repository.SortingDB;
import CSCI5308.GroupFormationTool.Security.BCryptPasswordEncryption;
import CSCI5308.GroupFormationTool.Security.IPasswordEncryption;
import CSCI5308.GroupFormationTool.PasswordValidationPolicy.Interface.IPasswordValidationConfiguration;
import CSCI5308.GroupFormationTool.PasswordValidationPolicy.Model.DefaultPasswordValidationConfiguration;
import CSCI5308.GroupFormationTool.AccessControl.*;
import CSCI5308.GroupFormationTool.Database.*;

/*
 * This is a singleton, we will learn about these when we learn design patterns.
 * 
 * The single responsibility of this singleton is to store concrete classes
 * selected by the system for use in the rest of the system. This will allow
 * a form of dependency injection in places where we cannot use normal
 * dependency injection (for example classes that override or extend existing
 * library classes in the framework).
 */
public class SystemConfig {
	private static SystemConfig uniqueInstance = null;
	private IPasswordEncryption passwordEncryption;
	private IUserPersistence userDB;
	private IDatabaseConfiguration databaseConfiguration;
	private ICoursePersistence courseDB;
	private ICourseUserRelationshipPersistence courseUserRelationshipDB;
	private IPasswordValidationConfiguration passwordValidationConfiguration;
	private IQuestionsPersistence questionDB;
	private IQuestionSorters sortersDB;
	private InterfaceListQuestionsRepo listQuestionsRepo;
	private InterfaceDeleteQuestionsRepo deleteQuestionsRepo;

	private SystemConfig() {
		passwordEncryption = new BCryptPasswordEncryption();
		userDB = new UserDB();
		databaseConfiguration = new DefaultDatabaseConfiguration();
		courseDB = new CourseDB();
		courseUserRelationshipDB = new CourseUserRelationshipDB();
		passwordValidationConfiguration = new DefaultPasswordValidationConfiguration();
		questionDB = new QuestionDB();
		sortersDB = new SortingDB();
		listQuestionsRepo = new ListQuestionsRepo();
		deleteQuestionsRepo = new DeleteQuestionsRepo();
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

	public IPasswordEncryption getPasswordEncryption() {
		return passwordEncryption;
	}

	public void setPasswordEncryption(IPasswordEncryption passwordEncryption) {
		this.passwordEncryption = passwordEncryption;
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

	public IPasswordValidationConfiguration getPasswordValidationConfiguration() {
		return passwordValidationConfiguration;
	}

	public void setPasswordValidationConfiguration(IPasswordValidationConfiguration passwordValidationConfiguration) {
		this.passwordValidationConfiguration = passwordValidationConfiguration;
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

}
