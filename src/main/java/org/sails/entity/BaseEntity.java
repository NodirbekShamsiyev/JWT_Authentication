/*
 * Copyright (c) 2015.
 * Nodirbek Shamsiyev Abdumurod o'g'li
 */

package org.sails.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Nodirbek on 30.04.2015. Project name Sale-Point
 */
public abstract class BaseEntity {

    private Long ID;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    /**
     * First it check for object reference and return true, otherwise it checks by entity ID
     *
     * @param obj must not be {@literal null} and must be extended BaseEntity.
     * @return {@literal true} if object equals
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (this.ID == null || obj == null
                || !(this.getClass().equals(obj.getClass()))) {
            return false;
        }
        return this.ID.equals(((BaseEntity) obj).getID());
    }
}
