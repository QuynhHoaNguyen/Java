
public class Exercice25_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = { 1, 2, 3, 4, 5 };
		int B[] = { 5, 4, 1, 2, 3 };
		int count = 0;
		if (A.length == B.length) {
			for (int i = 0; i < A.length; i++) {
				for (int j = 0; j < B.length; j++) {
					if (A[i] == B[j]) {
						count++;
					} else {
						count--;
					}
				}
			}
			if (count == 5) {
				System.out.println("B est une permutation de A");
			} else {
				System.out.println("B n'est pas une permutation de A");
			}
		} else {
			System.out.println("B n'est pas une permutation de A");
		}
	}
}
