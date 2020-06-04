package com.csci5308.grouptool.Security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DBAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
    	
    	IAuthMechanism mechanism = new AuthMechanismDB();
    	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String email;
        
        email = authentication.getName();
        Object credentials = authentication.getCredentials();
//        System.out.println("credentials class: " + credentials.getClass());
        if (!(credentials instanceof String)) {
            return null;
        }
        String inputPassword = credentials.toString();
        
    	UserAuth user = new UserAuth(email, inputPassword, mechanism);

               
        if (!user.isUserValid()) {
            throw new BadCredentialsException("Authentication failed for " + email);
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        
        for (String role: user.getRoles())
        	grantedAuthorities.add(new SimpleGrantedAuthority(role));
        Authentication auth = new
                UsernamePasswordAuthenticationToken(email, inputPassword, grantedAuthorities);
        return auth;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}