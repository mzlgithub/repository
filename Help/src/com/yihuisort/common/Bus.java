package com.yihuisort.common;

public class Bus extends Car {
	private String color;
	
	
	public Bus(String color) {
		super();
		this.color = color;
		System.out.println("公共汽车有参构造！");
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}

	{
		System.out.println("公共汽车代码块！");
	}
	
	static{
		System.out.println("公共汽车静态代码块！");
	}

	@Override
	public int run(){
		System.out.println("公共汽车跑起来！");
		return 1;
	}
	
	public static void main(String[] args) {
		Bus bus=new Bus("黄色");
		bus.run();
	}
	
	
	
	
}
