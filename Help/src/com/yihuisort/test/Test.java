package com.yihuisort.test;
import java.util.ArrayList;


import java.util.Arrays;
import java.util.List;

import com.yihuisort.entity.Student;
import com.yihuisort.help.Che;

public class Test {

	public static void main(String[] args) {
		/*boolean a = Che.valueOf(true);
		boolean b = Che.valueOf(true);
		System.out.println(a==b);*/
		
		
		/*三元表达式
		 * System.out.println(1==1?2:3);
		*/
		//集合转数组
		List<Integer> list=new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        Object[] b=list.toArray();
        
        //数组转集合
		Integer[] a=new Integer[]{1,2,3,4,5};
		list=Arrays.asList(a);
		
		//取集合多少位到多少位的数据
		List<Integer> list1=new ArrayList<Integer>();
		list1=list.subList(0,3);
	}

	// 字符串比较需注意知识点
	public static void String() {
		String a = ""; // 定义的，长度为0
		String b = null; // 未定义的，不能使用equals和length方法
		// 对
		System.out.println(a.isEmpty());
		// 判断字符串的几种方法
		System.out.println(a != null && a.length() > 0);
		System.out.println(b == null || "".equals(b));
		System.out.println(b == null || b.isEmpty());
		System.out.println(a == null || "".equals(a));

		System.out.println("----------------------------");
		// 错
		System.out.println(b.equals(""));
		System.out.println(b.length());
	}



}
