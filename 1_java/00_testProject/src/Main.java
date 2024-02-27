import java.io.*;
import java.util.*;

// [BOJ] 외판원 순회 / 골드 1 / 
// 알고리즘 분류 : 
public class Main {
	private static int n;
	private static int[][] w, dp;
	private static final int INF = 16000001;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        w = new int[n][n];
        
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < n; j++) {
        		w[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        dp = new int[n][(1 << n) - 1];
        
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < n; j++) {
        		dp[i][j] = -1;
        	}
        }
        
        System.out.println(tsp(0, 1));
        
        br.close();
    }
    
    // now : 현재 있는 도시
    // visit : 이미 방문(비트마스킹)
    public static int tsp(int now, int visit) {
    	if(visit == (1 << n) - 1) {
    		if(w[now][0] > 0) {
    			return w[now][0];
    		}
    		return INF;
    	}
    	
    	 if(dp[now][visit] != -1) return dp[now][visit];
         dp[now][visit] = INF;

         for(int i = 0; i < n; i++) {
             if((visit & (1 << i)) == 0 && w[now][i] != 0) {
                 dp[now][visit] = Math.min(tsp(i, visit | (1 << i)) + w[now][i], dp[now][visit]);
             }
         }
         return dp[now][visit];
    }
}