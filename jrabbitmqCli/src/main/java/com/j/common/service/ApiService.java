package com.j.common.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/28.
 */
@Service
public class ApiService
{

	static Map<String,String> map ;

	static {
		if(map==null){
			map = new HashMap<String,String>();
		}
		map.put("user","tokenUser");
		map.put("payment","tokenPayment");
		map.put("content","tokenContent");

	}

	public boolean verifyToken(String token){

		if("true".equals(token)){
			return true;
		}
		if("false".equals(token)){
			return  false;
		}
		return false;
	}

	public boolean verifyToken(String token,String api){

		if("true".equals(token)){
			return true;
		}
		if("false".equals(token)){
			return  false;
		}
		return false;
	}

	//appid和token都可以报错在数据库中，然后初始化的时候读入内存
	public boolean verifyTokenByAppid(String appid,String token){
		String sysToken = map.get(appid);
		if(sysToken!=null && token.equals(sysToken)){
			return  true;
		}else{
			return false;
		}
	}
}
