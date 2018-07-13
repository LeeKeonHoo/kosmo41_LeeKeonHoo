package com.study.pattern04.factory_method2.database;

//<summary>
//B 'ConcreteProduct' class
//<summary>

public class Orcale extends Database {

	public Orcale() {
		name = "Orcale";
		rows = 20;
	}
	@Override
	public void connectDatabase() {
		System.out.println(name + "에 접속햇습니다.");
	}

}
