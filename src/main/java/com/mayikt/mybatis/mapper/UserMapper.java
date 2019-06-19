package com.mayikt.mybatis.mapper;

import com.mayikt.mybatis.entity.UserEntity;

public interface UserMapper {

    UserEntity getUser(Long id);

    int updateUser(Long id);

}
