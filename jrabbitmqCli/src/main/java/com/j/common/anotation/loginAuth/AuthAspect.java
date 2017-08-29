package com.j.common.anotation.loginAuth;

import com.j.common.anotation.sign.SecureValid;
import com.j.common.domain.JResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017/8/29.
 */
@Aspect
@Component
public class AuthAspect
{

	//切入点
	@Pointcut("execution(* com.j.manager.controller.*.*(..))")
	public void excBusiness(){}

	@Around("excBusiness()")
	public Object docheckAuth(ProceedingJoinPoint pj) throws Throwable
	{
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		HttpServletRequest request= ((ServletRequestAttributes) ra).getRequest();
		Map<String,Set<String>> allAuths = (Map<String, Set<String>>) request.getSession().getAttribute("allAuths");
		//那用户的角色去对比里面allAuths是否在哪里
		System.out.println("我是在aop中的权限:"+AuthUtil.allAuth);
		Object obj =	pj.proceed();
		return obj;
	}
}
