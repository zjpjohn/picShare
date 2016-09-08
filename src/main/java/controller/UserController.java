package controller;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.ImageService;
import service.userService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/9/6.
 */
@Controller
public class UserController {
    @Autowired
    private userService userService;
    @Autowired
    private ImageService imageService;
    //主要是完成用户的登录和注册
    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public void login(@RequestParam("username") String username,
                      @RequestParam("password") String password,
                      @RequestParam("repassword") String repassword,
                      @RequestParam("type") Integer type,
                      HttpServletRequest request,
                      HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("Utf-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        type = Integer.valueOf(request.getParameter("type"));
        if (type == 1) {    //用户登录

            String result = null;
            User user = null;
            //验证用户是否有效
            if (username==null) {
                result = "1";
            } else if (password==null) {
                result = "2";
            } else if ((user = userService.getUserByName(username)) == null) {
                result = "3";
            } else {
                if (!user.getPassword().equals(password)) {
                    result = "4";
                } else {
                    request.getSession().setAttribute("user", user);
                    request.getSession().setAttribute("imageList", imageService.getImage(user.getId()));
                    result = "5";
                }
            }
            out.print(result);
        } else if (type == 2) {    //用户注册
            username = request.getParameter("username");
            password = request.getParameter("password");
            repassword = request.getParameter("repassword");
            String result = null;
            //验证有效性
            if (username==null) {
                result = "1";
            } else if (password==null) {
                result = "2";
            } else if (repassword==null) {
                result = "3";
            } else if (!repassword.equals(password)) {
                result = "4";
            } else if (userService.getUserByName(username) != null) {
                result = "5";
            } else {
                User user = new User(username, password);
                //添加用户
                userService.insertUser(user);
                result = "6";
            }
            out.print(result);
        } else if (type == 3) {    //用户退出
            request.getSession().invalidate();
        }
    }
}
