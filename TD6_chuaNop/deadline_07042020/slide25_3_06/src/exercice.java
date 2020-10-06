
public class exercice {
	// TODO Auto-generated method stub
	int tableA[][] = { { 1, 2 }, { 3, 4 } };
	int tableB[][] = { { 11, 12 }, { 13, 14 } };
	int tableC[][] = new int[2][2];

	void tableA() {

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(tableA[i][j] + "\t");
			}
			System.out.println();
		}
	}

	void tableB() {

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(tableB[i][j] + "\t");
			}
			System.out.println();
		}
	}

	void tableC() {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				tableC[i][j] = 0;
				for (int k = 0; k < 2; k++) {
					tableC[i][j] = tableC[i][j] + tableA[i][k] * tableB[k][j];
				}
			}
		}

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(tableC[i][j] + "\t");
			}
			System.out.println("\n");
		}

	}
}
