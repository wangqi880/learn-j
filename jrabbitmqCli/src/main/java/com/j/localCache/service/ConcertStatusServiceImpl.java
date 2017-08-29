package com.j.localCache.service;

import com.alibaba.fastjson.JSON;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.guava.GuavaCache;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/8/22.
 */
@Service("concertStatusService")
public class ConcertStatusServiceImpl implements ConcertStatusService
{

	public static final String cacheName = "CONCERTSTATUSCACHE";
	@Resource
	private CacheManager cacheManager;

	 public void del(String key)
	{
		GuavaCache guavaCache = (GuavaCache) cacheManager.getCache(cacheName);
		guavaCache.evict(key);
	}

	 public Object get(String key)
	{
		GuavaCache guavaCache = (GuavaCache) cacheManager.getCache(cacheName);
		Cache.ValueWrapper value=guavaCache.get(key);
		if(value!=null)
		{
			Object v = (Object) value.get();
			return v;
		}else
		return null;
	}

	 public void loadToLocalCache(String redisKey)
	{
		GuavaCache guavaCache = (GuavaCache) cacheManager.getCache(cacheName);
		guavaCache.put("1",123123);
		guavaCache.put("2","nihao");

	}
}
