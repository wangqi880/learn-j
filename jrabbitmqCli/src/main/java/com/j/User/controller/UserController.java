package com.j.User.controller;

import com.j.common.anotation.sign.SecureValid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * Created by Administrator on 2017/8/28.
 */
@Controller
@ResponseBody
public class UserController
{

	@RequestMapping("/queryUserInfo.do")
	@SecureValid
	public Object getUserinfo(String userId){
		return userId;
	}
}
