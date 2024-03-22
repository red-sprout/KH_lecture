import java.io.*;
import java.util.*;

public class Main {
	static class Problem implements Comparable<Problem>{
		int num;
		boolean visited;
		LinkedList<Problem> list;
		
		Problem(int num, int n) {
			this.num = num;
			this.visited = false;
			this.list = new LinkedList<>();
		}

		@Override
		public int compareTo(Problem p) {
			return this.num - p.num;
		}
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Problem> pq = new PriorityQueue<>();
        
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        
        int[] before = new int[n + 1];
        Problem[] nodes = new Problem[n + 1];
        for(int i = 1; i <= n; i++) {
        	nodes[i] = new Problem(i, n);
        }
        
        for(int i = 0; i < m; i++) {
        	String[] ab = br.readLine().split(" ");
        	int a = Integer.parseInt(ab[0]);
        	int b = Integer.parseInt(ab[1]);
        	
        	before[b]++;
        	nodes[a].list.add(nodes[b]);
        }
        
        for(int i = 1; i <= n; i++) {
        	if(before[i] == 0) {
        		pq.add(nodes[i]);
        		nodes[i].visited = true;
        	}
        }
        
        while(!pq.isEmpty()) {
        	Problem now = pq.remove();
            sb.append(now.num).append(" ");
            
            for(Problem next : now.list) {
            	if(next.visited) continue;
            	if(--before[next.num] != 0) continue;
            	pq.add(next);
            	next.visited = true;
            }
        }
        
        System.out.println(sb.toString());
        
        br.close();
    }
}