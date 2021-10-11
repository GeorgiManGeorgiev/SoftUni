package com.example.pathfinderd.model.entity;

import com.example.pathfinderd.model.entity.enums.RoleNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    private RoleNameEnum name;

    public Role() {
    }

    @Enumerated(EnumType.STRING)
    public RoleNameEnum getName() {
        return name;
    }

    public Role setName(RoleNameEnum name) {
        this.name = name;
        return this;
    }
}
