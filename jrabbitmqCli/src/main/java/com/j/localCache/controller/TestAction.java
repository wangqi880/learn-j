package com.j.localCache.controller;

import com.j.localCache.service.ConcertStatusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/8/22.
 */
@RestController
public class TestAction
{
	@Autowired ConcertStatusServiceImpl concertStatusService;

	@RequestMapping("/setLocal")
	public String set(){
		concertStatusService.loadToLocalCache("t");
		return "success";
	}

	@RequestMapping("/get.do")
	public String get(String key){

		Object s = concertStatusService.get(key);

		return s.toString();
	}
}
