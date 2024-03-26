import java.io.*;
import java.util.*;

public class Main {
	private static int m, n, k;
	private static ArrayList<Integer> areaList;
	private static boolean[][] isNotArea;
	
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        isNotArea = new boolean[m][n];
        areaList = new ArrayList<>();
        
        for(int i = 0; i < k; i++) {
        	st = new StringTokenizer(br.readLine());
        	int x1 = Integer.parseInt(st.nextToken());
        	int y1 = Integer.parseInt(st.nextToken());
        	int x2 = Integer.parseInt(st.nextToken());
        	int y2 = Integer.parseInt(st.nextToken());
        	
        	for(int y = y1; y < y2; y++) {
        		for(int x = x1; x < x2; x++) {
        			isNotArea[y][x] = true;
        		}
        	}
        }
        
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if(!isNotArea[i][j]) {
        			bfs(i, j);
        		}
        	}
        }
        
        Collections.sort(areaList);
        
        sb.append(areaList.size()).append("\n");
        for(int area : areaList) {
        	sb.append(area).append(" ");
        }
        
        System.out.println(sb.toString());
        
        br.close();
    }
    
    public static void bfs(int row, int col) {
    	int tmp = 0;
    	Queue<int[]> q = new LinkedList<>();
    	
    	tmp++;
    	q.add(new int[] {row, col});
    	isNotArea[row][col] = true;
    	
    	while(!q.isEmpty()) {
    		int[] now = q.remove();
    		for(int i = 0; i < 4; i++) {
    			int nextRow = now[0] + dr[i];
    			int nextCol = now[1] + dc[i];
    			
    			if(nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) continue;
    			if(isNotArea[nextRow][nextCol]) continue;
    			
    			tmp++;
    			q.add(new int[] {nextRow, nextCol});
    			isNotArea[nextRow][nextCol] = true;
    		}
    	}
    	
    	areaList.add(tmp);
    }
}