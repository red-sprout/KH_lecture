package test8;

public class UserTest {
	public static void main(String[] args) {
		User[] users = new User[3];
		
		users[0] = new User("user01", "pass01", "김철수", 32, 'M', "010-1234-5678");
		users[1] = new User("user02", "pass02", "김철수", 25, 'F', "010-5555-7777");
		users[2] = new User("user03", "pass03", "김철수", 20, 'F', "010-9874-5632");
		
		System.out.println("users list -----------------------------------------");
		for(int i = 0; i < 3; i++) {
			System.out.println(users[i].toString());
		}
		
		User[] copyUsers = new User[users.length];
		
		for(int i = 0; i < 3; i++) {
			copyUsers[i] = (User) users[i].clone();
		}
		
		System.out.println("copyUsers -----------------------------------------");
		for(User user : copyUsers) {
			System.out.println(user.toString());
		}
		
		System.out.println("비교결과 -----------------------------------------");
		for(int i = 0; i < 3; i++) {
			System.out.println(users[i].equals(copyUsers[i]));
		}
	}
}
