package org.sails.repository.mappers;

import org.sails.entity.DomainUser;

/**
 * Created by User on 11.09.2015.
 */
public interface DomainUserMapper extends BaseMapper<DomainUser, Long>{
    DomainUser getByFirstName(String firstName);

    DomainUser getByEmail(String email);
}
