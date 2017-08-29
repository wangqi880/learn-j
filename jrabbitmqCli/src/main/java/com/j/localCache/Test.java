package com.j.localCache;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/23.
 */
public class Test
{
	public  static  void main(String args[]){
		Map<String,Map<String,Long>> map = new HashMap();
		Map<String,Long> map2  = new HashMap();

		map2.put("1",new Date().getTime());
		map2.put("2",new Date().getTime());
		map2.put("3",new Date().getTime());
		map2.put("4",new Date().getTime());
		map2.put("5",new Date().getTime());
		map2.put("6",new Date().getTime());
		map2.put("7",new Date().getTime());
		map2.put("8",new Date().getTime());
		map2.put("9",new Date().getTime());
		map2.put("10",new Date().getTime());
		map2.put("11",new Date().getTime());



		map.put("liveStatus",map2);

		Map<String,Long> map3=map.get("liveStatus");
		System.out.println(JSON.toJSONString(map3));
		String s = JSON.toJSONString(map3);
		JSONObject json = JSON.parseObject(s);
		Map map4 = JSONObject.toJavaObject(json,Map.class);

		System.out.println(JSON.toJSONString(map4));
		String ss =  ConCertStatusEun.CONTRIBUTEBSTMP.getCode();
		System.out.println(ss);
	}
}
