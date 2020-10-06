package my_point;

public class Question6 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Triangle tgiac = new Triangle();
		tgiac.A.setX(-2);
		tgiac.A.setY(3);
		tgiac.B.setX(5);
		tgiac.B.setY(2);
		tgiac.C.setX(-1);
		tgiac.C.setY(0);

		if (tgiac.isTriangle() == true) {
			if (tgiac.typeTriangle() == -2) {
				System.out.println("Is Acute triangle.");
			}
			if (tgiac.typeTriangle() == -1) {
				System.out.println("Is Obtuse triangle.");
			}
			if (tgiac.typeTriangle() == 0) {
				System.out.println("Is Isosceles Right triangle.");
			}
			if (tgiac.typeTriangle() == 1) {
				System.out.println("Is Right triangle.");
			}
			if (tgiac.typeTriangle() == 2) {
				System.out.println("Is Isosceles triangle.");
			}
			if (tgiac.typeTriangle() == 3) {
				System.out.println("Is Equilateral triangle.");
			}
		}
		else {
			System.out.println("This is not a triangle");
		}

	}

}
