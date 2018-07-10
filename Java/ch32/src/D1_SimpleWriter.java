import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class D1_SimpleWriter {
	public static void main(String[] args) {
		try(Writer out = new FileWriter("data.dat")){	//문자 출력 스트림 생성
			out.write('A');	//문서의 'A'저장
			out.write('한');	//문서의 '한'저장
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
