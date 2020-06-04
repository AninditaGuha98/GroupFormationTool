package com.csci5308.grouptool.SecurityTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import com.csci5308.grouptool.Security.AuthMechanismDB;
import com.csci5308.grouptool.Security.IAuthMechanism;
import com.csci5308.grouptool.Security.UserAuth;

public class UserAuthTest {

	@Test
	public void userAuthDefaultConstructor() {
		UserAuth user = new UserAuth();
		
		assertNull(user.getProvidedEmail());
		assertNull(user.getProvidedPassword());
		assertFalse(user.isUserAvailable());
		assertFalse(user.isUserValid());
		assertNull(user.getRoles());
	}
	
	@Test
	public void userAuthConstructorWithOutMechanism() {
		UserAuth user = new UserAuth("raouf@example.com", "1234");
		
		assertEquals(user.getProvidedEmail(), "raouf@example.com");
		assertEquals(user.getProvidedPassword(), "1234");
		assertFalse(user.isUserAvailable());
		assertFalse(user.isUserValid());
		assertNull(user.getRoles());
	}
	
	@Test
	public void userAuthConstrctor() {
		IAuthMechanism mechanism = new AuthMechanismMock();
		UserAuth user = new UserAuth("raouf@example.com", "1234", mechanism);
		List<String> expectedRoles = Arrays.asList("ADMIN", "INSTRUCTOR", "TA");
		
		assertEquals(user.getProvidedEmail(), "raouf@example.com");
		assertEquals(user.getProvidedPassword(), "1234");
		assertTrue(user.isUserAvailable());
		assertTrue(user.isUserValid());
		List<String>actualRoles = user.getRoles();
		for(int i = 0; i < expectedRoles.size(); i++) {
			assertEquals(expectedRoles.get(i), actualRoles.get(i));
		}
	}
	
	@Test
	public void getProvidedEmailTest() {
		UserAuth user = new UserAuth("raouf@example.com", "1234");
		assertEquals(user.getProvidedEmail(), "raouf@example.com");
	}

	@Test
	public void setProvidedEmailTest() {
		UserAuth user = new UserAuth();
		user.setProvidedEmail("raouf@example.com");
		assertEquals(user.getProvidedEmail(), "raouf@example.com");
	}
	
	@Test
	public void getProvidedPasswordTest() {
		UserAuth user = new UserAuth("raouf@example.com", "1234");
		assertEquals(user.getProvidedPassword(), "1234");
	}
	
	@Test
	public void setProvidedPasswordTest() {
		UserAuth user = new UserAuth();
		user.setProvidedPassword("1234");
		assertEquals(user.getProvidedPassword(), "1234");
	}

	@Test
	public void isUserAvailable() {
		IAuthMechanism mechanism = new AuthMechanismMock();
		UserAuth user = new UserAuth("raouf@example.com", "1234", mechanism);
		assertTrue(user.isUserAvailable());
	}
	
	@Test
	public void isUserValid() {
		IAuthMechanism mechanism = new AuthMechanismMock();
		UserAuth user = new UserAuth("raouf@example.com", "1234", mechanism);
		assertTrue(user.isUserValid());
	}
	
	@Test
	public void getRoles() {
		IAuthMechanism mechanism = new AuthMechanismMock();
		UserAuth user = new UserAuth("raouf@example.com", "1234", mechanism);
		List<String> expectedRoles = Arrays.asList("ADMIN", "INSTRUCTOR", "TA");
		
		List<String >actualRoles = user.getRoles();
		for(int i = 0; i < expectedRoles.size(); i++)
			assertEquals(expectedRoles.get(i), actualRoles.get(i));
	}
	
//	@Test
//	public void isUserAvailableDB() {
//		IAuthMechanism mechanism = new AuthMechanismDB();
//		UserAuth user = new UserAuth("raouf.rokhjavan@dal.ca", "1234", mechanism);
//		assertTrue(user.isUserAvailable());
//	}
//	
//	@Test
//	public void isUserValidDB() {
//		IAuthMechanism mechanism = new AuthMechanismDB();
//		UserAuth user = new UserAuth("raouf.rokhjavan@dal.ca", "16546", mechanism);
//		assertTrue(user.isUserValid());
//	}
//	
//	@Test
//	public void getRolesDB() {
//		IAuthMechanism mechanism = new AuthMechanismDB();
//		UserAuth user = new UserAuth("raouf.rokhjavan@dal.ca", "16546", mechanism);
//		List<String> expectedRoles = Arrays.asList("ADMIN", "USER");
//		
//		List<String >actualRoles = user.getRoles();
//		for(int i = 0; i < expectedRoles.size(); i++)
//			assertEquals(expectedRoles.get(i), actualRoles.get(i));
//	}
}
