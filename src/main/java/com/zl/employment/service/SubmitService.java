package com.zl.employment.service;

public interface SubmitService
{
    boolean isSuccessInsertRelease(String username, String company, String headline, String content);

    /**
     * 更新用户信息
     * @param username  用户名
     * @param idType    用户类型
     * @param email     邮箱
     * @param sign      签名
     * @param gender    性别
     * @return 是否更新成功
     */
    boolean updateUserInfo(String username, String idType, String email, String city, String sign, String gender);
}
