package org.sails.security.rest;

import org.sails.security.SecurityUser;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Created by Nodirbek on 18.09.2015.
 */
public class JSONTokenAuthentication extends AbstractAuthenticationToken {

    private UserDetails userDetails;


    public JSONTokenAuthentication(Collection<? extends GrantedAuthority> authorities, SecurityUser securityUser) {
        super(authorities);
        super.setAuthenticated(true);
        this.userDetails = securityUser;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return this.userDetails;
    }
}
