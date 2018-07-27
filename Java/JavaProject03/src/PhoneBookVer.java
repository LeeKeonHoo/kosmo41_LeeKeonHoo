//전화번호 관리 프로그램 구현 프로젝트
//version 0.9

import java.util.Scanner;
import java.util.HashSet;
import java.util.Iterator;
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
	int NAME =1, FOOD =2, SIDO =3, GIGUNGU =4;
}
class MenuChoiceException extends Exception
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
class PhoneInfo implements Serializable{
	String name;
	String phoneNumber;
	
	public PhoneInfo(String name, String num)
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
		PhoneInfo cmp = (PhoneInfo)obj;
		if(name.compareTo(cmp.name)==0)
			return true;
		else
			return false;
	}
}

class PhoneUnivInfo extends PhoneInfo
{
	String major;
	String year;
	
	public PhoneUnivInfo(String name, String num, String major, String year)
	/////////////////////////////
	{
		super(name, num);
		this.major=major;
		this.year=year;
	}
	public void showPhoneInfo()
	{
		super.showPhoneInfo();
		System.out.println("major : " + major);
		System.out.println("year : " + year);
	}
	public String toString()
	{
		return super.toString()
				+ "major : " + major + '\n' + "year : " + year + '\n';
	}
}

class PhoneCompanyInfo extends PhoneInfo
{
	String company;
	
	public PhoneCompanyInfo(String name, String num, String company)
	{
		super(name, num);
		this.company=company;
	}
	public void showPhoneInfo()
	{
	super.showPhoneInfo();
	System.out.println("company : " + company);
	}
	public String toString()
	{
		return super.toString()
				+ "company : " + company + '\n';
	}
}


class PhoneBookManager
{
	private final File dataFile = new File("PhoneBook.dat");	//저장파일
	HashSet<PhoneInfo> infoStorage = new HashSet<PhoneInfo>();
	
	static PhoneBookManager inst =null;
	public static PhoneBookManager createManagerInst()
	{
		if(inst==null)
			inst = new PhoneBookManager();
		
		return inst;
	}
	
	private PhoneBookManager() 
	{
		readFromFile();
	}
	
	////////////////////////////////////////////////////
	private PhoneInfo Addname()	//2-1번 데이터 추가 
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
			sb.append("insert into JAVAPROJECT values('"+name+"', '"+food3+"', '"+sido+"', '"+gigungu+"', '"+data+"', '')");
			
			ResultSet rs = stmt.executeQuery(sb.toString());

			rs.close();
			stmt.close();
			con.close();
		}catch(SQLException sqle) {
			System.out.println("검색값이 존재하지 않습니다.");
			sqle.printStackTrace();
		}
		return null;	
	}

	private PhoneInfo Sujungname()	//2-2번 데이터 수정
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
						
			stmt.close();
			con.close();
		}catch(SQLException sqle) {
			System.out.println("검색값이 존재하지 않습니다.");
			sqle.printStackTrace();
		}
		return null;	
	}
	
	private PhoneInfo Delname()	//2-3번 데이터 삭제 
	{
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"scott",
					"tiger");

			System.out.print("가게이름 :");
			String name = MenuViewer.keyboard.nextLine();
			
//			System.out.println("[" + name + "]");
//			System.out.println("''''''''");
//			String sql = "delete from JAVAPROJECT2 where name = '"+name+"'";
			
			Statement stmt = con.createStatement();
			StringBuffer sb = new StringBuffer();
			sb.append("delete from JAVAPROJECT where name = '"+name+"'");	
			stmt.executeUpdate(sb.toString());
			
			stmt.close();
			con.close();
		}catch(SQLException sqle) {
			System.out.println("검색값이 존재하지 않습니다.");
			sqle.printStackTrace();
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
		PhoneInfo info = null;
		
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
		
		boolean isAdded = infoStorage.add(info);
		if(isAdded == true)
			System.out.println("데이터 입력이 완료되었습니다. \n");
		else
			System.out.println("이미 저장된 데이터 입니다. \n");
	}
//////////////////////////////////////////// ㅜㅜㅜㅜㅜㅜ1.데이터 검색	
	private PhoneInfo Dataname()	//1-1번
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
			while(rs.next()) {
				System.out.print("가게 이름 : " + rs.getString("name")+ '\t');
				System.out.print("음식 종류 : " + rs.getString("food3")+ '\t');
				System.out.print("지역 : " + rs.getString("sido")+ '\t');
				System.out.print("시군구 : " + rs.getString("gigungu")+ '\t');
				System.out.print("설명 : " + rs.getString("data")+ '\t');
				System.out.println("평점 : " + rs.getString("jumgsu"));				
			}
			
			rs.close();
			stmt.close();
			con.close();
		}catch(SQLException sqle) {
			System.out.println("검색값이 존재하지 않습니다.");
			sqle.printStackTrace();
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
			String name = MenuViewer.keyboard.nextLine();

			
			StringBuffer sb = new StringBuffer();
			sb.append("select * from JAVAPROJECT where food3 like '%"+name+"%'");
			
			ResultSet rs = stmt.executeQuery(sb.toString());
			while(rs.next()) {
				System.out.print("가게 이름 : " + rs.getString("name")+ '\t');
				System.out.print("음식 종류 : " + rs.getString("food3")+ '\t');
				System.out.print("지역 : " + rs.getString("sido")+ '\t');
				System.out.print("시군구 : " + rs.getString("gigungu")+ '\t');
				System.out.print("설명 : " + rs.getString("data")+ '\t');
				System.out.println("평점 : " + rs.getString("jumgsu"));
			}
			
			rs.close();
			stmt.close();
			con.close();
		}catch(SQLException sqle) {
			System.out.println("Connection Error");
			sqle.printStackTrace();
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
			String name = MenuViewer.keyboard.nextLine();
			
			System.out.print("시군구를 적으세요 :");
			String name2 = MenuViewer.keyboard.nextLine();

			StringBuffer sb = new StringBuffer();
			sb.append("select * from JAVAPROJECT where SIDO like '%"+name+"%' and GIGUNGU like '%"+name2+"%'");
			
			ResultSet rs = stmt.executeQuery(sb.toString());
			while(rs.next()) {
				System.out.print("가게 이름 : " + rs.getString("name")+ '\t');
				System.out.print("음식 종류 : " + rs.getString("food3")+ '\t');
				System.out.print("지역 : " + rs.getString("sido")+ '\t');
				System.out.print("시군구 : " + rs.getString("gigungu")+ '\t');
				System.out.print("설명 : " + rs.getString("data")+ '\t');
				System.out.println("평점 : " + rs.getString("jumgsu"));
			}
			
			rs.close();
			stmt.close();
			con.close();
		}catch(SQLException sqle) {
			System.out.println("Connection Error");
			sqle.printStackTrace();
		}	
		return null;
	}
	
	private PhoneInfo Datagigungu()	//1-4번
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
			String jumgsu = MenuViewer.keyboard.nextLine();

			StringBuffer sb = new StringBuffer();
			sb.append("update javaproject2 set jumgsu = (jumgsu+'"+jumgsu+"')/2 where name = '"+name+"'");
			
			ResultSet rs = stmt.executeQuery(sb.toString());

			
			rs.close();
			stmt.close();
			con.close();
		}catch(SQLException sqle) {
			System.out.println("점수범위가 아닙니다.");
			sqle.printStackTrace();
		}	
		return null;
	}
	
	public void Data() throws MenuChoiceException	//1번 메뉴
	{
		System.out.println("데이터 검색을 시작합니다...");
		System.out.println("검색하실 종류를 선택하세요...");
		System.out.println("1.가게이름  2.음식 종류  3.지역  4.평점주기 ");
		System.out.print("선택>> ");
		int choice = MenuViewer.keyboard.nextInt();
		MenuViewer.keyboard.nextLine();
		PhoneInfo info = null;

		if(choice<INPUT_SERACH.NAME || choice>INPUT_SERACH.GIGUNGU)
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
		case INPUT_SERACH.GIGUNGU :
			info=Datagigungu();
			break;
		}
		}
	
///////////////////////////////////////////	ㅗㅗㅗㅗㅗ1.데이터 검색
	public String searchData(String name)
	{
		PhoneInfo info = search(name);
		if(info==null)
			return null;
		else
			return info.toString();
	}

	public boolean deleteData(String name)
	{
		Iterator<PhoneInfo> itr = infoStorage.iterator();
		while(itr.hasNext())
		{
			PhoneInfo curInfo = itr.next();
			if(name.compareTo(curInfo.name)==0)
			{
				itr.remove();
				return true;
			}
		}
		return false;
	}
	
	private PhoneInfo search(String name)
	{
		Iterator<PhoneInfo> itr = infoStorage.iterator();
		while(itr.hasNext())
		{
			PhoneInfo curInfo = itr.next();
			if(name.compareTo(curInfo.name)==0)
				return curInfo;
		}
		return null;
	}


public void storeToFile()
{
	try 
	{
		FileOutputStream file = new FileOutputStream(dataFile);
		ObjectOutputStream out = new ObjectOutputStream(file);
		
		Iterator<PhoneInfo> itr = infoStorage.iterator();
		while(itr.hasNext())
			out.writeObject(itr.next());
		
		out.close();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
}

public void readFromFile()
{
	if(dataFile.exists()==false)
		return;
	try 
	{
		FileInputStream file = new FileInputStream(dataFile);
		ObjectInputStream in = new ObjectInputStream(file);
		
		while(true)
		{
			PhoneInfo info = (PhoneInfo)in.readObject();
			if(info == null)
				break;
			infoStorage.add(info);
		}
		in.close();
	}
	catch(IOException e)
	{
		return;
	}
	catch(ClassNotFoundException e)
	{
		return;
	}
}
}

class MenuViewer
{
	public static Scanner keyboard = new Scanner(System.in);
	
	public static void showMenu()
	{
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 검색");
		System.out.println("2. 데이터 입력");
		System.out.println("3. 프로그램 종료");
		System.out.print("선택 :");				
	}
}

class SearchEventHandler implements ActionListener
{
	JTextField searchField;
	JTextArea textArea;
	
	public SearchEventHandler(JTextField field, JTextArea area)
	{
		searchField = field;
		textArea = area;
	}
	public void actionPerformed(ActionEvent e)
	{
		String name = searchField.getText();
		PhoneBookManager manager = PhoneBookManager.createManagerInst();
		String srchResult = manager.searchData(name);
		if(srchResult == null)
		{
			textArea.append("해당하는 데이터가 존재하지 않습니다. \n");
		}
		else
		{
			textArea.append("찾으시는 정보를 알려드립니다. \n");
			textArea.append(srchResult);
			textArea.append("\n");
		}
	}
}

class DeleteEventHandler implements ActionListener
{
	JTextField delField;
	JTextArea textArea;
	
	public DeleteEventHandler(JTextField field, JTextArea area)
	{
		delField = field;
		textArea = area;
	}
	public void actionPerformed(ActionEvent e)
	{
		String name = delField.getText();
		PhoneBookManager manager = PhoneBookManager.createManagerInst();
		boolean isDeleted = manager.deleteData(name);
		if(isDeleted)
			textArea.append("데이터 삭제를 완료하였습니다. \n");
		else
			textArea.append("해당하는 데이터가 존재하지 않습니다. \n");
	}
}

class SearchDelFrame extends JFrame
{
	JTextField srchField = new JTextField(15);
	JButton srchBtn = new JButton("SEARCH");
	
	JTextField delField = new JTextField(15);
	JButton delBtn = new JButton("DEL");
	
	JTextArea textArea = new JTextArea(20,25);
	
	public SearchDelFrame()
	{
//		super("PhoneBookVer09");
//		setBounds(100,200,330,450);
//		setLayout(new BorderLayout());
//		Border border = BorderFactory.createEtchedBorder();
//		
//		Border srchBorder = BorderFactory.createTitledBorder(border,"Search");
//		JPanel srchPanel = new JPanel();
//		srchPanel.setBorder(srchBorder);
//		srchPanel.setLayout(new FlowLayout());
//		srchPanel.add(srchField);
//		srchPanel.add(srchBtn);
//		
//		Border delBorder = BorderFactory.createTitledBorder(border,"Delete");
//		JPanel delPanel = new JPanel();
//		delPanel.setBorder(delBorder);
//		delPanel.setLayout(new FlowLayout());
//		delPanel.add(delField);
//		delPanel.add(delBtn);
//		
//		JScrollPane scrollTextArea = new JScrollPane(textArea);
//		Border textBorder = BorderFactory.createTitledBorder(border,"Infomation Board");
//		scrollTextArea.setBorder(textBorder);
//		
//		add(srchPanel, BorderLayout.NORTH);
//		add(delPanel, BorderLayout.SOUTH);
//		add(scrollTextArea, BorderLayout.CENTER);
//		
//		srchBtn.addActionListener(new SearchEventHandler(srchField, textArea));
//		delBtn.addActionListener(new DeleteEventHandler(delField, textArea));
//		
//		setVisible(true);
//		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
}

class PhoneBookVer {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}
	public static void main(String[] args) {


		PhoneBookManager manager = PhoneBookManager.createManagerInst();
		SearchDelFrame winFrame = new SearchDelFrame();
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
					manager.storeToFile();
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