package com.kh.tcp;

import java.net.InetAddress;
import java.net.UnknownHostException;

// InetAddress : 네트워트의 정보(IP 주소 관련)을 확인할 수 있는 클래스
public class Run {
	public static void main(String[] args) {
		try {
			InetAddress localhost = InetAddress.getLocalHost(); // 내 PC(지역호스트)에 대한 정보를 반환
			System.out.println(localhost); // 내 PC명 + / + 내 IP주소
			
			System.out.println("내 PC명 : " + localhost.getHostName()); // 호스트의 이름을 반환
			System.out.println("내 IP주소 : " + localhost.getHostAddress()); // 호스트 IP주소 반환
			
			System.out.println("=====================================");
			
			InetAddress googleHost = InetAddress.getByName("www.google.com"); // 도메인명을 통해서 해당 호스트의 정보를 가져올 수 있다.
			System.out.println("구글의 서버명 : " + googleHost.getHostName());
			System.out.println("구글의 IP주소 : " + googleHost.getHostAddress());
			
			System.out.println("=====================================");
			InetAddress[] naverHost = InetAddress.getAllByName("www.naver.com");
			System.out.println("네이버 호스트 개수 : " + naverHost.length);
			
			for(InetAddress n : naverHost) {
				System.out.println("네이버 서버명: " + n.getHostName());
				System.out.println("네이버 IP주소 : " + n.getHostAddress());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
