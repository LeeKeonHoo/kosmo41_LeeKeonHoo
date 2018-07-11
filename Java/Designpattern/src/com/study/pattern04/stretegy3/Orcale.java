package com.study.pattern04.stretegy3;

public class Orcale extends Database {

	public Orcale(){
		name = "Orcale";
		rows =10;
	}
	@Override
	public void connectDatabase() {
		System.out.println(name + " 에 접속햇습니다.");
	}
}