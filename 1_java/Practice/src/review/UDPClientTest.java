package review;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClientTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		System.out.print("보낼메세지 입력 : ");
		String msg = sc.nextLine();
		InetAddress inet;
		
		try (DatagramSocket dsoc = new DatagramSocket();) {
			inet = InetAddress.getByName("localhost");
			DatagramPacket dp = new DatagramPacket(msg.getBytes(), msg.getBytes().length, inet, 3000);
			dsoc.send(dp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sc.close();
	}
}
