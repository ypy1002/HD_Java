package basic.exam05.step01;

import java.io.FileInputStream;
import java.io.FileReader;


//	binary Stream과 character Stream의 비교

//	1) binary Stream 클래스
//		-	byte단위로 데이터를 읽고 쓴다.
//		-	InputStream , OutputStream의 자손 클래스이다.
//		-	클래스 이름 뒤에 InputStream / OutputStream이 붙는다.

//	2) character Stream 클래스
//		-	문자 단위(Unicode 2byte)로 읽고 쓴다.
//		-	Reader / Writer의 자손 클래스이다.
//		-	클래스 이름 뒤에 Reader / Writer가 붙는다.
//		- 쓰기 => Unicode를 운영체제의 기본 인코딩으로 변환하여 출력한다.
//		-	읽기 => 읽은 데이터를 Unicode로 변환하여 리턴한다.

public class Episode04 {
	
	public static void main(String[] args) throws Exception {
		
		//	텍스트 데이터 읽기를 통한 동작 비교
		//	character Stream으로 읽기
		//	읽어들은 데이터는 Unicode로 변환한다.
		//	-	영어는 1byte 읽어서 2byte Unicode로 변환.
		//	-	한글(UTF-8)은 3byte로 읽어서 2byte Unicode로 변환
		//	변환한 Unicode를 리턴한다.
		
		FileReader in = new FileReader("student4.dat");
		
		int i = 0;
		
		while((i = in.read()) != -1){
			System.out.println(Integer.toHexString(i));
		}
	}
	
	public static void main01(String[] args) throws Exception {
		
		//	텍스트 데이터 읽기를 통한 동작 비교
		//	Binary Stream으로 읽기
		//	읽어들은 데이터는 가공하지 않는다. 원래의 바이트 그대로 리턴
		
		FileInputStream in = new FileInputStream("student4.dat");
		
		int i = 0;
		
		while((i = in.read()) != -1){
			System.out.println(Integer.toHexString(i));
		}
	}
}
