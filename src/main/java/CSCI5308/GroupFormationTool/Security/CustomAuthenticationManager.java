package CSCI5308.GroupFormationTool.Security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.AccessControl.IUserPersistence;
import CSCI5308.GroupFormationTool.AccessControl.User;

public class CustomAuthenticationManager implements AuthenticationManager {
	private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationManager.class);
    private static final String CUSTOME_AUTH_MANAGER_LOG = "AuthenticationManager";
    
	private static final String ADMIN_BANNER_ID = "B-000000";
	
	private Authentication checkAdmin(String password, User u, Authentication authentication)
			throws AuthenticationException {
		ISecurityFactory secFactory = SystemConfig.instance().getSecurityFactory();

		// The admin password is not encrypted because it is hardcoded in the DB.
		if (password.equals(u.getPassword())) {
			logger.warn("user={}, action={}, status={}",
					u.getBanner(), "Check Admin User Credentials", "Success");
			// Grant ADMIN rights system-wide, this is used to protect controller mappings.
			List<GrantedAuthority> rights = new ArrayList<GrantedAuthority>();
			rights.add(secFactory.createGrantedAuthority("ADMIN"));
			// Return valid authentication token.
			AbstractAuthenticationToken token = secFactory.createAuthenticationToken(
					authentication.getPrincipal(), authentication.getCredentials(), rights);
			logger.info("user={}, action={}, status={}",
					u.getBanner(), "Create Admin Authentication Token", "Success");
			return token;
		} else {
			logger.warn("user={}, action={}, status={}",
					u.getBanner(), "Check Admin User Credentials", "Fail");
			throw new BadCredentialsException("1000");
		}
	}

	private Authentication checkNormal(String password, User u, Authentication authentication)
			throws AuthenticationException {
		ISecurityFactory secFactory = SystemConfig.instance().getSecurityFactory();
		IPasswordEncryption passwordEncryption = secFactory.createPassworEncryption();
		
		if (passwordEncryption.matches(password, u.getPassword())) {
			logger.warn("user={}, action={}, status={}",
					u.getBanner(), "Check User Credentials", "Success");
			// Grant USER rights system-wide, this is used to protect controller mappings.
			List<GrantedAuthority> rights = new ArrayList<GrantedAuthority>();
			rights.add(secFactory.createGrantedAuthority("USER"));
			// Return valid authentication token.
			AbstractAuthenticationToken token = secFactory.createAuthenticationToken(
					authentication.getPrincipal(), authentication.getCredentials(), rights);
			logger.info("user={}, action={}, status={}",
					u.getBanner(), "Create User Authentication Token", "Success");
			return token;
		} else {
			logger.warn("user={}, action={}, status={}",
					u.getBanner(), "Check User Credentials", "Fail");
			throw new BadCredentialsException("1000");
		}
	}

	// Authenticate against our database using the input banner ID and password.
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String bannerID = authentication.getPrincipal().toString();
		String password = authentication.getCredentials().toString();
		IUserPersistence userDB = SystemConfig.instance().getUserDB();
		User u;
		
		try {
			u = new User(bannerID, userDB);
		} catch (Exception e) {
			logger.warn("user={}, action={}, status={}, message={}",
					CUSTOME_AUTH_MANAGER_LOG, "User Authentication", "Fail", e.getMessage());
			throw new AuthenticationServiceException("1000");
		}
		logger.warn("user={}, action={}, status={}",
				u.getBanner(), "User Authentication", "Starting...");
		if (u.isValidUser()) {
			logger.warn("user={}, action={}, status={}",
					u.getBanner(), "Check User Validity", "Success");
			if (bannerID.toUpperCase().equals(ADMIN_BANNER_ID)) {
				return checkAdmin(password, u, authentication);
			} else {
				return checkNormal(password, u, authentication);
			}
		} else {
			// No user with this banner id found.
			logger.warn("user={}, action={}, status={}",
					u.getBanner(), "Check User Validity", "Fail");
			throw new BadCredentialsException("1001");
		}
	}
}
