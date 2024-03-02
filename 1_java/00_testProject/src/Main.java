import java.io.*;
import java.util.*;

// [BOJ]  /  / 
// 알고리즘 분류 : 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int t = Integer.parseInt(br.readLine());
        
        boolean[] status1;
        boolean[] status2;
        
        for(int i = 0; i < t; i++) {
        	st = new StringTokenizer(br.readLine());
        	int x1 = Integer.parseInt(st.nextToken());
        	int y1 = Integer.parseInt(st.nextToken());
        	int x2 = Integer.parseInt(st.nextToken());
        	int y2 = Integer.parseInt(st.nextToken());
        	
        	int n = Integer.parseInt(br.readLine());
        	
        	status1 = new boolean[n];
        	status2 = new boolean[n];
        	
        	for(int j = 0; j < n; j++) {
            	st = new StringTokenizer(br.readLine());
            	int cx = Integer.parseInt(st.nextToken());
            	int cy = Integer.parseInt(st.nextToken());
            	int r = Integer.parseInt(st.nextToken());
            	
            	int dsquare1 = (cx - x1) * (cx - x1) + (cy - y1) * (cy - y1);
            	int dsquare2 = (cx - x2) * (cx - x2) + (cy - y2) * (cy - y2);
            	
            	status1[j] = dsquare1 < r * r;
            	status2[j] = dsquare2 < r * r;
        	}
        	
        	int result = 0;
        	for(int j = 0; j < n; j++) {
        		if(status1[j] != status2[j]) 
        			result++;
        	}
        	
        	sb.append(result).append("\n");
        }
        
        System.out.print(sb);
        br.close();
    }
}