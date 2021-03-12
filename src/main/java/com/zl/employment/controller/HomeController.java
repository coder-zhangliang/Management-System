package com.zl.employment.controller;

import com.zl.employment.pojo.RecruitmentContent;
import com.zl.employment.service.RecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController
{
    @Autowired
    RecordsService records;

    @PostMapping("/isLogin")
    public boolean isLogin(HttpServletRequest request, HttpServletResponse response)
    {
        HttpSession session = request.getSession();
//        System.out.println(" home " + session.getAttribute("username") + "homeid" + session.getId());
        Object value = null;
        Enumeration enumeration = session.getAttributeNames();
        // 遍历enumeration
        while (enumeration.hasMoreElements()) {
            // 获取session的属性名称
            String name = enumeration.nextElement().toString();
            // 根据键值取session中的值
            if (session.getAttribute(name) != null)
                value = session.getAttribute(name);
            // 打印结果
            System.out.println("name:" + name);
        }

        if (value == null)
            return true;
        else return true;
    }

    @PostMapping("/outLogin")
    public String outLogin(HttpSession session)
    {
//        System.out.println("session value" + session.getAttribute("123"));
        session.invalidate();
        return "ok";
    }


    @PostMapping("/countPageRecords")
    public int countRecords()
    {
        return records.pageRecords();
    }

    /**
     * 分页，显示招聘信息
     * @param limit 每页的信息条数
     * @param curr  当前页
     */
    @PostMapping("/pageData")
    public List<RecruitmentContent> pageData(Integer limit, Integer curr)
    {
        System.out.println("limit -> " + limit + "\t" + "curr -> " + curr);
        return records.getPageData(limit, curr);
    }
}