package com.zl.employment.vo;

public class UploadMsgVO
{
    private String code;
    private String msg;
    private String data;

    public UploadMsgVO()
    {
        code = "0";
        msg = "";
    }

    public UploadMsgVO(String code)
    {
        this.code = code;
        msg = "";
    }

    public UploadMsgVO(String code, String msg)
    {
        this.code = code;
        this.msg = msg;
    }

    public UploadMsgVO(String code, String msg, String data)
    {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public String getData()
    {
        return data;
    }

    public void setData(String data)
    {
        this.data = data;
    }

    @Override
    public String toString()
    {
        return "UploadMsgVO{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
