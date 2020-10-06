
public class Vehicle {
	int i_passengers;
	int i_fuelcap;
	int i_mpg;
	String i_model;

	Vehicle() {
		i_passengers = 0;
		i_fuelcap = 0;
		i_mpg = 0;
		i_model = " ";
	}

	Vehicle(String model, int pass, int fuel, int mpg) {
		i_model = model;
		i_passengers = pass;
		i_fuelcap = fuel;
		i_mpg = mpg;
	}

	int range() {
		return i_mpg * i_fuelcap;
	}

	double fuelNeeded(int miles) {
		return (double)miles / i_mpg;
	}
	
	int getPassengers() {
		return i_passengers;
	}
	
	void setPassengers(int p) {
		i_passengers = p;
	}
	
	int getFuelcap() {
		return i_fuelcap;
	}
	
	void setFuelcap(int f) {
		i_fuelcap = f;
	}
	
	int getMpg() {
		return i_mpg;
	}
	
	void setMpg(int m) {
		i_mpg = m;
	}
	
	String getModel() {
		return i_model;
	}
	
	void setModel(String md) {
		i_model = md;
	}
}
