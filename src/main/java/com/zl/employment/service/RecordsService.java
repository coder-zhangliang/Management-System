package com.zl.employment.service;

import com.zl.employment.pojo.RecruitmentContent;
import com.zl.employment.service.impl.RecordsServiceImpl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

public interface RecordsService
{
    /**
     * 返回招聘贴的条数
     * @return  招聘贴的条数
     */
    Integer pageRecords();

    /**
     * 获取当前页面招聘信息
     * @param limit 每页显示信息条数
     * @param curr  当前页
     * @return  当前页所有的招聘数据
     */
    List<RecruitmentContent> getPageData(Integer limit, Integer curr);

    /**
     * 根据用户名和时间获取文章内容
     * @param username  用户名
     * @param time  发表时间
     * @return  文章内容
     */
    RecruitmentContent getRecruitmentDetail(String username, String time);

    List<RecruitmentContent> recruitmentList(String username);

    List<RecruitmentContent> receiveRecruitment(String username);
}
