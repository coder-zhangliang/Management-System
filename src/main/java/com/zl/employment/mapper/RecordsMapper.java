package com.zl.employment.mapper;

import com.zl.employment.pojo.RecruitmentContent;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

public interface RecordsMapper
{
    /**
     * 查询所有招聘信息的条数
     * @return  招聘信息的条数
     */
    Integer pageRecords();

    /**
     * 查询页面的招聘信息
     */
    List<RecruitmentContent> pageData();

    /**
     * 获取文章内容
     * @param username  用户名
     * @param dateTime  发表时间
     * @return  文章内容
     */
    RecruitmentContent getRecruitmentDetail(@Param("username") String username,
                                                    @Param("dateTime") String dateTime);

    /**
     * 获取发布过的招聘列表
     * @param username  用户名
     * @return  招聘列表
     */
    List<RecruitmentContent> recruitmentList(@Param("username") String username);

    /**
     * 获取简历列表
     * @param username  用户名
     * @return  简历列表
     */
    List<RecruitmentContent> receiveRecruitment(@Param("username") String username);
}