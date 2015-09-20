package org.sails.services;

import org.sails.entity.DomainUser;

/**
 * Created by User on 12.09.2015.
 */
public interface UserService {
   DomainUser getUser(String email);
}
