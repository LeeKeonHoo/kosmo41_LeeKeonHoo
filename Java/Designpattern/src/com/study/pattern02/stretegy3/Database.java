package com.study.pattern02.stretegy3;

public abstract class Database {
	
	public String name;
	public double rows;
	
	//데이더베이스마다 접속 방식ㅇ ㅣ다르다.
	public abstract void connectDatabase();
}