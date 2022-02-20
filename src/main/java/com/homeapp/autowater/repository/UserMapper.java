package com.homeapp.autowater.repository;

import com.homeapp.autowater.domain.user.model.MUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    /** ユーザー登録 */
    public int insertOne(MUser user);
    
    /** ユーザー取得 */
    public List<MUser> findMany();

    /** ユーザー取得(1件) */
    public MUser findOne(String userId);
}
