import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int numer = 1;
        int denom = 1;
        
        for(int i = 1; i <= k; i++) {
        	numer *= n - i + 1;
        	denom *= i;
        }
        
        System.out.println(numer / denom);
        
        br.close();
    }
}