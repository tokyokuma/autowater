package com.homeapp.autowater.repository;

import org.apache.ibatis.annotations.Mapper;

import com.homeapp.autowater.domain.user.model.MUser;

@Mapper
public interface UserMapper {

    /** ユーザー登録 */
    public int insertOne(MUser user);
}
