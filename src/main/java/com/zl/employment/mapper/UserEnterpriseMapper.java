package com.zl.employment.mapper;

import com.zl.employment.pojo.UserEnterprise;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserEnterpriseMapper {
    int insert(UserEnterprise record);

    List<UserEnterprise> selectAll();
}