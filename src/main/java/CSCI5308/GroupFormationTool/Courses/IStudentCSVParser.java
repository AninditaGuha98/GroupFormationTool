package CSCI5308.GroupFormationTool.Courses;

import java.util.List;

import CSCI5308.GroupFormationTool.AccessControl.InterfaceUser;
import CSCI5308.GroupFormationTool.AccessControl.User;

public interface IStudentCSVParser {

	public List<InterfaceUser> parseCSVFile(List<String> failureResults);

}
