package review;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServerTest {
	public static void main(String[] args) {
		byte[] data = new byte[100];
		try {
			DatagramSocket ds = new DatagramSocket(3000);
			DatagramPacket dp = new DatagramPacket(data, data.length);
			System.out.println("데이터 받을 준비 완료!");
			while(true) {
				ds.receive(dp);
				System.out.println("클라이언트 IP : " + dp.getAddress());
				
				String message = new String(dp.getData(), "UTF-8");
				System.out.println("클라이언트가 보낸 내용 : " + message);
				
				data = new byte[100];
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
