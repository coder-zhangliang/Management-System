package com.zl.employment.mapper;

import com.zl.employment.pojo.UserOrdinary;
import java.util.List;

public interface UserOrdinaryMapper {
    int insert(UserOrdinary record);
    int queryUsername(String username, String radioValue);
    List<UserOrdinary> selectAll();
}