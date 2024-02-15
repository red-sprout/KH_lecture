package test10;

public class Secretary extends Employee implements Bonus {
	public Secretary() {
		super();
	}

	public Secretary(String name, int number, String department, int salary) {
		super(name, number, department, salary);
	}

	@Override
	public double tax() {
		return super.getSalary() * 0.1;
	}
	
	public void incentive(int pay) {
		super.setSalary(super.getSalary() + (int)(0.8 * pay));
	}
}
