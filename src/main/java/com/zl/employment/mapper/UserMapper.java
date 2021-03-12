package com.zl.employment.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserMapper
{
    Integer queryUsername(@Param("username") String username, @Param("userType") String idType);
    Integer insertInfo(@Param("username") String username, @Param("password") String password,
                       @Param("userType") String idType);
    Integer verifyUser(@Param("username") String username, @Param("password") String password,
                       @Param("userType") String idType);
}
