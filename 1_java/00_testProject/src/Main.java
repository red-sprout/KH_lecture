import java.io.*;
import java.util.*;

public class Main {
	private static int r, c;
	private static char[][] miro;
	
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        miro = new char[r][c];
        
        int[] jihun = new int[2];
        List<int[]> fireList = new ArrayList<>();
        
        for(int i = 0; i < r; i++) {
        	String row = br.readLine();
        	for(int j = 0; j < c; j++) {
        		miro[i][j] = row.charAt(j);
        		switch(miro[i][j]) {
        		case 'J':
        			jihun[0] = i;
        			jihun[1] = j;
        			break;
        		case 'F':
        			fireList.add(new int[] {i, j});
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
    	int result = 0;
    	boolean isFire;
    	Queue<int[]> jihunQ = new LinkedList<>();
    	Queue<int[]> fireQ = new LinkedList<>();
    	jihunQ.add(new int[] {jihun[0], jihun[1], result});
    	for(int[] fire : fireList) {
    		fireQ.add(new int[] {fire[0], fire[1], result});
    	}
    	
    	while(!jihunQ.isEmpty()) {
    		int[] nowJihun = jihunQ.peek();
    		int[] nowFire = fireQ.peek();
    		
    		isFire = fireQ.isEmpty() ? false : nowJihun[2] > nowFire[2];
    		
    		System.out.println(nowFire[2] + ", " +nowJihun[2]);
    		for(int i = 0; i < r; i++) {
    			for(int j = 0; j < c; j++) {
    				System.out.print(miro[i][j]);
    			}
    			System.out.println();
    		}
    		if(miro[nowJihun[0]][nowJihun[1]] == 'F') continue;
    		
    		if(!isFire) {
    			nowJihun = jihunQ.remove();
        		for(int i = 0; i < 4; i++) {
        			int nextJihunRow = nowJihun[0] + dr[i];
        			int nextJihunCol = nowJihun[1] + dc[i];
        			if(nextJihunRow < 0 || nextJihunRow >= r) return nowJihun[2] + 1;
        			if(nextJihunCol < 0 || nextJihunCol >= c) return nowJihun[2] + 1;
        			if(miro[nextJihunRow][nextJihunCol] == '#' || miro[nextJihunRow][nextJihunCol] == 'F') continue;
        			jihunQ.add(new int[] {nextJihunRow, nextJihunCol, nowJihun[2] + 1});
        			miro[nextJihunRow][nextJihunCol] = 'J';
        		}
    		} else {
    			nowFire = fireQ.remove();
        		for(int i = 0; i < 4; i++) {
        			int nextFireRow = nowFire[0] + dr[i];
        			int nextFireCol = nowFire[1] + dc[i];
        			if(nextFireRow < 0 || nextFireRow >= r) continue;
        			if(nextFireCol < 0 || nextFireCol >= c) continue;
        			if(miro[nextFireRow][nextFireCol] == '#' || miro[nextFireRow][nextFireCol] == 'F') continue;
        			fireQ.add(new int[] {nextFireRow, nextFireCol, nowFire[2] + 1});
        			miro[nextFireRow][nextFireCol] = 'F';
        		}
    		}
    	}
    	
    	return -1;
    }
}