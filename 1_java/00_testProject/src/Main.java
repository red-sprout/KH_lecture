import java.io.*;
import java.util.*;

// [BOJ] 공통 부분 문자열 / 골드 5 / 
// 알고리즘 분류 : 다이나믹 프로그래밍
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();
        
        int row = str1.length();
        int col = str2.length();
        int[][] dp = new int[row + 1][col + 1];
        
        int max = 0;
        for(int i = 1; i <= row; i++) {
        	for(int j = 1; j <= col; j++) {
        		if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
        			dp[i][j] = dp[i - 1][j - 1] + 1;
        			max = Math.max(dp[i][j], max);
        		}
        	}
        }
        
        System.out.println(max);
        br.close();
    }
}