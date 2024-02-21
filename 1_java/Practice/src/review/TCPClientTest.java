package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TCPClientTest {
	public static void main(String[] args) {
		// 포트번호를 3000번으로 해서 서버와 클라이언트 단방향 채팅 구현하기(클라이언트)
		BufferedReader br = null;
		PrintWriter pw = null;
		Scanner sc = null;
		try {
			Socket socket = new Socket("localhost", 3000);
			System.out.println("접속완료!");
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream());
			sc = new Scanner(System.in);
			
			while (true) {
				System.out.print("보낼 메세지 : ");
				String sendMsg = sc.nextLine();
				pw.println(sendMsg);
				pw.flush();
				
				String message = br.readLine();
				System.out.println("서버로부터 온 메세지 : " + message);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
