<<<<<<< HEAD
=======
import java.io.*;
import java.util.*;

public class Main {
	private static int r, c;
	private static char[][] miro;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        miro = new char[r][c];
        
        int[] jihun = new int[3];
        List<int[]> fireList = new ArrayList<>();
        
        for(int i = 0; i < r; i++) {
        	String row = br.readLine();
        	for(int j = 0; j < c; j++) {
        		miro[r][c] = row.charAt(j);
        		switch(miro[r][c]) {
        		case 'J':
        			jihun[0] = r;
        			jihun[1] = c;
        			jihun[2] = 0;
        			break;
        		case 'F':
        			fireList.add(new int[] {r, c, 0});
        			break;
        		}
        	}
        }
        
        int result = bfs(jihun, fireList);
        
        br.close();
    }
    
    public static int bfs(int[] jihun, List<int[]> fireList) {
    	int time = 0;
    	boolean fireMode;
    	int[] dr = {-1, 1, 0, 0};
    	int[] dc = {0, 0, -1, 1};
    	
    	Queue<int[]> jihunQ = new LinkedList<>();
    	Queue<int[]> fireQ = new LinkedList<>();
    	
    	jihunQ.add(jihun);
    	for(int[] fire : fireList) {
    		fireQ.add(fire);
    	}
    	
    	while(!jihunQ.isEmpty()) {
    		int[] nowJihun = jihunQ.peek();
    		int[] nowFire;
    		
    		if(fireQ.isEmpty()) {
    			fireMode = false;
    		} else {
    			nowFire = fireQ.peek();
    			fireMode = (nowJihun[2] != time) && (nowFire[2] == time);
    		}
    		
    		if(fireMode) {
    			nowFire = fireQ.remove();
    			for(int i = 0; i < 4; i++) {
    				int nextRow = nowFire[0] + dr[i];
    				int nextCol = nowFire[1] + dc[i];
    				
    				if(nextRow < 0 || nextRow >= r || nextCol < 0 || nextCol >= c) continue;
    			}
    		} else {
    			nowJihun = jihunQ.remove();
    			for(int i = 0; i < 4; i++) {
    				int nextRow = nowJihun[0] + dr[i];
    				int nextCol = nowJihun[1] + dc[i];
    				
    				if(nextRow < 0 || nextRow >= r || nextCol < 0 || nextCol >= c) continue;
    				if(visited[nextRow][nextCol]) continue;
    			}
    		}
    	}
    	
    	return -1;
    }
}
>>>>>>> 13459da4bd6a37cfb7d14f7f7672a1e8e5405cc5
