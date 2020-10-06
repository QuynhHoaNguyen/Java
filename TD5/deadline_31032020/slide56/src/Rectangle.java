
public class Rectangle extends TwoDShape {
	// Constructors for Rectangle
	Rectangle() {
		super();
	}

	Rectangle(double w, double h) {
		super(w, h, "rectangle");
	}

	Rectangle(double x) {
		super(x, "rectangle");
	}

	Rectangle(Rectangle ob) {
		super(ob); // pass object to TwoDShape constructor
	}

	boolean isSquare() {
		if (getWidth() == getHeight())
			return true;
		return false;
	}

	// Override area() for Rectangle.
	double area() {
		return getWidth() * getHeight();
	}
}
