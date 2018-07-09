package com.study.pattern.singleton;

public class ClassOne {
	
	public ClassOne(){
		
	MySingletonClass single = MySingletonClass.getInstance();
	int num = single.getI();
	System.out.println(num);
	
	single.setI(200);
	System.out.println("i = " + single.getI());
	}
}