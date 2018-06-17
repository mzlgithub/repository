package com.yihuisort.common;

public class Car {
	
	public Car()
	{
		System.out.println("汽车无参构造！");
	}
	
	{
		System.out.println("汽车代码块！");
	}
	
	static{
		System.out.println("汽车静态代码块！");
	}
	
	public int run()
	{
		System.out.println("汽车跑起来！");
		return 0;
	}
}
