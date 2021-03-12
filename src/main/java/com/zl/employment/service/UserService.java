package com.zl.employment.service;

public interface UserService
{
    /**
     * 判断是否有相同的用户名
     * @param username  用户名
     * @param idType    用户类型
     * @return  是否有相同的用户名
     */
    boolean isSameUsername(String username, String idType);

    /**
     * 插入用户注册的信息
     * @param username  用户名
     * @param password  密码
     * @param idType    用户类型
     * @return  是否插入成功
     */
    boolean insertInfo(String username, String password, String idType);

    /**
     * 验证用户账号密码是否正确
     * @param username  用户名
     * @param password  密码
     * @param idType    用户类型
     * @return  是否插入成功
     */
    boolean vertifyUser(String username, String password, String idType);
}
