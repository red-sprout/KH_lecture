package test8;

public class User {
	private String id;
	private String password;
	private String name;
	private int age;
	private char gender;
	private String phone;
	
	public User() {
		super();
	}

	public User(String id, String password, String name, int age, char gender, String phone) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return id + "\t" + password + "\t" + name + "\t" + age + "\t" + gender
				+ "\t" + phone;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof User) {
//			if(this.id.hashCode() != ((User)obj).id.hashCode()) {
//				return false;
//			} else if(this.password.hashCode() != ((User)obj).password.hashCode()) {
//				return false;
//			} else if(this.name.hashCode() != ((User)obj).name.hashCode()) {
//				return false;
//			} else if(this.age != ((User)obj).age) {
//				return false;
//			} else if(this.gender != ((User)obj).gender) {
//				return false;
//			} else if(this.phone.hashCode() != ((User)obj).phone.hashCode()) {
//				return false;
//			} else {
//				return true;
//			}
			return this.toString().hashCode() == obj.toString().hashCode();
		}
		return false;
	}

	public Object clone(){
		User user = new User(this.id, this.password, this.name, this.age, this.gender, this.phone);
		return user;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
