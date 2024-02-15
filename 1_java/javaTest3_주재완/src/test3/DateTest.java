package test3;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
		Date birth = new Date(1987 - 1900, 5 - 1, 27);
		Date now = new Date();
		SimpleDateFormat format1 = new SimpleDateFormat("생일 : yyyy년 MM월 dd일 E요일");
		SimpleDateFormat format2 = new SimpleDateFormat("현재 : yyyy년 MM월 dd일");
		
		String birthFormat = format1.format(birth);
		String nowFormat = format2.format(now);
		
		System.out.println(birthFormat);
		System.out.println(nowFormat);
		System.out.println("나이 : " + (now.getYear() - birth.getYear()));
	}
}
