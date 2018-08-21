//전화번호 관리 프로그램 구현 프로젝트
//version 0.7

import java.util.Scanner;
import java.util.HashSet;
import java.util.Iterator;

interface INIT_MENU3
{
	int INPUT =1, SEARCH =2, DELETE =3, EXIT =4;
}
interface INPUT_SELECT3
{
	int NORMAL =1, UNIV =2, COMPANY =3;
}

class MenuChoiceException2 extends Exception
{
	int wrongChoice;
	
	public MenuChoiceException2(int choice)
	{
		super("잘못된 선택이 이뤄졌습니다.");
		wrongChoice = choice;
	}
	public void showWrongChoice()
	{
		System.out.println(wrongChoice + "에 해당하는 선택은 존재하지 않습니다.");
	}
}

class PhoneInfo7{
	String name;
	String phoneNumber;
	
	public PhoneInfo7(String name, String num)
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
		PhoneInfo7 cmp = (PhoneInfo7)obj;
		if(name.compareTo(cmp.name)==0)
			return true;
		else
			return false;
	}
}

class PhoneUnivInfo4 extends PhoneInfo7
{
	String major;
	int year;
	
	public PhoneUnivInfo4(String name, String num, String major, int year)
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

class PhoneCompanyInfo4 extends PhoneInfo7
{
	String company;
	
	public PhoneCompanyInfo4(String name, String num, String company)
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


class PhoneBookManager7
{
//	final int MAX_CNT = 100;
//	PhoneInfo[] infoStorage = new PhoneInfo[MAX_CNT];
//	int curCnt =0;
	HashSet<PhoneInfo7> infoStorage = new HashSet<PhoneInfo7>();
	
	static PhoneBookManager7 inst =null;
	public static PhoneBookManager7 createManagerInst()
	{
		if(inst==null)
			inst = new PhoneBookManager7();
		
		return inst;
	}
	
	private PhoneBookManager7() {}
	
	private PhoneInfo7 readFriendInfo()
	{
		System.out.print("이름 : ");
		String name = MenuViewer5.keyboard.nextLine();
		System.out.print("전화번호 : ");
		String phone = MenuViewer5.keyboard.nextLine();
		return new PhoneInfo7(name, phone);
	}
	
	private PhoneInfo7 readUnivFriendInfo()
	{
		System.out.print("이름 : ");
		String name = MenuViewer5.keyboard.nextLine();
		System.out.print("전화번호 : ");
		String phone = MenuViewer5.keyboard.nextLine();
		System.out.print("전공 : ");
		String major = MenuViewer5.keyboard.nextLine();
		System.out.print("학년 : ");
		int year = MenuViewer5.keyboard.nextInt();
		MenuViewer5.keyboard.nextLine();
		return new PhoneUnivInfo4(name, phone, major, year);
	}
	
	private PhoneInfo7 readCompanyFriendInfo()
	{
		System.out.print("이름 : ");
		String name = MenuViewer5.keyboard.nextLine();
		System.out.print("전화번호 : ");
		String phone = MenuViewer5.keyboard.nextLine();
		System.out.print("회사 : ");
		String company = MenuViewer5.keyboard.nextLine();
		return new PhoneCompanyInfo4(name, phone, company);
	}
	
	public void inputData() throws MenuChoiceException2
	{
		System.out.println("데이터 입력을 시작합니다...");	
		System.out.println("1. 일반, 2.대학 , 3.회사 ");
		System.out.print("선택>> ");
		int choice = MenuViewer5.keyboard.nextInt();
		MenuViewer5.keyboard.nextLine();
		PhoneInfo7 info = null;
		
		if(choice<INPUT_SELECT3.NORMAL || choice>INPUT_SELECT3.COMPANY)
			throw new MenuChoiceException2(choice);
		
		switch(choice)
		{
		case INPUT_SELECT3.NORMAL :
			info=readFriendInfo();
			break;
		case INPUT_SELECT3.UNIV :
			info=readUnivFriendInfo();
			break;
		case INPUT_SELECT3.COMPANY :
			info=readCompanyFriendInfo();
			break;
		}
		
//		infoStorage[curCnt++] = info;
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
		String name = MenuViewer5.keyboard.nextLine();
		
//		int dataIdx = search(name);
//		if(dataIdx<0)
//		{
//			System.out.println("해당하는 데이터가 존재하지 않습니다. \n");
//		}
//		else
//		{
//			infoStorage[dataIdx].showPhoneInfo();
//			System.out.println("데이터 검색이 완료되엇습니다. \n");
//		}
		PhoneInfo7 info = search(name);
		if(info==null)
		{
			System.out.println("해당하는 데이터가 존재하지 않습니다. \n");
		}
		else
			info.showPhoneInfo();
			System.out.println("데이터 검색이 완료되었습니다. \n");
	}


	public void deleteData()
	{
		System.out.println("데이터 삭제를 시작합니다...");
		
		System.out.print("이름 : ");
		String name = MenuViewer5.keyboard.nextLine();
		
//		int dataIdx = search(name);
//		if(dataIdx <0)
//		{
//			System.out.println("해당하는 데이터가 존재하지 않습니다. \n");
//		}
//		else
//		{
//			for(int idx = dataIdx; idx<(curCnt-1); idx++)
//				infoStorage[idx]=infoStorage[idx+1];
//			
//			curCnt--;
//			System.out.println("데이터 삭제가 완료되었습니다. \n");
//		}
		Iterator<PhoneInfo7> itr = infoStorage.iterator();
		while(itr.hasNext())
		{
			PhoneInfo7 curInfo = itr.next();
			if(name.compareTo(curInfo.name)==0)
			{
				itr.remove();
				System.out.println("데이터 삭제가 완료되었습니다. \n");
				return;
			}
	}
		System.out.println("해당하는 데이터가 존재하지 않습니다. \n");
	}
	
	private PhoneInfo7 search(String name)
	{
//		for(int idx = 0; idx<curCnt; idx++)
//		{
//			PhoneInfo curInfo= infoStorage[idx];
//			if(name.compareTo(curInfo.name)==0)
//				return idx;
//		}
		Iterator<PhoneInfo7> itr = infoStorage.iterator();
		while(itr.hasNext())
		{
			PhoneInfo7 curInfo = itr.next();
			if(name.compareTo(curInfo.name)==0)
				return curInfo;
		}
		return null;
	}
}

class MenuViewer5
{
	public static Scanner keyboard = new Scanner(System.in);
	
	public static void showMenu()
	{
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데티어 삭제");
		System.out.println("4. 프로그램 종료");
		System.out.print("선택 :");				
	}
}

class PhoneBookVer07 {

	public static void main(String[] args) {


		PhoneBookManager7 manager = PhoneBookManager7.createManagerInst();
		int choice;
		
		while(true)
		{
			try
			{
				MenuViewer5.showMenu();
				choice = MenuViewer5.keyboard.nextInt();
				MenuViewer5.keyboard.nextLine();	//아래에서 설명
				
				if(choice<INIT_MENU3.INPUT || choice>INIT_MENU3.EXIT)
					throw new MenuChoiceException2(choice);

				switch(choice)
				{
				case INIT_MENU3.INPUT:
					manager.inputData();
					break;
				case INIT_MENU3.SEARCH:
					manager.searchData();
					break;
				case INIT_MENU3.DELETE:
					manager.deleteData();
					break;
				case INIT_MENU3.EXIT:
					System.out.println("프로그랭을 종료합니다.");
					return;
				}
			}
			catch(MenuChoiceException2 e)
			{
				e.showWrongChoice();
				System.out.println("메뉴 선택을 처음부터 다시 진행합니다. \n");
			}
		}
	}
}