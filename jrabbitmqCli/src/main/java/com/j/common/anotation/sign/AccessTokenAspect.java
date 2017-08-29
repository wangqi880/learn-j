package com.j.common.anotation.sign;

import com.j.common.domain.JResult;
import com.j.common.service.ApiService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/8/28.
 */
@Aspect
@Component
public class AccessTokenAspect
{

@Autowired ApiService apiService;

	//当使用这个主解释，通知这个方法处理
	@Around(value = "execution(* com.j.User.controller.*.*(..)) && @annotation(secureValid)")
	public Object doAccessCheckToken(ProceedingJoinPoint pj, SecureValid secureValid) throws Throwable
	{
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		HttpServletRequest request= ((ServletRequestAttributes) ra).getRequest();
		String token=request.getParameter("token");
		String appid=request.getParameter("appid");

		if(appid==null || token==null){
			return new JResult().errer("验签失败appid或者token为null","999991",null);
		}

		//这里可以传接口名
		boolean verify = apiService.verifyTokenByAppid(appid,token);

		if(verify){
			Object obj =  pj.proceed();
			return obj;
		}else {
			return new JResult().errer("验签失败","999999",null);
		}

	}

}
