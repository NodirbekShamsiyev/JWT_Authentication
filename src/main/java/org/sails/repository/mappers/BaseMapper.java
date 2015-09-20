/*
 * Copyright (c) 2015.
 * Nodirbek Shamsiyev Abdumurod o'g'li
 */

package org.sails.repository.mappers;

import org.apache.ibatis.annotations.Select;
import org.sails.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Nodirbek on 30.04.2015.
 */
public interface BaseMapper<T extends BaseEntity, ID extends Serializable> {

    /**
     * Retrieves an entity by its id.
     *
     * @param id must not be {@literal null}.
     * @return the entity with the given id or {@literal null} if none found
     */
    public T getByID(ID id);

    /**
     * Persist an entity using MyBatis insert statement.
     *
     * @param baseEntity must not be {@literal null}.
     * @return effected rows count
     */
    public Integer persist(T baseEntity);

    /**
     * Update an entity using MyBatis update statement.
     *
     * @param baseEntity must not be {@literal null}.
     * @return effected rows count
     */
    public Integer update(T baseEntity);


    /**
     * Remove an entity using MyBatis delete statement.
     *
     * @param baseEntity must not be {@literal null}.
     * @return effected rows count
     */
    public Integer remove(T baseEntity);


    /**
     * Returns all instances of the BaseEntity.
     *
     * @return all entities
     */
    public List<T> getAll();

    /**
     * Returns the number of BaseEntity available.
     *
     * @return the number of entities
     */
    public Long count();
}
