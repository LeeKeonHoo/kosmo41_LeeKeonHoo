package com.study.pattern04.factory_method1.unit;

public abstract class Unit {
	protected UnitType type;
	protected String name;
	protected int hp, exp;
	
	public abstract void attack();

}
