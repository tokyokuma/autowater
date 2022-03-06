package com.homeapp.autowater.domain.user.service.impl;

import java.util.List;

import com.homeapp.autowater.domain.user.model.MUser;
import com.homeapp.autowater.domain.user.service.UserService;
import com.homeapp.autowater.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    /** ユーザ登録 */
    @Override
    public void signup(MUser user){
        user.setDepartmentId(1);
        user.setRole("ROLE_GENERAL");
        mapper.insertOne(user);
    }
    
    /** ユーザー取得 */
    @Override
    public List<MUser> getUsers(MUser user) {
        return mapper.findMany(user);
    }

    /** ユーザー取得(1件) */
    @Override
    public MUser getUserOne(String userId) {
        return mapper.findOne(userId);
    }

    /** ユーザー更新(1件) */
    @Override
    public void updateUserOne(String userId,
        String password,
        String userName){
        mapper.updateOne(userId, password, userName);

    }

    @Override
    /** ユーザー削除(1件) */
    public void deleteUserOne(String userId){
        int count = mapper.deleteOne(userId);
    }
}
