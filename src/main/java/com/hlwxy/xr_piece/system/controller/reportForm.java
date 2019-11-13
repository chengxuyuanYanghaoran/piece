package com.hlwxy.xr_piece.system.controller;

import com.hlwxy.xr_piece.system.domain.UserDO;
import com.hlwxy.xr_piece.system.service.UserService;
import com.hlwxy.xr_piece.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author shkstart
 * @create 2019-11-12-9:24
 */
@Controller
public class reportForm {

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
        return R.error();
    }
}
