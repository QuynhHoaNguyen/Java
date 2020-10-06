package slide25_2;

import java.util.Scanner;

public class slide25_2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n, i = 0;
		Scanner in = new Scanner(System.in);

		do {
			System.out.println("Nhap so phan tu cua mang: ");
			n = in.nextInt();
			
		} while (n < 0);

		int A[] = new int[n];

		System.out.println("Nhap cac phan tu cho mang: ");
		do {
			int flag = 0;
			System.out.print("Nhap phan tu thu " + i + ": ");
			A[i] = in.nextInt();
			
			for (int j = i - 1; j >= 0; j--) {
				if (A[i] == A[j]) {
					System.out.println("Phan tu da ton tai, ban hay nhap lai phan tu khac!");
					flag = 1;
					break;
				}
			}
			if (flag == 1) {
				continue;
			} else {
				i++;
			}
		} while (i < n);
		in.close();
		System.out.println("Mang da nhap la: ");
		for (i = 0; i < n; i++) {
			System.out.print(A[i] + "\t");
		}
	
	}
}
