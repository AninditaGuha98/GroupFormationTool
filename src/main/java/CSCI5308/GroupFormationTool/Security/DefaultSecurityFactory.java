package CSCI5308.GroupFormationTool.Security;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class DefaultSecurityFactory implements ISecurityFactory {

	@Override
	public IPasswordEncryption createPassworEncryption() {
		return new BCryptPasswordEncryption();
	}
	
	@Override
	public AbstractAuthenticationToken createAuthenticationToken(Object principal, Object credentials, 
			Collection<? extends GrantedAuthority> rights) {
		return new UsernamePasswordAuthenticationToken(principal, credentials, rights);
	}
	
	@Override 
	public GrantedAuthority createGrantedAuthority(String role) {
		return new SimpleGrantedAuthority("ADMIN");
	}
}
