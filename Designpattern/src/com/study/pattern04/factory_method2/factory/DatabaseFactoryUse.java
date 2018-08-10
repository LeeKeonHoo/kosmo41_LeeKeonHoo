package com.study.pattern04.factory_method2.factory;

import com.study.pattern04.factory_method2.database.Database;
import com.study.pattern04.factory_method2.database.Infomix;
import com.study.pattern04.factory_method2.database.MySQL;
import com.study.pattern04.factory_method2.database.Orcale;

public class DatabaseFactoryUse extends DatabaseFactory {
	
	//이번에 사용할 데이터베이스는 orcale 이다
	//데이터베이스 변경시 여기서 타입을 변경한다.
	public DBType dbType = DBType.Orcale;
	
	
	@Override
	public Database setDatabase() {
		// 회사 사정에 의해 어떤 데이터베이스르 다시 하용할지 모른다.
		// 그래서 구축한 정보를 지우지 않고 재사용시를 대비한다
		if(dbType == DBType.MySQL)
		{
			System.out.println("MySQL use..");
			return new MySQL();
		}
		else if(dbType == DBType.Orcale)
		{
			System.out.println("Orcale use..");
			return new Orcale();
		}
		else if(dbType == DBType.Infomix)
		{
			System.out.println("Infomix use..");
			return new Infomix();
		}

		return null;
	}

}
