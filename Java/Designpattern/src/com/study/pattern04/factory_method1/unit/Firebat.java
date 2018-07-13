package com.study.pattern04.factory_method1.unit;

public class Firebat extends Unit{
	public Firebat() {
	type = UnitType.Marine;
	name = "Firebat";
	hp = 80;
	exp =50;
		
	System.out.println(this.name + "생성");
}

	@Override
	public void attack() {
	System.out.println(this.name+"공격 !!!");
}	
}