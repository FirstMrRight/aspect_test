package org.liutx.aspect_demo.entity;

import lombok.Data;


@Data
public class UserEntity {
    private Long id;
    private String name;

    public UserEntity() {
    }

    public UserEntity(String name) {
        this.name = name;
    }
}
