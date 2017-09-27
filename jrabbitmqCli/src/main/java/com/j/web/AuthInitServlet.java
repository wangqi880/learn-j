package com.j.web;

import com.j.common.anotation.loginAuth.AuthUtil;
import com.sun.net.httpserver.HttpServer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017/8/29.
 * 初始化需要在web配置一下
 */
public class AuthInitServlet extends HttpServlet
{
	@Override public void init() throws ServletException
	{
		super.init();
		//初始化权限信息,并把所有的角色权限信息写入内存中
		//当然也把部署所有角色对应的权限初始化的时候写入一个map，这里就案列一下
		Map<String,Set<String>> auths = AuthUtil.initAuth("com.j.manager.controller");
		AuthUtil.allAuth=auths;
		System.out.println("系统初始化成功，所有角色控制权限为:"+auths);

	}
}
