package org.sails.repository.dao.impl;

import org.sails.entity.DomainUser;
import org.sails.repository.dao.DomainUserDAO;
import org.sails.repository.mappers.DomainUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by User on 11.09.2015.
 */
@Repository
public class DomainUserDAOImpl implements DomainUserDAO {
    @Autowired
    DomainUserMapper userMapper;

    @Override
    public DomainUser getByFirstName(String firstName) {
        return userMapper.getByFirstName(firstName);
    }

    @Override
    public DomainUser getByEmail(String email) {
        return userMapper.getByEmail(email);
    }

    @Override
    public DomainUser getByID(Long id) {
        return null;
    }

    @Override
    public DomainUser persist(DomainUser baseEntity) {
        userMapper.persist(baseEntity);
        return baseEntity;
    }

    @Override
    public Integer persistMyBatisRowCount(DomainUser baseEntity) {
        return null;
    }

    @Override
    public DomainUser update(DomainUser baseEntity) {
        return null;
    }

    @Override
    public Integer updateMyBatisRowCount(DomainUser baseEntity) {
        return null;
    }

    @Override
    public Integer removeMyBatisRowCount(DomainUser baseEntity) {
        return null;
    }

    @Override
    public List<DomainUser> getAll() {
        return null;
    }

    @Override
    public Long count() {
        return null;
    }

    @Override
    public Boolean exist(DomainUser baseEntity) {
        return null;
    }
}
