package com.zl.employment.controller;

import ch.qos.logback.core.util.TimeUtil;
import com.zl.employment.service.SubmitService;
import com.zl.employment.vo.UploadMsgVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/submit")
public class SubmitController
{
    @Autowired
    SubmitService submit;

    @PostMapping("/Recruitment")
    public Boolean recruitment(String company, String headline, String content, HttpSession session)
    {
        String username = null;
        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements())
        {
            username = attributeNames.nextElement();
        }
        System.out.println(username);
        return submit.isSuccessInsertRelease(username, company, headline, content);
    }

    @PostMapping("/jump")
    public String jump()
    {
        return "111";
    }

    /**
     * 上传简历
     * @param upload 上传的简历文件
     * @param userLoginId 上传文件的用户ID
     * @Param hrid 发帖人ID
     * @return
     */
    @PostMapping("/upload")
    public UploadMsgVO upload(@RequestParam("file")MultipartFile upload,
                              String userLoginId,
                              String hrId) throws FileNotFoundException
    {
        Date uploadTime = new Date();   // 简历上传的时间

        // 存放文件的路径
        String path = Thread.currentThread().getContextClassLoader().getResource("static").getPath();
        path = path.substring(1, path.length());
        String hrPath = path + "/resumes/" + hrId;  // 不同hr放文件的位置
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 格式化日期
        String time = sdf.format(uploadTime).replace(":", "_"); // 将:变为_

        File f = new File(hrPath);
        if (!f.exists())
        {
            f.mkdirs();
        }
        String path1 = userLoginId + "~" + time + ".png";
        File file = new File(hrPath, path1);  //文件的用户名和时间用#分割
        try
        {
            upload.transferTo(file);
            return new UploadMsgVO();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return new UploadMsgVO("1");
    }

    @PostMapping("/updateUserInfo")
    public boolean updateUserInfo(String username, String idType, String email, String city, String sign, String gender)
    {
        System.out.println("==========================");
        System.out.println("username -> " + username);
        System.out.println("idType -> " + idType);
        System.out.println("email -> " + email);
        System.out.println("city -> " + city);
        System.out.println("sign -> " + sign);
        System.out.println("gender -> " + gender);
        return submit.updateUserInfo(username, idType, email, city, sign, gender);
//        return true;
    }
}