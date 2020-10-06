
public class Car extends Vehicle {
	int i_color;
	String i_owner;

	Car() {
		i_color = 0;
		i_owner = " ";
	}

	Car(String model, int pass, int fuel, int mpg, int color, String owner) {
		this.i_model = model;
		this.i_passengers = pass;
		this.i_fuelcap = fuel;
		this.i_mpg = mpg;
		i_color = 0;
		i_owner = " ";
	}

	int getColor() {
		return i_color;
	}

	void setColor(int cl) {
		i_color = cl;
	}
	
	String getOwner() {
		return i_owner;
	}
	
	void setOwner(String o) {
		i_owner = o;
	}
}
