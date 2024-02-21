
public class Human {
	private String name;
	private int age;
	private char classRoom;
	
	public Human(String name, int age, char classRoom) {
		super();
		this.name = name;
		this.age = age;
		this.classRoom = classRoom;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void print() {
		System.out.printf("%c강의장에서 수업을 듣고 있는 %d살 %s입니다.\n", this.classRoom, this.age, this.name);
	}
}
