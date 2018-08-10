package com.study.pattern04.factory_method2.database;

//<summary>
//C 'ConcreteProduct' class
//<summary>


public class Infomix extends Database {

	public Infomix() {
		name = "Infomix";
		rows = 20;
	}
	@Override
	public void connectDatabase() {
		System.out.println(name + "에 접속햇습니다.");
	}

}
