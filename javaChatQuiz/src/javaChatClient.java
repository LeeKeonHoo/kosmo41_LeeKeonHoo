import java.io.*;
import java.net.*;
import java.util.Scanner;
public class javaChatClient {

	public static void main(String[] args)throws UnknownHostException,
										IOException {
		System.out.println("이름을 입력해 주세요");
		Scanner s =new Scanner(System.in);
		String s_name = s.nextLine();

//		String str1 = "/to 가 hello";
//		String str2 = "안녕하세요";
//		// 1."/to 대상"에 다음변수 입력, 초기화 토글
//		String sToReader = "/to aaaa";
//		//3. 고정 대상인 상태에서 임시 대상에게 귓속말
//		if(str1.indexOf("/to") >= 0) {
//			System.out.println(str2);
//		}else {
//		//2.무조건 붙여서 보내기
//			System.out.println(sToReader + str2);
//		}
		try {
			String ServerIP = "localhost";
			if(args.length > 0)
				ServerIP = args[0];
			Socket socket = new Socket(ServerIP, 9999);	//소켓 객체 생성
			System.out.println("서버와 연결이 되었습니다..");
			
			//서버에서 보내는 메시지를 사용자의 콘솔에 출력하는 쓰레드
			Thread receiver = new Receiver5(socket);
			receiver.start();
			
			//사용자로부터 얻은 문자열을 서버로 전송해주는 엵활을 하는 쓰레드
			Thread sender = new Sender5(socket, s_name);
			sender.start();
	}catch(Exception e) {
		System.out.println("예외 [MultiClient class] : " + e);
}
}
}