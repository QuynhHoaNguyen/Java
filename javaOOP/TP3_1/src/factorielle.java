
public class factorielle {
	public double index;

	factorielle() {
		this.index = 0;
	}

	factorielle(int n) {
		this.index = n;
	}

	public double valeur(int n) {
		this.index = 1;
		for (int i = 2; i < n; i++) {
			this.index *= i;
		}
		return this.index;
	}
}
