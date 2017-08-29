package com.j.localCache;


/**
 * Created by Administrator on 2017/8/23.
 */
public enum ConCertStatusEun
{
	LIVESTATUSSTMP("1","演唱会状态值"),

	TANMUSTMP("2","弹幕开关"),
	NUM("3","观看人数值"),
	TABSTMP("4","Tab框架时间戳"),
	LIVEURLSTMP("5","直播地址时间戳（显示图片、直播链接、切换web）"),
	CONTRIBUTEBSTMP("6","贡献榜时间戳"),
	STARBSTMP("7","明星榜时间戳"),
	PICMARKETSTMP("8","图片营销位时间戳"),
	WARCHANDBUYADSSTMP("9","边看边买广告时间戳"),
	TOPSTMP("10","置顶通知时间戳"),
	STARDBSTMP("11","明星打榜时间戳");

	private String code;
	private String name;
	private ConCertStatusEun(String code,String name)
	{
		this.code = code;
		this.name = name;
	}
	public String getCode()
	{
		return this.code;
	}
	public String getName()
	{
		return this.name;
	}
	/**
	 * 根据编码获取枚举对象,如果没有找到对应的编码对像就返回空
	 * @param code
	 * @return
	 */
	public static ConCertStatusEun getResource(String code)
	{
		for(ConCertStatusEun t: ConCertStatusEun.values())
		{
			if(t.getCode().equals(code))
			{
				return t;
			}
		}
		return null;
	}
}
