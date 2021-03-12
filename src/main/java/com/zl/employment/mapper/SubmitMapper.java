package com.zl.employment.mapper;

import org.apache.ibatis.annotations.Param;

public interface SubmitMapper
{
    /**
     * 将招聘的信息插入到数据库
     * @param username  用户名
     * @param company   公司名
     * @param headline  标题
     * @return  插入的条数
     */
    Integer insertReleaseInfo(@Param("username") String username,
                                @Param("company") String company,
                                @Param("headline") String headline,
                                @Param("content") String content);

    /**
     * 更新用户信息
     * @param username  用户名
     * @param idType    用户类型
     * @param city      城市
     * @return  受影响的行数
     */
    Integer updateUserInfo(@Param("username") String username,
                           @Param("userType") String idType,
                           @Param("email") String email,
                           @Param("city") String city,
                           @Param("sign") String sign,
                           @Param("gender") String gender);
}
