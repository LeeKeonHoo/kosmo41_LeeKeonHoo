import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class A3_MakeFileAndDir {
	public static void main(String[] args)	throws IOException {
		Path fp = Paths.get("D:\\kunhoohei\\Study\\Java\\ch33\\Test.txt");
		fp = Files.createFile(fp);	//파일 생성
		//파일생성 - 그 경로에 같은 파일 있을시 에러
		Path dp1 = Paths.get("D:\\kunhoohei\\Study\\Java\\ch33\\Test");
		dp1 = Files.createDirectory(dp1);	//디렉토리 생성
		//폴더 생성 - 그 경로게 같은 폴더 있을시 에러
		Path dp2 = Paths.get("D:\\kunhoohei\\Study\\Java\\ch33\\Test");
		dp2 = Files.createDirectories(dp2);	//경로의 모든 디렉토리 생성
		//폴더 생성 - 없으면 새로 만들억나, 있어도 무방함
		System.out.println("File : " + fp);
		System.out.println("Dir1 : " + dp1);
		System.out.println("Dir2 : " + dp2);
	}
}