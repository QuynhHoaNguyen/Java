package my_point;

public class MyPoint {
	private double i_x;
	private double i_y;

	MyPoint() {
		this.i_x = 0;
		this.i_y = 0;
	}

	MyPoint(double x, double y) {
		this.i_x = x;
		this.i_y = y;
	}

	public double getX() {
		return i_x;
	}

	public void setX(double x) {
		this.i_x = x;
	}

	public double getY() {
		return i_y;
	}

	public void setY(double y) {
		this.i_y = y;
	}
}
