import java.io.*;
import java.util.*;

public class Main {
	private static int n, m;
	private static int[][] map;
	private static List<Integer> list;
	private static boolean[][] canWatch;
	
	// 1 -> 0,1,2,3 2-> (0,1) (2,3) 3-> not 0,1,2,3
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		list = new ArrayList<>();
		canWatch = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				int info = Integer.parseInt(st.nextToken());
				if(info == 6) {
					canWatch[i][j] = true;
				}
				map[i][j] = info;
			}
		}
		
		br.close();
	}
	
	public static void mode(int cctv ) {
		
	}
}