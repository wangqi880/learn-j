package com.j.manager.controller;

import com.j.common.anotation.loginAuth.AuthClass;
import com.j.common.anotation.loginAuth.AuthMethod;
import com.j.common.anotation.sign.SecureValid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/8/28.
 */
@Controller
@ResponseBody
@AuthClass("login")
public class ManagerController
{

	@RequestMapping(value = "/queryArticle.do",produces = "application/json; charset=utf-8")
	@AuthMethod(role = "ROLE_PUBLISH")
	public Object getArticleInfo(String id)
	{
		return "我是查询文章的id:"+id;
	}
}
