package com.zl.employment.pojo;

import java.sql.Timestamp;

public class RecruitmentContent
{
    private String username;
    private String company;
    private String headline;
    private String content;
    private String date;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getCompany()
    {
        return company;
    }

    public void setCompany(String company)
    {
        this.company = company;
    }

    public String getHeadline()
    {
        return headline;
    }

    public void setHeadline(String headline)
    {
        this.headline = headline;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    @Override
    public String toString()
    {
        return "RecruitmentContent{" +
                "username='" + username + '\'' +
                ", company='" + company + '\'' +
                ", headline='" + headline + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                '}';
    }
}
