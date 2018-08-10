//전화번호 관리 프로그램 구현 프로젝트
//version 0.4

import java.util.Scanner;

class PhoneInfo4{
	String name;
	String phoneNumber;
	
	public PhoneInfo4(String name, String num)
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

class PhoneUnivInfo extends PhoneInfo4
{
	String major;
	int year;
	
	public PhoneUnivInfo(String name, String num, String major, int year)
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

class PhoneCompanyInfo extends PhoneInfo4
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
}


class PhoneBookManager2
{
	final int MAX_CNT = 100;
	PhoneInfo4[] infoStorage = new PhoneInfo4[MAX_CNT];
	int curCnt =0;
	
	private PhoneInfo4 readFriendInfo()
	{
		System.out.print("이름 : ");
		String name = MenuViewer2.keyboard.nextLine();
		System.out.print("전화번호 : ");
		String phone = MenuViewer2.keyboard.nextLine();
		return new PhoneInfo4(name, phone);
	}
	
	private PhoneInfo4 readUnivFriendInfo()
	{
		System.out.print("이름 : ");
		String name = MenuViewer2.keyboard.nextLine();
		System.out.print("전화번호 : ");
		String phone = MenuViewer2.keyboard.nextLine();
		System.out.print("전공 : ");
		String major = MenuViewer2.keyboard.nextLine();
		System.out.print("학년 : ");
		int year = MenuViewer2.keyboard.nextInt();
		MenuViewer2.keyboard.nextLine();
		return new PhoneUnivInfo(name, phone, major, year);
	}
	
	private PhoneInfo4 readCompanyFriendInfo()
	{
		System.out.print("이름 : ");
		String name = MenuViewer2.keyboard.nextLine();
		System.out.print("전화번호 : ");
		String phone = MenuViewer2.keyboard.nextLine();
		System.out.print("회사 : ");
		String company = MenuViewer2.keyboard.nextLine();
		return new PhoneCompanyInfo(name, phone, company);
	}
	
	public void inputData()
	{
		System.out.println("데이터 입력을 시작합니다...");	
		System.out.println("1. 일반, 2.대학 , 3.회사 ");
		System.out.print("선택>> ");
		int choice = MenuViewer2.keyboard.nextInt();
		MenuViewer2.keyboard.nextLine();
		PhoneInfo4 info = null;
		
		switch(choice)
		{
		case 1 :
			info=readFriendInfo();
			break;
		case 2 :
			info=readUnivFriendInfo();
			break;
		case 3 :
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
		String name = MenuViewer2.keyboard.nextLine();
		
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
		String name = MenuViewer2.keyboard.nextLine();
		
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
			PhoneInfo4 curInfo= infoStorage[idx];
			if(name.compareTo(curInfo.name)==0)
				return idx;
		}
		return -1;
	}
}

class MenuViewer2
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

class PhoneBookVer04 {

	public static void main(String[] args) {


		PhoneBookManager2 manager = new PhoneBookManager2();
		int choice;
		
		while(true)
		{
			MenuViewer2.showMenu();
			choice = MenuViewer2.keyboard.nextInt();
			MenuViewer2.keyboard.nextLine();	//아래에서 설명
			
			switch(choice)
			{
			case 1:
				manager.inputData();
				break;
			case 2:
				manager.searchData();
				break;
			case 3:
				manager.deleteData();
				break;
			case 4:
				System.out.println("프로그랭을 종료합니다.");
				return;
			}
		}
	}
}