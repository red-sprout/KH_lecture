import java.io.*;
import java.util.*;

public class Main {
	private static int r, c;
	private static char[][] miro;
	private static char[][] mirofire;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        miro = new char[r][c];
        mirofire = new char[r][c];
        
        int[] jihun = null;
        List<int[]> fireList = new ArrayList<>();
        
        for(int i = 0; i < r; i++) {
        	String row = br.readLine();
        	for(int j = 0; j < c; j++) {
        		miro[i][j] = row.charAt(j);
        		mirofire[i][j] = row.charAt(j);
        		
        		switch(miro[i][j]) {
        		case 'J':
        			jihun = new int[] {i, j};
        			break;
        		case 'F':
        			fireList.add(new int[] {i, j});
        			break;
        		}
        	}
        }
        
        int result = bfs(jihun, fireList);
        if(result == -1) {
        	System.out.println("IMPOSSIBLE");
        } else {
        	System.out.println(result);
        }
        
        br.close();
    }
    
    public static int bfs(int[] jihun, List<int[]> fireList) {
    	int time = 0;
    	int[] dr = {-1, 1, 0, 0};
    	int[] dc = {0, 0, -1, 1};
    	
    	Queue<int[]> jihunQ = new LinkedList<>();
    	Queue<int[]> fireQ = new LinkedList<>();
    	
    	jihunQ.add(jihun);
    	for(int[] fire : fireList) {
    		fireQ.add(fire);
    	}
    	
    	while(!jihunQ.isEmpty()) {
    		int fireSize = fireQ.size();
    		int jihunSize = jihunQ.size();
    		
    		for(int i = 0; i < fireSize; i++) {
    			int[] nowFire = fireQ.remove();
    			for(int j = 0; j < 4; j++) {
    				int nextRow = nowFire[0] + dr[j];
    				int nextCol = nowFire[1] + dc[j];
    				
    				if(nextRow < 0 || nextRow >= r || nextCol < 0 || nextCol >= c) continue;
    				if(mirofire[nextRow][nextCol] == '#' || mirofire[nextRow][nextCol] == 'F') continue;
    				
    				fireQ.add(new int[] {nextRow, nextCol});
    				mirofire[nextRow][nextCol] = 'F';
    			}
    		}
    		
    		for(int i = 0; i < jihunSize; i++) {
    			int[] nowJihun = jihunQ.remove();
    			for(int j = 0; j < 4; j++) {
    				int nextRow = nowJihun[0] + dr[j];
    				int nextCol = nowJihun[1] + dc[j];
    				
    				if(nextRow < 0 || nextRow >= r || nextCol < 0 || nextCol >= c) return time + 1;
    				if(miro[nextRow][nextCol] == '#' || miro[nextRow][nextCol] == 'J' || mirofire[nextRow][nextCol] == 'F') continue;
    				
    				jihunQ.add(new int[] {nextRow, nextCol});
    				miro[nextRow][nextCol] = 'J';
    			}
    		}
    		
    		time++;
    	}
    	
    	return -1;
    }
}