import java.io.*;
import java.util.*;

public class Main {
	private static int r, c;
	private static char[][] miro;
	private static char[][] miro2;
	
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
        		miro[i][j] = row.charAt(j);
        		switch(miro[i][j]) {
        		case 'J':
        			jihun[0] = i;
        			jihun[1] = j;
        			jihun[2] = 0;
        			break;
        		case 'F':
        			fireList.add(new int[] {i, j, 0});
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
    	boolean fireMode;
    	int[] dr = {-1, 1, 0, 0};
    	int[] dc = {0, 0, -1, 1};
    	
    	LinkedList<int[]> jList = new LinkedList<>();
    	Queue<int[]> fireQ = new LinkedList<>();
    	
    	jList.add(jihun);
    	for(int[] fire : fireList) {
    		fireQ.add(fire);
    	}
    	
    	while(!jList.isEmpty()) {
    		int[] nowJihun = jList.peekFirst();
    		int[] nowFire = null;
    		
    		System.out.println(time);
    		for(int i = 0; i < r; i++) {
    			for(int j = 0; j < c; j++) {
    				System.out.print(miro[i][j]);
    			}
    			System.out.println();
    		}
    		
//    		if(fireQ.isEmpty()) {
//    			fireMode = (nowJihun[2] != time);
//    		} else {
//    			nowFire = fireQ.peek();
//    			fireMode = (nowJihun[2] != time) && (nowFire[2] == time);
//    		}
//    		
//    		if(fireMode) {
//    			nowFire = fireQ.remove();
//    			for(int i = 0; i < 4; i++) {
//    				int nextRow = nowFire[0] + dr[i];
//    				int nextCol = nowFire[1] + dc[i];
//    				
//    				if(nextRow < 0 || nextRow >= r || nextCol < 0 || nextCol >= c) continue;
//    				if(miro[nextRow][nextCol] == 'F' || miro[nextRow][nextCol] == '#') continue;
//    				if(miro[nextRow][nextCol] == 'J') {
//    					for(int j = 0; j < jList.size(); j++) {
//    						if(jList.get(j)[0] == nextRow && jList.get(j)[1] == nextCol) {
//    							jList.remove(j);
//    							break;
//    						}
//    					}
//    				}
//    				
//    				fireQ.add(new int[] {nextRow, nextCol, nowFire[2] + 1});
//    				miro[nextRow][nextCol] = 'F';
//    			}
//    			
//    			if(fireQ.peek()[2] != nowFire[2]) {
//    				time++;
//    			}
//    		} else {
//    			nowJihun = jList.pollFirst();
//    			for(int i = 0; i < 4; i++) {
//    				int nextRow = nowJihun[0] + dr[i];
//    				int nextCol = nowJihun[1] + dc[i];
//    				
//    				if(nextRow < 0 || nextRow >= r || nextCol < 0 || nextCol >= c) return nowJihun[2] + 1;
//    				if(miro[nextRow][nextCol] == 'J' || miro[nextRow][nextCol] == 'F' || miro[nextRow][nextCol] == '#') continue;
//    				
//    				jList.add(new int[] {nextRow, nextCol, nowJihun[2] + 1});
//    				miro[nextRow][nextCol] = 'J';
//    			}
//    		}
    	}
    	
    	return -1;
    }
}