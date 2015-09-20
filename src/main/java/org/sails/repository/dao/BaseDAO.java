/*
 * Copyright (c) 2015.
 * Nodirbek Shamsiyev Abdumurod o'g'li
 */

package org.sails.repository.dao;

import org.sails.entity.BaseEntity;
import org.sails.repository.mappers.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Nodirbek on 06.05.2015. Project name Sale-point
 */
public interface BaseDAO<T extends BaseEntity> {

    public T getByID(Long id);

    public T persist(T baseEntity);

    public Integer persistMyBatisRowCount(T baseEntity);

    public T update(T baseEntity);

    public Integer updateMyBatisRowCount(T baseEntity);

    public Integer removeMyBatisRowCount(T baseEntity);

    public List<T> getAll();

    public Long count();

    /**
     * Check in DB by baseEntity.ID
     *
     * @param baseEntity
     * @return true if productMapper.getByID returns Product instance, or false if BaseMapper.getByID returns null
     */
    public Boolean exist(T baseEntity);
}
