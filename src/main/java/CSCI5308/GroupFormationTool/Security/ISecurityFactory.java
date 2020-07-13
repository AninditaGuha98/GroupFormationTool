package CSCI5308.GroupFormationTool.Security;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public interface ISecurityFactory {
	public IPasswordEncryption createPassworEncryption();
	public AbstractAuthenticationToken createAuthenticationToken(Object principal, Object credentials, 
			Collection<? extends GrantedAuthority> authorities);
	public GrantedAuthority createGrantedAuthority(String role);
}
