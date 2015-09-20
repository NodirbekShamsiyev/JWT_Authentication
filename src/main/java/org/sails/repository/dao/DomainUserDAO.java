package org.sails.repository.dao;

import org.sails.entity.DomainUser;

/**
 * Created by User on 11.09.2015.
 */
public interface DomainUserDAO extends BaseDAO<DomainUser>{
    DomainUser getByFirstName(String firstName);

    DomainUser getByEmail(String email);
}
