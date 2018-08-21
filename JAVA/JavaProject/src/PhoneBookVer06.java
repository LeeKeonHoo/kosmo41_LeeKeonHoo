//전화번호 관리 프로그램 구현 프로젝트
//version 0.6

import java.util.Scanner;

interface INIT_MENU2
{
	int INPUT =1, SEARCH =2, DELETE =3, EXIT =4;
}
interface INPUT_SELECT2
{
	int NORMAL =1, UNIV =2, COMPANY =3;
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

class PhoneInfo6{
	String name;
	String phoneNumber;
	
	public PhoneInfo6(String name, String num)
	{
		this.name = name;
		phoneNumber = num;
	}
	public void showPhoneInfo()
	{
		System.out.println("name : " + name);
		System.out.println("phone : " + phoneNumber);
	}
}

class PhoneUnivInfo3 extends PhoneInfo6
{
	String major;
	int year;
	
	public PhoneUnivInfo3(String name, String num, String major, int year)
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

class PhoneCompanyInfo3 extends PhoneInfo6
{
	String company;
	
	public PhoneCompanyInfo3(String name, String num, String company)
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


class PhoneBookManager6
{
	final int MAX_CNT = 100;
	PhoneInfo6[] infoStorage = new PhoneInfo6[MAX_CNT];
	int curCnt =0;
	
	static PhoneBookManager6 inst =null;
	public static PhoneBookManager6 createManagerInst()
	{
		if(inst==null)
			inst = new PhoneBookManager6();
		
		return inst;
	}
	
	private PhoneBookManager6() {}
	
	private PhoneInfo6 readFriendInfo()
	{
		System.out.print("이름 : ");
		String name = MenuViewer4.keyboard.nextLine();
		System.out.print("전화번호 : ");
		String phone = MenuViewer4.keyboard.nextLine();
		return new PhoneInfo6(name, phone);
	}
	
	private PhoneInfo6 readUnivFriendInfo()
	{
		System.out.print("이름 : ");
		String name = MenuViewer4.keyboard.nextLine();
		System.out.print("전화번호 : ");
		String phone = MenuViewer4.keyboard.nextLine();
		System.out.print("전공 : ");
		String major = MenuViewer4.keyboard.nextLine();
		System.out.print("학년 : ");
		int year = MenuViewer4.keyboard.nextInt();
		MenuViewer4.keyboard.nextLine();
		return new PhoneUnivInfo3(name, phone, major, year);
	}
	
	private PhoneInfo6 readCompanyFriendInfo()
	{
		System.out.print("이름 : ");
		String name = MenuViewer4.keyboard.nextLine();
		System.out.print("전화번호 : ");
		String phone = MenuViewer4.keyboard.nextLine();
		System.out.print("회사 : ");
		String company = MenuViewer4.keyboard.nextLine();
		return new PhoneCompanyInfo3(name, phone, company);
	}
	
	public void inputData() throws MenuChoiceException
	{
		System.out.println("데이터 입력을 시작합니다...");	
		System.out.println("1. 일반, 2.대학 , 3.회사 ");
		System.out.print("선택>> ");
		int choice = MenuViewer4.keyboard.nextInt();
		MenuViewer4.keyboard.nextLine();
		PhoneInfo6 info = null;
		
		if(choice<INPUT_SELECT2.NORMAL || choice>INPUT_SELECT2.COMPANY)
			throw new MenuChoiceException(choice);
		
		switch(choice)
		{
		case INPUT_SELECT2.NORMAL :
			info=readFriendInfo();
			break;
		case INPUT_SELECT2.UNIV :
			info=readUnivFriendInfo();
			break;
		case INPUT_SELECT2.COMPANY :
			info=readCompanyFriendInfo();
			break;
		}
		
		infoStorage[curCnt++] = info;
		System.out.println("데이터 입력이 완료되었습니다. \n");
	}
	
	public void searchData()
	{
		System.out.println("데이터 검색을 시작합니다...");
		
		System.out.print("이름 : ");
		String name = MenuViewer4.keyboard.nextLine();
		
		int dataIdx = search(name);
		if(dataIdx<0)
		{
			System.out.println("해당하는 데이터가 존재하지 않습니다. \n");
		}
		else
		{
			infoStorage[dataIdx].showPhoneInfo();
			System.out.println("데이터 검색이 완료되엇습니다. \n");
		}
	}
	
	public void deleteData()
	{
		System.out.println("데이터 삭제를 시작합니다...");
		
		System.out.print("이름 : ");
		String name = MenuViewer4.keyboard.nextLine();
		
		int dataIdx = search(name);
		if(dataIdx <0)
		{
			System.out.println("해당하는 데이터가 존재하지 않습니다. \n");
		}
		else
		{
			for(int idx = dataIdx; idx<(curCnt-1); idx++)
				infoStorage[idx]=infoStorage[idx+1];
			
			curCnt--;
			System.out.println("데이터 삭제가 완료되었습니다. \n");
		}
	}
	
	private int search(String name)
	{
		for(int idx = 0; idx<curCnt; idx++)
		{
			PhoneInfo6 curInfo= infoStorage[idx];
			if(name.compareTo(curInfo.name)==0)
				return idx;
		}
		return -1;
	}
}

class MenuViewer4
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

class PhoneBookVer06 {

	public static void main(String[] args) {


		PhoneBookManager6 manager = PhoneBookManager6.createManagerInst();
		int choice;
		
		while(true)
		{
			try
			{
				MenuViewer4.showMenu();
				choice = MenuViewer4.keyboard.nextInt();
				MenuViewer4.keyboard.nextLine();	//아래에서 설명
				
				if(choice<INIT_MENU2.INPUT || choice>INIT_MENU2.EXIT)
					throw new MenuChoiceException(choice);

				switch(choice)
				{
				case INIT_MENU2.INPUT:
					manager.inputData();
					break;
				case INIT_MENU2.SEARCH:
					manager.searchData();
					break;
				case INIT_MENU2.DELETE:
					manager.deleteData();
					break;
				case INIT_MENU2.EXIT:
					System.out.println("프로그랭을 종료합니다.");
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