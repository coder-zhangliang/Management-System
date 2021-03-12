package com.zl.employment.controller;

import com.zl.employment.pojo.RecruitmentContent;
import com.zl.employment.service.RecordsService;
import com.zl.employment.vo.FileInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

@RestController
@RequestMapping("/query")
public class QueryController
{
    @Autowired
    RecordsService records;

    @PostMapping("/RecruitmentDetail")
    public RecruitmentContent recruitmentDetail(String username, String dateTime)
    {
        System.out.println("detail: " + username + dateTime);
        return records.getRecruitmentDetail(username, dateTime);
    }

    /**
     * 根据用户名获取用户类型
     * @param username  用户名
     * @param session   session
     * @return  用户类型
     */
    @PostMapping("/getIdType")
    public String getIdType(String username, HttpSession session)
    {
        System.out.println("session name=" + username);
//        System.out.println("session value=" + Arrays.toString());
        Enumeration<String> attributeNames = session.getAttributeNames();

        while (attributeNames.hasMoreElements()) {
            // 获取session键值
            String name = attributeNames.nextElement().toString();
            // 根据键值取session中的值
//            Object value = session.getAttribute(name);
            // 打印结果
            System.out.println("<B>" + name + "</B>=");
        }
        System.out.println(session.getAttribute(username).toString());
        return session.getAttribute(username).toString();
    }

    /**
     * 查询发布过的招聘
     * @param username  用户名
     * @return  招聘记录
     */
    @PostMapping("/recruitmentList")
    public List<RecruitmentContent> recruitmentList(String username)
    {
        return records.recruitmentList(username);
    }

    /**
     * 获取简历
     * @param loginId   企业用户的用户名
     * @return  简历及发表人和发表时间
     */
    @PostMapping("/receiveRecruitment")
    public List<FileInfoVO> receiveRecruitment(@RequestParam("username") String loginId)
    {
        //List<RecruitmentContent> r = records.receiveRecruitment(username);
        // 获取路径
        System.out.println("username -> " + loginId);
        String filePath = Thread.currentThread().getContextClassLoader().getResource("static/resumes/" + loginId).getPath();
        filePath = filePath.substring(1, filePath.length());
        System.out.println(filePath);
        String hrPath = filePath + loginId;  // 不同hr放文件的位置
        File file = new File(filePath);
        File[] filesName = file.listFiles();
        List<FileInfoVO> fileInfoVO = new ArrayList<>();    // 保存数据
        // 将数据存储到VO
        for (int i = 0; i < filesName.length; i++)
        {
            FileInfoVO f = new FileInfoVO();
            String path = "http://localhost:8080/resumes/" + loginId + "/" +
                          filesName[i].getName();
            String str = filesName[i].getName();
            String[] temp = str.split("~");
            System.out.println(Arrays.toString(temp));
            String date = temp[1].replace(".png", "").replace("_", ":");
            String name = temp[0];
            f.setPath(path);
            f.setDate(date);
            f.setName(name);
            fileInfoVO.add(f);
        }

        return fileInfoVO;
    }
}