
import java.lang.Math;

public class question2 {
	// convert decimal to binary
	int rem;

	int DecToBinary(int dec) {
		int binaryNumber = 0;
		int i = 1;
		do {
			rem = dec % 2;
			binaryNumber = binaryNumber + (i * rem);
			dec = dec / 2;
			i = i * 10;
		} while (dec > 0);
		return binaryNumber;
	}

	// convert decimal to octal
	int DecToOct(int dec) {
		int exponent = 0;
		int octNumber = 0;
		do {
			rem = dec % 8;
			octNumber += rem * Math.pow(10, exponent);
			exponent++;
			dec /= 8;
		} while (dec > 0);
		return octNumber;
	}

	// convert decimal to hex
	void DecToHex(int dec) {
		char[] hexNumber = new char[100];
		int index = 0;
		do {
			int temp = 0;
			temp = dec % 16;
			if (temp < 10) {
				hexNumber[index] = (char) (temp + 48);
				index++;
			} else {
				hexNumber[index] = (char) (temp + 55);
				index++;
			}
			dec /= 16;
		} while (dec != 0);
		for (int i = index - 1; i >= 0; i--)
			System.out.print(hexNumber[i]);
	}
}
