package org.sails.services.impl;

import org.sails.entity.DomainUser;
import org.sails.repository.dao.DomainUserDAO;
import org.sails.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by User on 12.09.2015.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    DomainUserDAO domainUserDAO;

    @Override
    public DomainUser getUser(String email) {
        return domainUserDAO.getByEmail(email);
    }

    private boolean emailExist(final String email) {
        final DomainUser user = domainUserDAO.getByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }
}
