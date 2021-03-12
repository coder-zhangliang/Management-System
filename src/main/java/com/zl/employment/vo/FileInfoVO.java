package com.zl.employment.vo;

public class FileInfoVO
{
    private String path;
    private String name;
    private String date;

    public String getPath()
    {
        return path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
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
        return "fileInfoVO{" +
                "path='" + path + '\'' +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
