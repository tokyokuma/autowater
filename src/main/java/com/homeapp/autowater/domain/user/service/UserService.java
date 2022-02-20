package com.homeapp.autowater.domain.user.service;

import com.homeapp.autowater.domain.user.model.MUser;

import java.util.List;

public interface UserService {
    /** ユーザー登録 */
    public void signup(MUser user);

    /** ユーザー取得 */
    public List<MUser> getUsers();

    /** ユーザー取得(1件) */
    public MUser getUserOne(String userId);
}
