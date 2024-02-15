package test9;

public class Cargoplane extends Plane{
	public Cargoplane() {
		super();
	}

	public Cargoplane(String planeName, int fuelSize) {
		super(planeName, fuelSize);
	}

	@Override
	public void flight(int distance) {
		super.setFuelSize(super.getFuelSize() - 5 * distance);
	}
}
