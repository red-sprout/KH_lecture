package test9;

public class PlaneTest {
	public static void main(String[] args) {
		Plane airplane = new Airplane("L747", 1000);
		Plane cargoplane = new Cargoplane("C40", 1000);
		
		System.out.println("Plane\t\tfuelSize");
		System.out.println("--------------------------");
		System.out.println(airplane.getPlaneName() + "\t\t" + airplane.getFuelSize());
		System.out.println(cargoplane.getPlaneName() + "\t\t" + cargoplane.getFuelSize());
		
		int distance = 100;
		System.out.println(distance + " 운항");
		airplane.flight(distance);
		cargoplane.flight(distance);
		System.out.println("Plane\t\tfuelSize");
		System.out.println("--------------------------");
		System.out.println(airplane.getPlaneName() + "\t\t" + airplane.getFuelSize());
		System.out.println(cargoplane.getPlaneName() + "\t\t" + cargoplane.getFuelSize());
	
		int fuel = 200;
		System.out.println(fuel + " 주유");
		airplane.refuel(fuel);
		cargoplane.refuel(fuel);
		System.out.println("Plane\t\tfuelSize");
		System.out.println("--------------------------");
		System.out.println(airplane.getPlaneName() + "\t\t" + airplane.getFuelSize());
		System.out.println(cargoplane.getPlaneName() + "\t\t" + cargoplane.getFuelSize());
	}
}
