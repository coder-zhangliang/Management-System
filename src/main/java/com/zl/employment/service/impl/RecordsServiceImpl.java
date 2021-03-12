package com.zl.employment.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zl.employment.mapper.RecordsMapper;
import com.zl.employment.pojo.RecruitmentContent;
import com.zl.employment.service.RecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordsServiceImpl implements RecordsService
{
    @Autowired
    RecordsMapper records;

    @Override
    public Integer pageRecords()
    {
        return records.pageRecords();
    }

    @Override
    public List<RecruitmentContent> getPageData(Integer limit, Integer curr)
    {
        PageHelper.startPage(curr, limit);
        List<RecruitmentContent> r = records.pageData();

        return r;
    }

    @Override
    public RecruitmentContent getRecruitmentDetail(String username, String dateTime)
    {

        return records.getRecruitmentDetail(username, dateTime);
    }

    @Override
    public List<RecruitmentContent> recruitmentList(String username)
    {
        return records.recruitmentList(username);
    }

    @Override
    public List<RecruitmentContent> receiveRecruitment(String username)
    {
        return records.receiveRecruitment(username);
    }
}
