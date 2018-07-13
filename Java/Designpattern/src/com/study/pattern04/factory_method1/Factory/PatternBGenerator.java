package com.study.pattern04.factory_method1.Factory;

import com.study.pattern04.factory_method1.unit.Firebat;
import com.study.pattern04.factory_method1.unit.Marine;

//<summary>
//The 'Creator' abstract class
//<summary>
public class PatternBGenerator extends UnitGenerator{

	@Override
	public void createUnits() {
		units.add(new Firebat());
		units.add(new Firebat());
		units.add(new Firebat());
		units.add(new Firebat());
		units.add(new Marine());
		units.add(new Marine());
		units.add(new Marine());
		units.add(new Marine());

	}
}
