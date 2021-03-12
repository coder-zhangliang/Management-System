package com.zl.employment.service.impl;

import com.zl.employment.mapper.UserMapper;
import com.zl.employment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    UserMapper user;

    /**
     * 查找是否存在相同用户名的数据
     * @param username  用户名
     * @param idType    用户类型
     * @return  是否存在相同用户名的数据
     */
    @Override
    public boolean isSameUsername(String username, String idType)
    {
        int exit = user.queryUsername(username, idType);
        // 如果存在一个，说明已经找到
        if (exit == 1)
            return true;
        else return false;
    }

    /**
     * 插入用户信息
     * @param username  用户名
     * @param password  密码
     * @param idType    用户类型
     * @return  是否插入成功
     */
    @Override
    public boolean insertInfo(String username, String password, String idType)
    {
        Integer success = user.insertInfo(username, password, idType);
        System.out.println("受影响的行数" + success);
        if (success == 1)
            return true;
        else return false;
    }

    /**
     * 验证用户账号密码
     * @param username  用户名
     * @param password  密码
     * @param idType    用户类型
     * @return  是否验证成功
     */
    @Override
    public boolean vertifyUser(String username, String password, String idType)
    {
        Integer success = user.verifyUser(username, password, idType);
        System.out.println("success" + success);
        if (success == 1)
            return true;
        else return false;
    }
}
