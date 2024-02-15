
public class Student {
	private String name;
	private int age;
	private int score;
	
	public Student() {
		super();
	}
	
	public Student(String name, int age, int score) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", score=" + score + "]";
	}

	@Override
	public int hashCode() { // 모든 필드에 담긴 값이 일치하면 동일한 hashCode 반환
		String str = name + age + score;
		return str.hashCode();
	}

	@Override
	public boolean equals(Object obj) { // 현재객체와 전달받은 객체의 각 필드값들이 모두 일치하면 true/ 아니면 false
		if (obj instanceof Student) {
			Student other = (Student)obj;
			if (this.getName().equals(other.getName())
			&& this.getAge() == other.getAge()
			&& this.getScore() == other.getScore()) {
				return true;
			}
		}
		return false;
	}
	
	
}
