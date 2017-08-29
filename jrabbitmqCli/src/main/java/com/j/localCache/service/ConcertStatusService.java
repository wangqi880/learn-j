package com.j.localCache.service;

/**
 * Created by Administrator on 2017/8/22.
 */
public interface ConcertStatusService
{
	//删除key
	public void del(String key);
	//获取本地缓存数据
	public Object get(String key);
	//把rediskey写入本地缓存
	public void loadToLocalCache(String redisKey);
}
