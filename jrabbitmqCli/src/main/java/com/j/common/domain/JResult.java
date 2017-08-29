package com.j.common.domain;

import lombok.Data;

/**
 * Created by Administrator on 2017/8/28.
 */
@Data
public class JResult
{
	String info;
	String code;
	Object data;

	public JResult errer(String info,String code,String data){
		JResult jr = new JResult();
		jr.setCode(code);
		jr.setInfo(info);
		jr.setData(data);
		return jr;
	}

	public JResult()
	{
	}



}
