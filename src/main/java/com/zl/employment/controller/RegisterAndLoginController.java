package com.zl.employment.controller;

import com.zl.employment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.http.HttpResponse;

@RestController
@RequestMapping("/RegisterAndLogin")
public class RegisterAndLoginController
{
    @Autowired
    UserService userService;

    @PostMapping("/username")
    public boolean findUsername(String username, String idType)
    {
        System.out.println(idType);
        System.out.println(username);
        boolean isExit = userService.isSameUsername(username, idType);
        return isExit;
    }

    @PostMapping("/insertInfo")
    public boolean insertInfo(String username, String password, String idType)
    {
        System.out.println(userService.insertInfo(username, password, idType));
        return userService.insertInfo(username, password, idType);
    }

    @PostMapping("/login")
    public boolean login(String username, String password, String idType,
                         HttpServletRequest request, HttpServletResponse response)
    {
        //设置session登录状态
        HttpSession session = request.getSession();
        session.setAttribute(username, idType);
        String id = request.getRequestedSessionId();
        System.out.println("id -> " + id);
        System.out.println("sessionid value -> " + session.getSessionContext().getSession(id));
        System.out.println("login" + session.getAttribute("username") + "loginid " + session.getId());



//        // Cookie 为键值对数据格式
//        Cookie cookieUsername = new Cookie("cookieUsername", username);
//        cookieUsername.setMaxAge(30 * 24 * 60 * 60);
//        // 表示当前项目下都携带这个cookie
//        cookieUsername.setPath(request.getContextPath());
//        // 使用 HttpServletResponse 对象向客户端发送 Cookie
//        response.addCookie(cookieUsername);

        return userService.vertifyUser(username, password, idType);
    }
}