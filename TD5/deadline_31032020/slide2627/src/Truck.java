
public class Truck extends Vehicle{
	int i_cargocap;
	
	Truck(){
		i_cargocap = 0;
	}
	
	Truck(String model, int pass, int fuel, int mpg, int cargocap){
		this.i_model = model;
		this.i_passengers = pass;
		this.i_fuelcap = fuel;
		this.i_mpg = mpg;
		i_cargocap = 0;
	}
	
	int getCargocap() {
		return i_cargocap; 
	}
	
	void setCargocap(int c) {
		i_cargocap = c;
	}
	
}
