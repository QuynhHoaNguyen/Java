package my_point;

public class Triangle {
	MyPoint A = new MyPoint();
	MyPoint B = new MyPoint();
	MyPoint C = new MyPoint();

	Triangle(){
		this.A.setX(0);
		this.A.setY(0);
		this.B.setX(0);
		this.B.setY(1);
		this.C.setX(1);
		this.C.setY(0);
	}

	Triangle(MyPoint A_1, MyPoint B_1, MyPoint C_1) {
		this.A.setX(A_1.getX());
		this.A.setY(A_1.getY());
		this.B.setX(B_1.getX());
		this.B.setY(B_1.getY());
		this.C.setX(C_1.getX());
		this.C.setY(C_1.getY());
	}

	public double disAB() {
		double dis;
		dis = Math.sqrt(Math.pow(this.B.getX() - this.A.getX(), 2) + Math.pow(this.B.getY() - this.A.getY(), 2));
		return dis;
	}

	public double disAC() {
		double dis;
		dis = Math.sqrt(Math.pow(this.C.getX() - this.A.getX(), 2) + Math.pow(this.C.getY() - this.A.getY(), 2));
		return dis;
	}

	public double disBC() {
		double dis;
		dis = Math.sqrt(Math.pow(this.C.getX() - this.B.getX(), 2) + Math.pow(this.C.getY() - this.B.getY(), 2));
		return dis;
	}

	// tinh cos
	// vt AB = (xb - xa; yb - ya);
	// vt AC = (xc - xa; yc - ya);
	// tinh cos goc BAC
	// -> cos(vt AB, vt AC) = (xab * xac + yab * yac) / (disAB * dis AC)

	public double cosBAC() {
		double cosBAC;
		cosBAC = (((this.B.getX() - this.A.getX()) * (this.C.getX() - this.A.getX()))
				+ ((this.B.getY() - this.A.getY()) * this.C.getY() - this.A.getY())) / (this.disAB() * this.disAC());
		return cosBAC;
	}

	public double cosBCA() {
		double cosBCA;
		cosBCA = (((this.B.getX() - this.C.getX()) * (this.A.getX() - this.C.getX()))
				+ ((this.B.getY() - this.C.getY()) * this.A.getY() - this.C.getY())) / (this.disBC() * this.disAC());
		return cosBCA;
	}

	public double cosABC() {
		double cosABC;
		cosABC = (((this.A.getX() - this.B.getX()) * (this.C.getX() - this.B.getX()))
				+ ((this.A.getY() - this.B.getY()) * this.C.getY() - this.B.getY())) / (this.disAB() * this.disBC());
		return cosABC;
	}

	public boolean isTriangle() {
		if ((this.A.getX() != this.B.getX() || this.A.getY() != this.B.getY())
				&& (this.B.getX() != this.C.getX() || this.B.getY() != this.C.getY())
				&& (this.A.getX() != this.C.getX() || this.A.getY() != this.C.getY())) {
			// kiem tra cac diem co trung nhau khong
			if (((this.A.getX() != this.B.getX()) && (this.A.getX() != this.C.getX()))
					|| ((this.A.getY() != this.B.getY()) && (this.A.getY() != this.C.getY()))) {
				// kiem tra thang hang
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/* Cac loai tam giac
	 * return -2: tam giac nhon return -1: tam giac tu return 0: tam giac vuong can
	 * return 1:tam giac vuong return 2: tam giac can return 3: tam giac deu
	 */
	public int typeTriangle() {
		if (cosABC() < 0 || cosBCA() < 0 || cosBAC() < 0) {
			return -1;
		}
		if (cosABC() == 0 || cosBCA() == 0 || cosBAC() == 0) {
			if ((disAB() == disAC()) || (disBC() == disAB())
					|| (disBC() == disAC())) {
				return 0;
			} else {
				return 1;
			}
		}

		if (cosABC() > 0 || cosBCA() > 0 || cosBAC() > 0) {
			if ((disAB() == disAC()) || (disBC() == disAB())
					|| (disBC() == disAC())) {
				return 2;
			}
			if ((disAB() == disAC()) && (disBC() == disAB())
					&& (disBC() == disAC())) {
				return 3;
			}
			return -2;
		}
		return -2;
	}

}
