//전화번호 관리 프로그램 구현 프로젝트
//version 0.9

import java.util.*;
import java.io.*;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

interface INIT_MENU	//초기 화면
{
	int DATA = 1, INPUT =2, EXIT =3;
}
interface INPUT_SELECT	//2.데이터 입력
{
	int NORMAL =1, UNIV =2, COMPANY =3;
}
interface INPUT_SERACH	//1.데이터 검색
{
	int NAME =1, FOOD =2, SIDO =3, JUMGSU =4, RANK = 5;
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
class MatZiplist implements Serializable{
	String name;
	String phoneNumber;
	
	public MatZiplist(String name, String num)
	{
		this.name = name;
		phoneNumber = num;
	}
	public void showPhoneInfo()
	{
		System.out.println("name : " + name);
		System.out.println("phone : " + phoneNumber);
	}
	public String toString()
	{
		return "name : " + name + '\n' + "phone : " + phoneNumber + '\n';
	}
	public int hashCode()
	{
		return name.hashCode();
	}
	public boolean equals(Object obj)
	{
		MatZiplist cmp = (MatZiplist)obj;
		if(name.compareTo(cmp.name)==0)
			return true;
		else
			return false;
	}
}


class MatZipManager
{
	HashSet<MatZiplist> infoStorage = new HashSet<MatZiplist>();
	
	static MatZipManager inst =null;
	public static MatZipManager createManagerInst()
	{
		if(inst==null)
			inst = new MatZipManager();
		
		return inst;
	}
	
	////////////////////////////////////////////////////
	private MatZiplist Addname()	//2-1번 데이터 추가 
	{
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"scott",
					"tiger");
			Statement stmt = con.createStatement();
			
			System.out.print("가게이름 :");
			String name = MenuViewer.keyboard.nextLine();
			System.out.print("음식종류 :");
			String food3 = MenuViewer.keyboard.nextLine();
			System.out.print("지역 :");
			String sido = MenuViewer.keyboard.nextLine();
			System.out.print("시군구 :");
			String gigungu = MenuViewer.keyboard.nextLine();
			System.out.print("내용 :");
			String data = MenuViewer.keyboard.nextLine();
		
			StringBuffer sb = new StringBuffer();
			sb.append("insert into JAVAPROJECT values('"+name+"', '"+food3+"', '"+sido+"', '"+gigungu+"', '"+data+"', '0','0','0')");		
			ResultSet rs = stmt.executeQuery(sb.toString());
			
			int rss = stmt.getUpdateCount();
			if(rss > 0) {
				System.out.println("성공적으로 가게를 생성하였습니다.  \n");
			}else {
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

	private MatZiplist Sujungname()	//2-2번 데이터 수정
	{
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"scott",
					"tiger");

			System.out.print("수정하고 싶은 가게이름 :");
			String name = MenuViewer.keyboard.nextLine();
			System.out.print("수정할 가게이름 :");
			String select = MenuViewer.keyboard.nextLine();
			System.out.print("수정할 음식종류 :");
			String select2 = MenuViewer.keyboard.nextLine();
			System.out.print("수정할 지역 :");
			String select3 = MenuViewer.keyboard.nextLine();
			System.out.print("수정할 시군구 :");
			String select4 = MenuViewer.keyboard.nextLine();
			System.out.print("수정할 내용 :");
			String select5 = MenuViewer.keyboard.nextLine();	

			Statement stmt = con.createStatement();
			StringBuffer sb = new StringBuffer();
			sb.append("update javaproject set name = '"+select+"', food3 = '"+select2+"', sido = '"+select3+"', gigungu = '"+select4+"', data = '"+select5+"' where name = '"+name+"'");
			con.commit();
			stmt.executeUpdate(sb.toString());
			
			int rs = stmt.getUpdateCount();
			if(rs > 0) {
				System.out.println("성공적으로 수정에 성공했습니다.  \n");
			}else {
				throw new SQLException();
			}
			
			stmt.close();
			con.close();
		}catch(SQLException sqle) {
			System.out.println("검색값이 존재하지 않습니다.");
		}
		return null;	
	}
	
	private MatZiplist Delname()	//2-3번 데이터 삭제 
	{
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"scott",
					"tiger");

			System.out.print("가게이름 :");
			String name = MenuViewer.keyboard.nextLine();
		
			Statement stmt = con.createStatement();
			StringBuffer sb = new StringBuffer();
			sb.append("delete from JAVAPROJECT where name = '"+name+"'");	
			stmt.executeUpdate(sb.toString());
			
			int rs = stmt.getUpdateCount();
			if(rs > 0) {
				System.out.println("성공적으로 삭제를 완료하였습니다.  \n");
			}else {
				throw new SQLException();
			}
			
			stmt.close();
			con.close();
		}catch(SQLException sqle) {
			System.out.println("검색값이 존재하지 않습니다.");
		}
		return null;	
	}
	
	public void inputData() throws MenuChoiceException	//2번 메뉴
	{
		System.out.println("데이터 입력을 시작합니다...");	
		System.out.println("1.추가, 2.수정, 3.삭제 ");
		System.out.print("선택>> ");
		int choice = MenuViewer.keyboard.nextInt();
		MenuViewer.keyboard.nextLine();
		MatZiplist info = null;
		
		if(choice<INPUT_SELECT.NORMAL || choice>INPUT_SELECT.COMPANY)
			throw new MenuChoiceException(choice);
		
		switch(choice)
		{
		case INPUT_SELECT.NORMAL :
			info=Addname();
			break;
		case INPUT_SELECT.UNIV :
			info=Sujungname();
			break;
		case INPUT_SELECT.COMPANY :
			info=Delname();
			break;
		}
		
//		boolean isAdded = infoStorage.add(info);
//		if(isAdded == true)
//			System.out.println("데이터 입력이 완료되었습니다. \n");
//		else
//			System.out.println("잘못된 데이터 입니다. \n");
	}
//////////////////////////////////////////// ㅜㅜㅜㅜㅜㅜ1.데이터 검색	
	
	private MatZiplist Dataname()	//1-1번 가게이름
	{
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"scott",
					"tiger");
			Statement stmt = con.createStatement();
			
			System.out.print("가게 이름 혹은 키워드를 적으세요 :");
			String name = MenuViewer.keyboard.nextLine();

			
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
				System.out.print("평점 인원 : " + rs.getString("avgjumg")+ '\t');
				System.out.println("설명 : " + rs.getString("data"));
				count++;
				while(rs.next()) 
			{
				System.out.print("가게 이름 : " + rs.getString("name")+ '\t');
				System.out.print("음식 종류 : " + rs.getString("food3")+ '\t');
				System.out.print("지역 : " + rs.getString("sido")+ '\t');
				System.out.print("시군구 : " + rs.getString("gigungu")+ '\t');
				System.out.print("평점 : " + rs.getString("jumgsu")+ '\t');		
				System.out.print("평점 인원 : " + rs.getString("avgjumg")+ '\t');
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
	
	private MatZiplist Datafood()	//1-2번 음식 종류

	{
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"scott",
					"tiger");
			Statement stmt = con.createStatement();
			
			System.out.println("예시 : 카페/전통찻집, 서양식, 아시아식, 채식, 한식, 중식, 일식, 패밀리레스토랑, 이색음식");		
			System.out.print("음식 종류를 적으세요 :");
			String name = MenuViewer.keyboard.nextLine();

			
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
				System.out.print("평점 인원 : " + rs.getString("avgjumg")+ '\t');
				System.out.println("설명 : " + rs.getString("data"));
				count++;
				while(rs.next()) 
			{
				System.out.print("가게 이름 : " + rs.getString("name")+ '\t');
				System.out.print("음식 종류 : " + rs.getString("food3")+ '\t');
				System.out.print("지역 : " + rs.getString("sido")+ '\t');
				System.out.print("시군구 : " + rs.getString("gigungu")+ '\t');
				System.out.print("평점 : " + rs.getString("jumgsu")+ '\t');		
				System.out.print("평점 인원 : " + rs.getString("avgjumg")+ '\t');
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
	

	private MatZiplist Datasido()	//1-3번 지역
	{
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"scott",
					"tiger");
			Statement stmt = con.createStatement();
			
			System.out.print("도시를 적으세요 :");
			String name = MenuViewer.keyboard.nextLine();
			
			System.out.print("시군구를 적으세요 :");
			String name2 = MenuViewer.keyboard.nextLine();

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
				System.out.print("평점 인원 : " + rs.getString("avgjumg")+ '\t');
				System.out.println("설명 : " + rs.getString("data"));
				count++;
				while(rs.next()) 
			{
				System.out.print("가게 이름 : " + rs.getString("name")+ '\t');
				System.out.print("음식 종류 : " + rs.getString("food3")+ '\t');
				System.out.print("지역 : " + rs.getString("sido")+ '\t');
				System.out.print("시군구 : " + rs.getString("gigungu")+ '\t');
				System.out.print("평점 : " + rs.getString("jumgsu")+ '\t');		
				System.out.print("평점 인원 : " + rs.getString("avgjumg")+ '\t');
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
	

	private MatZiplist Datajumgsu() //1-4번 평점 주기
	{
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"scott",
					"tiger");
			Statement stmt = con.createStatement();
			
			System.out.print("점수를 줄 가게이름 :");
			String name = MenuViewer.keyboard.nextLine();
			System.out.print("당신의 점수가 제작에 큰 도움이 됩니다(1~10점) :");
			int jumgsu = MenuViewer.keyboard.nextInt();

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
	

	private MatZiplist Datarank() 	//1-5번 평점 랭킹
	{
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"scott",
					"tiger");
			Statement stmt = con.createStatement();
			
			StringBuffer sb = new StringBuffer();
			sb.append("select * from javaproject where avgjumg>0 order by jumgsu desc");
			ResultSet rs = stmt.executeQuery(sb.toString());
			if(rs.next()) {
				int count = 0;
				System.out.print("가게 이름 : " + rs.getString("name")+ '\t');
				System.out.print("평점 : " + rs.getString("jumgsu")+ '\t');		
				System.out.print("평점 인원 : " + rs.getString("avgjumg")+ '\n');
				count++;
				while(rs.next()) 
			{
				System.out.print("가게 이름 : " + rs.getString("name")+ '\t');
				System.out.print("평점 : " + rs.getString("jumgsu")+ '\t');		
				System.out.print("평점 인원 : " + rs.getString("avgjumg")+ '\n');
				count++;
			}
				System.out.println("총 "+count+" 지점 입니다. \n");
				System.out.println("표기조건 : 최소 1명이상 평점");
			}
			rs.close();
			stmt.close();
			con.close();
		}catch(SQLException sqle) {
			System.out.println("랭킹이 잘못댔습니다.");
		}	
		return null;
	}
	
	public void Data() throws MenuChoiceException	//1번 메뉴
	{
		System.out.println("데이터 검색을 시작합니다...");
		System.out.println("검색하실 종류를 선택하세요...");
		System.out.println("1.가게이름  2.음식 종류  3.지역  4.평점주기 5.평점랭킹");
		System.out.print("선택>> ");
		int choice = MenuViewer.keyboard.nextInt();
		MenuViewer.keyboard.nextLine();
		MatZiplist info = null;

		if(choice<INPUT_SERACH.NAME || choice>INPUT_SERACH.RANK)
			throw new MenuChoiceException(choice);
		
		switch(choice)
		{
		case INPUT_SERACH.NAME :
			info=Dataname();
			break;
		case INPUT_SERACH.FOOD :
			info=Datafood();
			break;
		case INPUT_SERACH.SIDO :
			info=Datasido();
			break;
		case INPUT_SERACH.JUMGSU :
			info=Datajumgsu();
			break;
		case INPUT_SERACH.RANK :
			info=Datarank();
			break;
			
		}
		}
	
///////////////////////////////////////////	ㅗㅗㅗㅗㅗ1.데이터 검색

}

class MenuViewer
{
	public static Scanner keyboard = new Scanner(System.in);
	
	public static void showMenu()
	{
		System.out.println("관리자.ver");
		System.out.println("맛집리스트에 오신걸 환영합니다.");
		System.out.println("1. 데이터 검색");
		System.out.println("2. 데이터 입력");
		System.out.println("3. 프로그램 종료");
		System.out.print("선택 >> ");				
	}
}

//class SearchEventHandler implements ActionListener	//gui 서칭 도구
//{
////	JTextField searchField;
////	JTextArea textArea;
//	
//	public SearchEventHandler(JTextField field, JTextArea area)
//	{
////		searchField = field;
////		textArea = area;
//	}
//	public void actionPerformed(ActionEvent e)
//	{
////		String name = searchField.getText();
////		PhoneBookManager manager = PhoneBookManager.createManagerInst();
////		String srchResult = manager.guiname(name);
////		if(srchResult != null)
////		{
////			textArea.append("해당하는 데이터가 존재하지 않습니다. \n");
////		}
////		else
////		{
////			textArea.append("찾으시는 정보를 알려드립니다. \n");
////			textArea.append(srchResult);
////			textArea.append("\n");
////			textArea.append(name);
////
////		}
//	}
//}
//
//class DeleteEventHandler implements ActionListener	//gui 삭제 도구
//{
////	JTextField delField;
////	JTextArea textArea;
//	
//	public DeleteEventHandler(JTextField field, JTextArea area)
//	{
////		delField = field;
////		textArea = area;
//	}
//	public void actionPerformed(ActionEvent e)
//	{
////		String name = delField.getText();
////		PhoneBookManager manager = PhoneBookManager.createManagerInst();
////		boolean isDeleted = manager.deleteData(name);
////		if(isDeleted)
////			textArea.append("데이터 삭제를 완료하였습니다. \n");
////		else
////			textArea.append("해당하는 데이터가 존재하지 않습니다. \n");
//	}
//}

//class SearchDelFrame extends JFrame		//gui 버튼 도구
//{
//
////	JTextField srchField = new JTextField(15);
////	JButton srchBtn = new JButton("SEARCH");
////	
////	JTextField delField = new JTextField(15);
////	JButton delBtn = new JButton("DEL");
////	
////	JTextArea textArea = new JTextArea(20,25);
//
//	public SearchDelFrame()			///gui
//	{
////		super("PhoneBookVer09");
////		setBounds(100,200,330,450);
////		setLayout(new BorderLayout());
////		Border border = BorderFactory.createEtchedBorder();
////		
////
////		Border srchBorder = BorderFactory.createTitledBorder(border,"Search");
////		JPanel srchPanel = new JPanel();
////		srchPanel.setBorder(srchBorder);
////		srchPanel.setLayout(new FlowLayout());
////		srchPanel.add(srchField);
////		srchPanel.add(srchBtn);
////		
////		Border delBorder = BorderFactory.createTitledBorder(border,"Delete");
////		JPanel delPanel = new JPanel();
////		delPanel.setBorder(delBorder);
////		delPanel.setLayout(new FlowLayout());
////		delPanel.add(delField);
////		delPanel.add(delBtn);
////		
////		JScrollPane scrollTextArea = new JScrollPane(textArea);
////		Border textBorder = BorderFactory.createTitledBorder(border,"Infomation Board");
////		scrollTextArea.setBorder(textBorder);
////
////		add(srchPanel, BorderLayout.NORTH);
////		add(delPanel, BorderLayout.SOUTH);
////		add(scrollTextArea, BorderLayout.CENTER);
////		
////		srchBtn.addActionListener(new SearchEventHandler(srchField, textArea));
////		delBtn.addActionListener(new DeleteEventHandler(delField, textArea));
////		
////		setVisible(true);
////		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//	}
//}

class KwanRiJa {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}
	public static void main(String[] args) {


		MatZipManager manager = MatZipManager.createManagerInst();
		int choice;
		
	
		
		while(true)
		{
			try
			{
				MenuViewer.showMenu();
				choice = MenuViewer.keyboard.nextInt();
				MenuViewer.keyboard.nextLine();

				if(choice<INIT_MENU.DATA || choice>INIT_MENU.EXIT)
					throw new MenuChoiceException(choice);

				switch(choice)
				{
				case INIT_MENU.DATA:
					manager.Data();
					break;
				case INIT_MENU.INPUT:
					manager.inputData();
					break;
				case INIT_MENU.EXIT:
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