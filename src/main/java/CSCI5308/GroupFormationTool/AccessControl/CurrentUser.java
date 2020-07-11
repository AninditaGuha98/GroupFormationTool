package CSCI5308.GroupFormationTool.AccessControl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import CSCI5308.GroupFormationTool.SystemConfig;

public class CurrentUser {
	private static CurrentUser uniqueInstance = null;

	private CurrentUser() {

	}

	public static CurrentUser instance() {
		if (null == uniqueInstance) {
			uniqueInstance = new CurrentUser();
		}
		return uniqueInstance;
	}

	public InterfaceUser getCurrentAuthenticatedUser() {
		IUserPersistence userDB = SystemConfig.instance().getUserDB();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication.isAuthenticated()) {
			String bannerID = authentication.getPrincipal().toString();
			InterfaceUser u = UserObjectFactory.createObject(new UserFactory());
			userDB.loadUserByBannerID(bannerID, u);
			if (u.isValidUser()) {
				return u;
			}
		}
		return null;
	}
}
