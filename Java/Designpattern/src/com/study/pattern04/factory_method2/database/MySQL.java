package com.study.pattern04.factory_method2.database;

//<summary>
//A 'ConcreteProduct' class
//<summary>

public class MySQL extends Database {

	public MySQL() {
		name = "MySQL";
		rows = 20;
	}
	@Override
	public void connectDatabase() {
		System.out.println(name + "에 접속햇습니다.");
	}

}
