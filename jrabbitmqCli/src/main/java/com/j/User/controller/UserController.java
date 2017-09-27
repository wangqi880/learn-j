package com.j.User.controller;

import com.j.common.anotation.sign.SecureValid;
import com.j.common.redis.util.RedisUtils;
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

	@RequestMapping("/test.do")
	public Object getTest(){
		RedisUtils.setString("wq","112");
		String v = RedisUtils.get("wq");
		return v;
	}
}
