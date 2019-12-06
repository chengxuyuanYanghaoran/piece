package com.hlwxy.xr_piece.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hlwxy.xr_piece.system.domain.UserDO;
import com.hlwxy.xr_piece.system.domain.WagesDO;
import com.hlwxy.xr_piece.system.service.UserService;
import com.hlwxy.xr_piece.utils.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


/**
 * 
 * 
 * @author lu
 * @email 1992lcg@163.com
 * @date 2019-11-11 17:24:51
 */
 
@Controller
@RequestMapping("/system/user")
public class UserController{
	@Autowired
	private UserService userService;
	
	@GetMapping()
	String User(){
	    return "system/user/user";
	}
	
	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<UserDO> userList = userService.list(query);
		int total = userService.count(query);
		PageUtils pageUtils = new PageUtils(userList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	String add(){
	    return "system/user/add";
	}

	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") Integer id,Model model){
		UserDO user = userService.get(id);
		model.addAttribute("user", user);
	    return "system/user/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public R save(UserDO user){
		user.setPassword(MD5Utils.encrypt(user.getUsername(), user.getPassword()));
		if(userService.save(user)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public R update( UserDO user){
		userService.update(user);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove(Integer id, HttpSession session) {
        UserDO user = (UserDO)session.getAttribute("user");
        if(user.getUsername().equals("admin")) {
            if (userService.remove(id) > 0) {
                return R.ok();
            }
        }
        return R.error();
        }


	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	public R remove(@RequestParam("ids[]") Integer[] ids){
		userService.batchRemove(ids);
		return R.ok();
	}


	@RequiresPermissions("sys:user:resetPwd")
	@GetMapping("/resetPwd/{id}")
	String resetPwd(@PathVariable("id") Integer id, Model model, HttpSession session) {
		UserDO user = (UserDO)session.getAttribute("user");
		if(user.getId().equals(id)){
			UserDO userDO = new UserDO();
			userDO.setId(id);
			model.addAttribute("user", userDO);
			return "system/user/reset_pwd";
		}else{
			return "system/error/error";
		}
	}


	@PostMapping("/adminResetPwd")
	@ResponseBody
	R adminResetPwd(UserVO userVO) {

		try{
			userService.adminResetPwd(userVO);
			return R.ok();
		}catch (Exception e){
			return R.error(1,e.getMessage());
		}

	}

	@ResponseBody
	@PostMapping("/validateByCard")
	public String validateByCard(UserDO userDO) {
		Map<String,Object> map=new HashMap<>(1);
		map.put("username",userDO.getUsername());
		List<UserDO> list = userService.list(map);
		if(list.size()>0){
			return "false";
		}
		return "true";
	}

}
