package org.sails.security;

import org.sails.entity.DomainUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Created by Nodirbek on 07.09.2015.
 */
public class SecurityUser implements UserDetails {
    private DomainUser domainUser;
    private Collection<GrantedAuthority> authorities;

    public SecurityUser(DomainUser domainUser) {
        this.domainUser = domainUser;
        this.authorities = domainUser.getAuthorities();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return domainUser.getPassword();
    }

    @Override
    public String getUsername() {
        return domainUser.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
