package com.study.pattern03.simple_factory1;

enum UnitType{
	Marine,
	Firebat,
	Medic
}
public class UnitFactory {
	
	public static Unit createUnit(UnitType type) {
		Unit unit = null;
		
		switch (type) {
		//구체적인 생성 방법을지정하여 생성한다
		//생성시 파라미터가 있다면 생성자에 추가할 수도 있다.
		case Marine:
			unit = new Marine();
			break;
		case Firebat:
			unit = new Firebat();
			break;
		case Medic:
			unit = new Medic();
			break;
		}
		return unit;
	}
}