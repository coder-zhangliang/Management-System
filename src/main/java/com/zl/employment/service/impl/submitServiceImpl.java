package com.zl.employment.service.impl;

import com.zl.employment.mapper.SubmitMapper;
import com.zl.employment.service.SubmitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class submitServiceImpl implements SubmitService
{
    @Autowired
    SubmitMapper submit;

    @Override
    public boolean isSuccessInsertRelease(String username, String company, String headline, String content)
    {
        Integer success = submit.insertReleaseInfo(username, company, headline, content);
        if (success == 1)
            return true;
        else return false;
    }

    @Override
    public boolean updateUserInfo(String username, String idType, String email, String city, String sign, String gender)
    {
        Integer success = submit.updateUserInfo(username, idType, email, city, sign, gender);
        if (success == 1)
            return true;
        else return false;
    }
}
