package CSCI5308.GroupFormationTool.CourseAdmin.Interface;

import java.util.List;

import CSCI5308.GroupFormationTool.AccessControl.User;

public interface IStudentCSVParser {

	public List<User> parseCSVFile(List<String> failureResults);

}
