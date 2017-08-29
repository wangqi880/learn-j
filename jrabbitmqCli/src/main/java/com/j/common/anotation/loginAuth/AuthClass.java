package com.j.common.anotation.loginAuth;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Administrator on 2017/8/29.
 * 只要在contrllor加了这个注解都需要权限验证
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface  AuthClass
{
	/**
	 * 如果是admin，那么这个类只能是超级管理员访问
	 * 如果是login，那么某些角色可以访问
	 * @return
	 */
	public String value() default "admin";
}
