import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<String, Integer> stringKey = new HashMap<>();
		Map<Integer, String> intKey = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		for(int i = 1; i <= n; i++) {
			String pocketMon = br.readLine();
			stringKey.put(pocketMon, i);
			intKey.put(i, pocketMon);
		}
		
		for(int i = 0; i < m; i++) {
			String key = br.readLine();
			try {
				int num = Integer.parseInt(key);
				sb.append(intKey.get(num)).append("\n");
			} catch (Exception e) {
				sb.append(stringKey.get(key)).append("\n");
			}
		}
		
		System.out.print(sb);
		br.close();
	}
}
