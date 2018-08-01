//전화번호 관리 프로그램 구현 프로젝트
//version 0.9

import java.util.*;
import java.io.*;
import java.sql.*;


interface INIT_MENUU	//초기 화면
{
	int DATA = 1, INPUT =2, EXIT =3;
}

interface INPUT_SERACHH	//1.데이터 검색
{
	int NAME =1, FOOD =2, SIDO =3, GIGUNGU =4;
}
class MenuChoiceException extends Exception	//잘못된 선택을 한 경우
{
	int wrongChoice;
	
	public MenuChoiceException(int choice)
	{
		super("잘못된 선택이 이뤄졌습니다.");
		wrongChoice = choice;
	}
	public void showWrongChoice()
	{
		System.out.println(wrongChoice + "에 해당하는 선택은 존재하지 않습니다.");
	}
}
////////////////////////////////////////////////////////////

class PhoneBookManager2
{
	HashSet<PhoneInfo> infoStorage = new HashSet<PhoneInfo>();
	
	static PhoneBookManager2 inst =null;
	public static PhoneBookManager2 createManagerInst()
	{
		if(inst==null)
			inst = new PhoneBookManager2();
		
		return inst;
	}
	
	////////////////////////////////////////////////////
	
	private PhoneInfo Dataname()	//1-1번
	{
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"scott",
					"tiger");
			Statement stmt = con.createStatement();
			
			System.out.print("가게 이름 혹은 키워드를 적으세요 :");
			String name = MenuViewer2.keyboard.nextLine();

			
			StringBuffer sb = new StringBuffer();
			sb.append("select * from JAVAPROJECT where name like '%"+name+"%'");
			ResultSet rs = stmt.executeQuery(sb.toString());
			
			if(rs.next()) {
				int count = 0;
				System.out.print("가게 이름 : " + rs.getString("name")+ '\t');
				System.out.print("음식 종류 : " + rs.getString("food3")+ '\t');
				System.out.print("지역 : " + rs.getString("sido")+ '\t');
				System.out.print("시군구 : " + rs.getString("gigungu")+ '\t');
				System.out.print("평점 : " + rs.getString("jumgsu")+ '\t');		
				System.out.print("리뷰 인원 : " + rs.getString("avgjumg")+ '\t');
				System.out.println("설명 : " + rs.getString("data"));
				count++;
				while(rs.next()) 
			{
				System.out.print("가게 이름 : " + rs.getString("name")+ '\t');
				System.out.print("음식 종류 : " + rs.getString("food3")+ '\t');
				System.out.print("지역 : " + rs.getString("sido")+ '\t');
				System.out.print("시군구 : " + rs.getString("gigungu")+ '\t');
				System.out.print("평점 : " + rs.getString("jumgsu")+ '\t');		
				System.out.print("리뷰 인원 : " + rs.getString("avgjumg")+ '\t');
				System.out.println("설명 : " + rs.getString("data"));
				count++;
			}
				System.out.println("총 "+count+" 지점 입니다. \n");
			}else{
			throw new SQLException();
			}
			
			rs.close();
			stmt.close();
			con.close();
		}catch(SQLException sqle) {
			System.out.println("검색값이 존재하지 않습니다.");
		}
		return null;	
	}
	
	private PhoneInfo Datafood()	//1-2번

	{
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"scott",
					"tiger");
			Statement stmt = con.createStatement();
			
			System.out.println("예시 : 카페/전통찻집, 서양식, 아시아식, 채식, 한식, 중식, 일식, 패밀리레스토랑, 이색음식");		
			System.out.print("음식 종류를 적으세요 :");
			String name = MenuViewer2.keyboard.nextLine();

			
			StringBuffer sb = new StringBuffer();
			sb.append("select * from JAVAPROJECT where food3 like '%"+name+"%'");
			ResultSet rs = stmt.executeQuery(sb.toString());
		
			if(rs.next()) {
				int count = 0;
				System.out.print("가게 이름 : " + rs.getString("name")+ '\t');
				System.out.print("음식 종류 : " + rs.getString("food3")+ '\t');
				System.out.print("지역 : " + rs.getString("sido")+ '\t');
				System.out.print("시군구 : " + rs.getString("gigungu")+ '\t');
				System.out.print("평점 : " + rs.getString("jumgsu")+ '\t');		
				System.out.print("리뷰 인원 : " + rs.getString("avgjumg")+ '\t');
				System.out.println("설명 : " + rs.getString("data"));
				count++;
				while(rs.next()) 
			{
				System.out.print("가게 이름 : " + rs.getString("name")+ '\t');
				System.out.print("음식 종류 : " + rs.getString("food3")+ '\t');
				System.out.print("지역 : " + rs.getString("sido")+ '\t');
				System.out.print("시군구 : " + rs.getString("gigungu")+ '\t');
				System.out.print("평점 : " + rs.getString("jumgsu")+ '\t');		
				System.out.print("리뷰 인원 : " + rs.getString("avgjumg")+ '\t');
				System.out.println("설명 : " + rs.getString("data"));
				count++;
			}
				System.out.println("총 "+count+" 지점 입니다. \n");
			}else{
			throw new SQLException();
			}
				
			rs.close();
			stmt.close();
			con.close();
		}catch(SQLException sqle) {
			System.out.println("검색값이 존재하지 않습니다.");
		}	
		return null;
	}
	
	private PhoneInfo Datasido()	//1-3번
	{
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"scott",
					"tiger");
			Statement stmt = con.createStatement();
			
			System.out.print("도시를 적으세요 :");
			String name = MenuViewer2.keyboard.nextLine();
			
			System.out.print("시군구를 적으세요 :");
			String name2 = MenuViewer2.keyboard.nextLine();

			StringBuffer sb = new StringBuffer();
			sb.append("select * from JAVAPROJECT where SIDO like '%"+name+"%' and GIGUNGU like '%"+name2+"%'");
			ResultSet rs = stmt.executeQuery(sb.toString());

			if(rs.next()) {
				int count = 0;
				System.out.print("가게 이름 : " + rs.getString("name")+ '\t');
				System.out.print("음식 종류 : " + rs.getString("food3")+ '\t');
				System.out.print("지역 : " + rs.getString("sido")+ '\t');
				System.out.print("시군구 : " + rs.getString("gigungu")+ '\t');
				System.out.print("평점 : " + rs.getString("jumgsu")+ '\t');		
				System.out.print("리뷰 인원 : " + rs.getString("avgjumg")+ '\t');
				System.out.println("설명 : " + rs.getString("data"));
				count++;
				while(rs.next()) 
			{
				System.out.print("가게 이름 : " + rs.getString("name")+ '\t');
				System.out.print("음식 종류 : " + rs.getString("food3")+ '\t');
				System.out.print("지역 : " + rs.getString("sido")+ '\t');
				System.out.print("시군구 : " + rs.getString("gigungu")+ '\t');
				System.out.print("평점 : " + rs.getString("jumgsu")+ '\t');		
				System.out.print("리뷰 인원 : " + rs.getString("avgjumg")+ '\t');
				System.out.println("설명 : " + rs.getString("data"));
				count++;
			}
				System.out.println("총 "+count+" 지점 입니다. \n");
			}else{
			throw new SQLException();
			}
				
			rs.close();
			stmt.close();
			con.close();
		}catch(SQLException sqle) {
			System.out.println("검색값이 존재하지 않습니다.");
		}	
		return null;
	}
	
	private PhoneInfo Datagigungu() 	//1-4번
	{
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"scott",
					"tiger");
			Statement stmt = con.createStatement();
			
			System.out.print("점수를 줄 가게이름 :");
			String name = MenuViewer2.keyboard.nextLine();
			System.out.print("당신의 점수가 제작에 큰 도움이 됩니다(1~10점) :");
			int jumgsu = MenuViewer2.keyboard.nextInt();

			if(jumgsu <= 10 && jumgsu > 0) {
			StringBuffer sb = new StringBuffer();
			sb.append("update javaproject set jumgsu = round(((sumjumg+"+jumgsu+")/(avgjumg+1)), 2), avgjumg = (avgjumg+1), sumjumg = (sumjumg+"+jumgsu+") where name = '"+name+"'");
			ResultSet rs = stmt.executeQuery(sb.toString());
			rs.close();
			}else {
				System.out.println("잘못된 선택입니다.");
				System.out.println(jumgsu + "은 값의 범위를 벗어낫습니다");
				System.out.println("처음 메뉴로 돌아갑니다");
				return null;
			}			
			
			int rs = stmt.getUpdateCount();
			if(rs > 0) {
				System.out.println("평가해주셔서 감사합니다.  \n");
			}else {
				throw new SQLException();
			}
			
			stmt.close();
			con.close();
		}catch(SQLException sqle) {
			System.out.println("가게이름이 없습니다.");
		}	
		return null;
	}
	
	public void Data() throws MenuChoiceException	//1번 메뉴
	{
		System.out.println("데이터 검색을 시작합니다...");
		System.out.println("검색하실 종류를 선택하세요...");
		System.out.println("1.가게이름  2.음식 종류  3.지역  4.평점주기 ");
		System.out.print("선택>> ");
		int choice = MenuViewer2.keyboard.nextInt();
		MenuViewer2.keyboard.nextLine();
		PhoneInfo info = null;

		if(choice<INPUT_SERACHH.NAME || choice>INPUT_SERACHH.GIGUNGU)
			throw new MenuChoiceException(choice);
		
		switch(choice)
		{
		case INPUT_SERACHH.NAME :
			info=Dataname();
			break;
		case INPUT_SERACHH.FOOD :
			info=Datafood();
			break;
		case INPUT_SERACHH.SIDO :
			info=Datasido();
			break;
		case INPUT_SERACHH.GIGUNGU :
			info=Datagigungu();
			break;
		}
		}
	
///////////////////////////////////////////	ㅗㅗㅗㅗㅗ1.데이터 검색

}

class MenuViewer2
{
	public static Scanner keyboard = new Scanner(System.in);
	
	public static void showMenu()
	{
		System.out.println("사용자.ver");
		System.out.println("맛집리스트에 오신걸 환영합니다.");
		System.out.println("1. 데이터 검색");
		System.out.println("2. 데이터 입력");
		System.out.println("3. 프로그램 종료");
		System.out.print("선택 >> ");				
	}
}

class SaYoongJa {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}
	public static void main(String[] args) {


		PhoneBookManager2 manager = PhoneBookManager2.createManagerInst();
		int choice;
		
	
		
		while(true)
		{
			try
			{
				MenuViewer2.showMenu();
				choice = MenuViewer2.keyboard.nextInt();
				MenuViewer2.keyboard.nextLine();

				if(choice<INIT_MENUU.DATA || choice>INIT_MENUU.EXIT)
					throw new MenuChoiceException(choice);

				switch(choice)
				{
				case INIT_MENUU.DATA:
					manager.Data();
					break;
				case INIT_MENUU.INPUT:
					System.out.println("사용자는 권한이 없습니다. \n");
					break;
				case INIT_MENUU.EXIT:
					System.out.println("프로그랭을 종료합니다.");
					System.exit(0);
					return;
				}
			}
			catch(MenuChoiceException e)
			{
				e.showWrongChoice();
				System.out.println("메뉴 선택을 처음부터 다시 진행합니다. \n");
			}
		}
	}
}