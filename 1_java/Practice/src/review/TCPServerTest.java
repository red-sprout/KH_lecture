package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServerTest {
	public static void main(String[] args) {
		// 포트번호를 3000번으로 해서 서버와 클라이언트 단방향 채팅 구현하기(서버)
		BufferedReader br = null;
		PrintWriter pw = null;
		Scanner sc = null;
		try {
			ServerSocket server = new ServerSocket(3000);
			System.out.println("대기 중...");

			while (true) {
				Socket socket = server.accept();
				System.out.println(socket.getInetAddress().getHostAddress() + "가 접속했습니다.");
				
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				pw = new PrintWriter(socket.getOutputStream());
				sc = new Scanner(System.in);
				
				String message = br.readLine();
				System.out.println("클라이언트로부터 온 메세지 : " + message);
				
				System.out.print("보낼 메세지 : ");
				String sendMsg = sc.nextLine();
				pw.println(sendMsg);
				pw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				pw.close();
				sc.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
