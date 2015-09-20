package org.sails.security;

import org.springframework.security.core.GrantedAuthority;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Nodirbek
 */
public enum UserRoles implements GrantedAuthority {

    ROLE_VISITOR("ROLE_VISITOR"),
    ROLE_ORGANIZATION_PUBLISHER("ROLE_ORGANIZATION_PUBLISHER"),
    ROLE_ORGANIZATION_ADMIN("ROLE_ORGANIZATION_ADMIN"),
    ROLE_SYSTEM_ADMIN("ROLE_SYSTEM_ADMIN");

    private UserRoles(String role) {
        this.role = role;
    }

    private final String role;

    @Override
    public String getAuthority() {
        return role;
    }

    public static GrantedAuthority getAuthorities(String role) {
        UserRoles userRoles = null;
        for (UserRoles roles : UserRoles.values()) {
            if (roles.getAuthority().equals(role)) {
                userRoles = roles;
                break;
            }
        }
        return userRoles;
    }

    public static Collection<GrantedAuthority> getAuthorities(Collection<String> authorities) {
        if (authorities != null && authorities.size() > 0) {
            return authorities.stream().map(UserRoles::getAuthorities).collect(Collectors.toList());
        }
        return null;

    }
}
