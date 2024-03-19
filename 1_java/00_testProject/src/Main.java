import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        MyDeque deque = new MyDeque();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
        	String[] command = br.readLine().split(" ");
        	switch(command[0]) {
        	case "1":
        		deque.one(Integer.parseInt(command[1]));
        		break;
        	case "2":
        		deque.two(Integer.parseInt(command[1]));
        		break;
        	case "3":
        		sb.append(deque.three()).append("\n");
        		break;
        	case "4":
        		sb.append(deque.four()).append("\n");
        		break;
        	case "5":
        		sb.append(deque.five()).append("\n");
        		break;
        	case "6":
        		sb.append(deque.six()).append("\n");
        		break;
        	case "7":
        		sb.append(deque.seven()).append("\n");
        		break;
        	case "8":
        		sb.append(deque.eight()).append("\n");
        		break;
        	}
        }
        System.out.print(sb.toString());
        
        br.close();
    }
}

class MyDeque{
	private int size;
	private Node front;
	private Node rear;
	
	class Node{
		int data;
		Node prev;
		Node next;
		
		Node(int data){
			this.data = data;
			prev = null;
			next = null;
		}
	}
	
	public void one(int x) {
		Node node = new Node(x);
		if(size == 0) {
			size++;
			front = rear = node;
			return;
		}
		size++;
		node.next = front;
		front.prev = node;
		front = node;
	}
	
	public void two(int x) {
		Node node = new Node(x);
		if(size == 0) {
			size++;
			front = rear = node;
			return;
		}
		size++;
		node.prev = rear;
		rear.next = node;
		rear = node;
	}
	
	public int three() {
		if(size == 0) {
			return -1;
		}
		size--;
		Node node = front;
		front = node.next;
		return node.data;
	}
	
	public int four() {
		if(size == 0) {
			return -1;
		}
		size--;
		Node node = rear;
		rear = node.prev;
		return node.data;
	}
	
	public int five() {
		return size;
	}
	
	public int six() {
		return size == 0 ? 1 : 0;
	}
	
	public int seven() {
		if(size == 0) {
			return -1;
		}
		return front.data;
	}
	
	public int eight() {
		if(size == 0) {
			return -1;
		}
		return rear.data;
	}
}