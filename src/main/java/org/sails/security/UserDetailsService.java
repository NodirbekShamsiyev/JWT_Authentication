package org.sails.security;

import org.sails.entity.DomainUser;
import org.sails.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by Nodirbek on 12.09.2015.
 */
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        DomainUser domainUser = userService.getUser(email);
        if (domainUser == null) {
            throw new org.springframework.security.authentication.AuthenticationCredentialsNotFoundException("No such user " +
                    "with email->" + email);
        }
        return new SecurityUser(domainUser);
    }
}
