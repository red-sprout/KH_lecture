package test10;

public class Sales extends Employee implements Bonus {
	public Sales() {
		super();
	}

	public Sales(String name, int number, String department, int salary) {
		super(name, number, department, salary);
	}

	@Override
	public double tax() {
		return super.getSalary() * 0.13;
	}
	
	@Override
	public void incentive(int pay) {
		super.setSalary(super.getSalary() + (int)(1.2 * pay));
	}
}
