import java.io.*;
import java.util.*;

public class Main {
	private static int r, c;
	private static char[][] miro;
	private static boolean[][] visited;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        miro = new char[r][c];
        visited = new boolean[r][c];
        
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
    	
    	Queue<int[]> jihunQ = new LinkedList<>();
    	Queue<int[]> fireQ = new LinkedList<>();
    	
    	jihunQ.add(jihun);
    	visited[jihun[0]][jihun[1]] = true;
    	for(int[] fire : fireList) {
    		fireQ.add(fire);
    		visited[fire[0]][fire[1]] = true;
    	}
    	
    	while(!jihunQ.isEmpty()) {
    		int[] nowJihun = jihunQ.peek();
    		
    		if(fireQ.isEmpty()) {
    			fireMode = false;
    		}
    	}
    	
    	return -1;
    }
}