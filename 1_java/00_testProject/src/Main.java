import java.io.*;
import java.util.*;

// [BOJ]  /  / 
// 알고리즘 분류 : 
public class Main {
	static int[] arr;
	static int[] tmp;
	static int result = -1;
	static int cnt = 0;
	static int n, k;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        tmp = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        merge_sort(arr, 0, n - 1);
        System.out.println(result);
        br.close();
    }
    
    public static void merge_sort(int[] a, int p, int r) {
    	if(p < r) {
    		int q = (p + r) / 2;
    		merge_sort(a, p, q);
    		merge_sort(a, q + 1, r);
    		merge(a, p, q, r);
    	}
    }
    
    public static void merge(int[] a, int p, int q, int r) {
    	int i = p;
    	int j = q + 1;
    	int t = 0;
    	
    	while(i <= q && j <= r) {
    		if(a[i] < a[j]) {
    			tmp[t++] = a[i++];
    		} else {
    			tmp[t++] = a[j++];
    		}
    	}
    	
    	while(i <= q) tmp[t++] = a[i++];
    	while(j <= r) tmp[t++] = a[j++];
    	
    	i = p;
    	t = 0;
    	
    	while(i <= r) {
    		cnt++;

            if(cnt == k){
                result = tmp[t];
            }
            
            a[i++] = tmp[t++];
    	}
    }
}