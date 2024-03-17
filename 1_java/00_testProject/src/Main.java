import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        MyQueue q = new MyQueue();
        
        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        int[] prev = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        MyList[] next = new MyList[n + 1];
        
        for(int i = 0; i < m; i++) {
        	arr = br.readLine().split(" ");
        	int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            
            prev[b]++;
            
            if(next[a] == null) {
            	next[a] = new MyList(b);
            } else {
            	next[a].add(b);
            }
        }
        
        for(int i = 1; i <= n; i++) {
        	if(prev[i] == 0) {
        		q.add(i);
        		visited[i] = true;
        	}
        }
        
        while(!q.isEmpty()) {
        	int now = q.remove();
        	MyList nowList = next[now];
        	
        	sb.append(now).append(" ");
        	
        	if(nowList == null) {
        		continue;
        	}
        	
        	for(ListNode node = nowList.getHead(); node != null; node = node.next) {
        		if(visited[node.data]) continue;
        		
        		prev[node.data]--;
        		if(prev[node.data] != 0) continue;
        		
        		q.add(node.data);
        		
        		visited[node.data] = true;
        	}
        }
        
        System.out.println(sb.toString());
        
        br.close();
    }
}

class ListNode {
	int data;
	ListNode next = null;
	
	ListNode(int data) {
		this.data = data;
	}
}

class MyList {
	private ListNode head;
	private ListNode tail;
	
	public MyList(int data) {
		this.head = new ListNode(data);
		this.tail = this.head;
	}
	
	public ListNode getHead() {
		return this.head;
	}
	
	public void add(int data) {
		ListNode node = new ListNode(data);
		if(head.data == tail.data) {
			head.next = node;
			tail = node;
			return;
		}
		tail.next = node;
		tail = node;
	}
}

class MyQueue {
	private int size = 0;
	private Node front = null;
	private Node rear = null;
	
	class Node {
		int data;
		Node prev = null;
		Node next = null;
		
		Node(int data) {
			this.data = data;
		}
	}
	
	public void add(int x) {
		Node node = new Node(x);
		if(size == 0) {
			front = node;
			rear = node;
			size++;
			return;
		}
		
		node.prev = rear;
		rear.next = node;
		rear = node;
		size++;
	}
	
	public int remove() {
		Node node = front;
		front = node.next;
		size--;
		return node.data;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
}