
public class nomInverse {
	public int num;

	nomInverse() {
		this.num = 123;
	}

	nomInverse(int n) {
		this.num = n;
	}

	public void sortie(int n) {
		int tmp;
		int numOut = 0;

		while (n > 0) {
			tmp = n % 10;
			numOut = numOut * 10 + tmp;
			n = n / 10;
		}
		System.out.println(numOut);
	}
}
