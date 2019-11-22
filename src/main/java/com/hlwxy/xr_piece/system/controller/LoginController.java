package com.hlwxy.xr_piece.system.controller;

import com.hlwxy.xr_piece.system.domain.UserDO;
import com.hlwxy.xr_piece.system.service.UserService;
import com.hlwxy.xr_piece.utils.MD5Utils;
import com.hlwxy.xr_piece.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author shkstart
 * @create 2019-11-12-9:24
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }


    @RequestMapping("/toPageMain")
    public String toPageMain(Model model) {

        return "index";
    }

    @RequestMapping("/main")
    @ResponseBody
    public R findByUsername(String username, String password, HttpSession session, UserDO userDO) {
        userDO.setUsername(username);
        userDO.setPassword(password);
        userDO.setPassword(MD5Utils.encrypt(userDO.getUsername(), userDO.getPassword()));
        userDO = this.userService.findByUsername(userDO);
        if (userDO != null) {
            session.setAttribute("user", userDO);
            return R.ok();
        } else {
            session.setAttribute("error", "账号或密码错误!请重新输入");
            return R.error();
        }

    }
}
