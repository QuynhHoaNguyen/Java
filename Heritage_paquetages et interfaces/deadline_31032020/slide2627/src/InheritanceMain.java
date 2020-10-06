
public class InheritanceMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		Car minivan = new Car();
		Truck something = new Truck();
		
		int range1, range2;
		
		minivan.setPassengers(7);
		minivan.setMpg(21);
		minivan.setFuelcap(16);
		minivan.setModel("minivan");
		minivan.setColor(1);
		minivan.setOwner("1752017");
		
		range1 = minivan.i_fuelcap * minivan.i_mpg;
		
		System.out.println("Minivan can carry "+minivan.i_passengers+" with a range of "+range1);
		System.out.println("Owner: " + minivan.getOwner());
		System.out.println("Model: " + minivan.getModel());
		System.out.println("Fuelcap: "+ minivan.getFuelcap());
		System.out.println("Color: "+ minivan.getColor());
		System.out.println("Mpg: "+ minivan.getMpg());
		
		something.setCargocap(5);
		something.setFuelcap(80);
		something.setModel("something");
		something.setMpg(90);
		something.setPassengers(48);
		
		range2 = something.i_fuelcap * something.i_mpg;
		System.out.println("Something can carry "+something.i_passengers+" with a range of "+range2);
		System.out.println("Cargocap: "+something.getCargocap());
		System.out.println("Fuelcap: "+ something.getFuelcap());
		System.out.println("Model: "+something.getModel());
		System.out.println("Mpg: "+something.getMpg());
	}

}
