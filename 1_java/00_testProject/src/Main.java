import java.io.*;
import java.util.*;

// [BOJ]  /  / 
// 알고리즘 분류 : 
public class Main {
	static char[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        board = new char[n][m];
        
        for(int i = 0; i < n; i++) {
        	board[i] = br.readLine().toCharArray();
        }
        
        int min = m * n;
        for(int row = 0; row <= n - 8; row++) {
        	for(int col = 0; col <= m - 8; col++) {
        		min = Math.min(min, getBoard(row, col));
        	}
        }
        
        System.out.println(min);
        br.close();
    }
    
    public static int getBoard(int row, int col) {
    	int result = 0;
    	int black = 0;
    	int white = 0;
    	for(int i = 0; i < 8; i++) {
    		for(int j = 0; j < 8; j++) {
    			if((i + j) % 2 == 0) {
	    			black = (board[row + i][col + j] == 'W') ? black + 1 : black;
	    			white = (board[row + i][col + j] == 'B') ? white + 1 : white;
	    		} else {
	    			black = (board[row + i][col + j] == 'B') ? black + 1 : black;
	    			white = (board[row + i][col + j] == 'W') ? white + 1 : white;
	    		}
    		}
    	}
    	result = Math.min(black, white);
    	return result;
    }
}