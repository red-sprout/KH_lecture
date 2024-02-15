package review;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
	public static void main(String[] args) {
		// 1. 로컬 호스트의 주소를 출력하시오.
//		try {
//			InetAddress localHost = InetAddress.getLocalHost();
//			System.out.println(localHost);
//			System.out.println("내 PC 명 : " + localHost.getHostName());
//			System.out.println("내 주소 : " + localHost.getAddress());
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//		}
		
		// 2. www.google.com의 주소를 출력하시오.
//		try {
//			InetAddress google = InetAddress.getByName("www.google.com");
//			System.out.println(google);
//			System.out.println("구글 주소 : " + google.getHostAddress());
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//		}
		
		// 3. www.naver.com 호스트 수를 출력하고 각각의 주소를 모두 출력하시오.
//		try {
//			InetAddress[] naver = InetAddress.getAllByName("www.naver.com");
//			int length = naver.length;
//			System.out.println("호스트 수 : " + length);
//			
//			for(int i = 0; i < length; i++) {
//				System.out.println("주소 " + (i + 1) + " : " + naver[i].getHostAddress());
//			}
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//		}
	}
}
