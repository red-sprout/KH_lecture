package com.kh.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//서버용 프로그램
public class TCPServer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		BufferedReader br = null;
		PrintWriter pw = null;
	
		// 1) 포트번호 지정(서버측에서 몇 번 포트로 통로를 열겠냐라는 의미)
		int port = 3000;
	
		ServerSocket server;
		try {
			// 2) ServerSocker 객체생성시 포트 결합(Bind)
			server = new ServerSocket(port);
			
			// 3) 틀라이언트로부터 접속요청이 올 때까지 대기
			System.out.println("클라이언트 요청을 기다리고 있습니다.");
			
			// 4) 연결요청이 오면 => 요청 수락 후 클라이언트와 통신할 수 있는 서버 측 소켓객체 생성
			Socket socket = server.accept();
			System.out.println(socket.getInetAddress().getHostAddress() + "가 연결을 요청함...");
			
			// 5) 클라이언트와 입출력 기반스트림 생성(바이트스트림밖에 안됨)
			// 6) 보조스트림을 통한 성능개선
			
			// 입력용 스트림(클라이언트로부터 전달된 값을 한줄 단위로 읽어들이기 위한 입력용 스트림)
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
			// 출력용 스트림(클라이언트에게 값을 한줄 단위로 출력할 수 있는 출력용 스트림)
			pw = new PrintWriter(socket.getOutputStream());
			// PrintWriter : 데이터출력시 print(), println() 메소드를 가지고 있는 보조 스트림
			
			while(true) {
				// 7) 스트림을 통해서 읽고 쓰기
				String message = br.readLine();
				System.out.println("클라이언트로부터 전달받은 메세지 : " + message);
				
				// 반대로 클라이언트에게 데이터 전달(출력)
				System.out.print("클라이언트에게 보낼 내용 : ");
				String sendMessage = sc.nextLine();
				
				pw.println(sendMessage); // 클라이언트한테 출력
				pw.flush(); // 현재 스트림에 있는 데이터를 강제로 내보내는 메소드
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				pw.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		sc.close();
	}
}
