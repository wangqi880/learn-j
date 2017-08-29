package com.j.common.anotation.loginAuth;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Administrator on 2017/8/29.
 * 确定那些方法有那些角色访问
 * 如果为base，那么可以被所有用户访问
 * base就是角色，这些都可以搞成枚举
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthMethod
{
	public String role() default "base";
}
