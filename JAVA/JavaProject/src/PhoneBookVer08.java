//전화번호 관리 프로그램 구현 프로젝트
//version 0.8

import java.util.Scanner;
import java.util.HashSet;
import java.util.Iterator;
import java.io.*;

interface INIT_MENU5
{
	int INPUT =1, SEARCH =2, DELETE =3, EXIT =4;
}
interface INPUT_SELECT5
{
	int NORMAL =1, UNIV =2, COMPANY =3;
}

class MenuChoiceException3 extends Exception
{
	int wrongChoice;
	
	public MenuChoiceException3(int choice)
	{
		super("잘못된 선택이 이뤄졌습니다.");
		wrongChoice = choice;
	}
	public void showWrongChoice()
	{
		System.out.println(wrongChoice + "에 해당하는 선택은 존재하지 않습니다.");
	}
}

class PhoneInfo8 implements Serializable{
	String name;
	String phoneNumber;
	
	public PhoneInfo8(String name, String num)
	{
		this.name = name;
		phoneNumber = num;
	}
	public void showPhoneInfo()
	{
		System.out.println("name : " + name);
		System.out.println("phone : " + phoneNumber);
	}
	public int hashCode()
	{
		return name.hashCode();
	}
	public boolean equals(Object obj)
	{
		PhoneInfo8 cmp = (PhoneInfo8)obj;
		if(name.compareTo(cmp.name)==0)
			return true;
		else
			return false;
	}
}

class PhoneUnivInfo5 extends PhoneInfo8
{
	String major;
	int year;
	
	public PhoneUnivInfo5(String name, String num, String major, int year)
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
}

class PhoneCompanyInfo5 extends PhoneInfo8
{
	String company;
	
	public PhoneCompanyInfo5(String name, String num, String company)
	{
		super(name, num);
		this.company=company;
	}
	public void showPhoneInfo()
	{
	super.showPhoneInfo();
	System.out.println("company : " + company);
	}
}


class PhoneBookManager8
{
	private final File dataFile = new File("PhoneBook.dat");
	HashSet<PhoneInfo8> infoStorage = new HashSet<PhoneInfo8>();
	
	static PhoneBookManager8 inst =null;
	public static PhoneBookManager8 createManagerInst()
	{
		if(inst==null)
			inst = new PhoneBookManager8();
		
		return inst;
	}
	
	private PhoneBookManager8() 
	{
		readFromFile();
	}
	
	private PhoneInfo8 readFriendInfo()
	{
		System.out.print("이름 : ");
		String name = MenuViewer6.keyboard.nextLine();
		System.out.print("전화번호 : ");
		String phone = MenuViewer6.keyboard.nextLine();
		return new PhoneInfo8(name, phone);
	}
	
	private PhoneInfo8 readUnivFriendInfo()
	{
		System.out.print("이름 : ");
		String name = MenuViewer6.keyboard.nextLine();
		System.out.print("전화번호 : ");
		String phone = MenuViewer6.keyboard.nextLine();
		System.out.print("전공 : ");
		String major = MenuViewer6.keyboard.nextLine();
		System.out.print("학년 : ");
		int year = MenuViewer6.keyboard.nextInt();
		MenuViewer6.keyboard.nextLine();
		return new PhoneUnivInfo5(name, phone, major, year);
	}
	
	private PhoneInfo8 readCompanyFriendInfo()
	{
		System.out.print("이름 : ");
		String name = MenuViewer6.keyboard.nextLine();
		System.out.print("전화번호 : ");
		String phone = MenuViewer6.keyboard.nextLine();
		System.out.print("회사 : ");
		String company = MenuViewer6.keyboard.nextLine();
		return new PhoneCompanyInfo5(name, phone, company);
	}
	
	public void inputData() throws MenuChoiceException3
	{
		System.out.println("데이터 입력을 시작합니다...");	
		System.out.println("1. 일반, 2.대학 , 3.회사 ");
		System.out.print("선택>> ");
		int choice = MenuViewer6.keyboard.nextInt();
		MenuViewer6.keyboard.nextLine();
		PhoneInfo8 info = null;
		
		if(choice<INPUT_SELECT5.NORMAL || choice>INPUT_SELECT5.COMPANY)
			throw new MenuChoiceException3(choice);
		
		switch(choice)
		{
		case INPUT_SELECT5.NORMAL :
			info=readFriendInfo();
			break;
		case INPUT_SELECT5.UNIV :
			info=readUnivFriendInfo();
			break;
		case INPUT_SELECT5.COMPANY :
			info=readCompanyFriendInfo();
			break;
		}
		
		boolean isAdded = infoStorage.add(info);
		if(isAdded == true)
			System.out.println("데이터 입력이 완료되었습니다. \n");
		else
			System.out.println("이미 저장된 데이터 입니다. \n");
	}
	
	public void searchData()
	{
		System.out.println("데이터 검색을 시작합니다...");
		
		System.out.print("이름 : ");
		String name = MenuViewer6.keyboard.nextLine();
		
		PhoneInfo8 info = search(name);
		if(info==null)
		{
			System.out.println("해당하는 데이터가 존재하지 않습니다. \n");
		}
		else
		{
			info.showPhoneInfo();
			System.out.println("데이터 검색이 완료되었습니다. \n");
		}
	}

	public void deleteData()
	{
		System.out.println("데이터 삭제를 시작합니다...");
		
		System.out.print("이름 : ");
		String name = MenuViewer6.keyboard.nextLine();
		
		Iterator<PhoneInfo8> itr = infoStorage.iterator();
		while(itr.hasNext())
		{
			PhoneInfo8 curInfo = itr.next();
			if(name.compareTo(curInfo.name)==0)
			{
				itr.remove();
				System.out.println("데이터 삭제가 완료되었습니다. \n");
				return;
			}
	}
		System.out.println("해당하는 데이터가 존재하지 않습니다. \n");
	}
	
	private PhoneInfo8 search(String name)
	{
		Iterator<PhoneInfo8> itr = infoStorage.iterator();
		while(itr.hasNext())
		{
			PhoneInfo8 curInfo = itr.next();
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
		
		Iterator<PhoneInfo8> itr = infoStorage.iterator();
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
			PhoneInfo8 info = (PhoneInfo8)in.readObject();
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

class MenuViewer6
{
	public static Scanner keyboard = new Scanner(System.in);
	
	public static void showMenu2()
	{
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데티어 삭제");
		System.out.println("4. 프로그램 종료");
		System.out.print("선택 :");				
	}
}

class PhoneBookVer08 {

	public static void main(String[] args) {


		PhoneBookManager8 manager = PhoneBookManager8.createManagerInst();
		int choice;
		
		while(true)
		{
			try
			{
				MenuViewer6.showMenu2();
				choice = MenuViewer6.keyboard.nextInt();
				MenuViewer6.keyboard.nextLine();	//아래에서 설명
				
				if(choice<INIT_MENU5.INPUT || choice>INIT_MENU5.EXIT)
					throw new MenuChoiceException3(choice);

				switch(choice)
				{
				case INIT_MENU5.INPUT:
					manager.inputData();
					break;
				case INIT_MENU5.SEARCH:
					manager.searchData();
					break;
				case INIT_MENU5.DELETE:
					manager.deleteData();
					break;
				case INIT_MENU5.EXIT:
					manager.storeToFile();
					System.out.println("프로그랭을 종료합니다.");
					return;
				}
			}
			catch(MenuChoiceException3 e)
			{
				e.showWrongChoice();
				System.out.println("메뉴 선택을 처음부터 다시 진행합니다. \n");
			}
		}
	}
}