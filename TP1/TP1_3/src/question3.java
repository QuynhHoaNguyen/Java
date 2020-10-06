//import java.util.Scanner;

public class question3 {

	void showMenu() {
		System.out.println(" 1. Add. \n 2. Sub. \n 3. Mutiply. \n 4. Divide. \n");
	}

	void output(String a, String b) {
		System.out.println("The two binary numbers entered are: " + a + ", " + b);
	}

	String add(String a, String b) {
		String result = "";
		int sum = 0;
		// duyet ca hai chuoi bat dau tu vi tri cuoi cung
		int ai = a.length() - 1;
		int bi = b.length() - 1;
		while (ai >= 0 || bi >= 0 || sum == 1) {
			if (ai >= 0)
				sum += a.charAt(ai) - '0';
			else
				sum += 0;

			if (bi >= 0)
				sum += b.charAt(bi) - '0';
			else
				sum += 0;

			result = (char) (sum % 2 + '0') + result;
			sum /= 2;
			ai--;
			bi--;
		}
		return result;
	}

	int sub(int a, int b) {
		int sub;
		sub = a + (~b + 1);
		return sub;
	}

	int mutiply(int a, int b) { 
        int res = 0;   
        while (b > 0) 
        { 
             if ((b & 1) != 0) 
                 res = res + a; 
  
            a = a << 1; 
            b = b >> 1; 
        } 
        return res;
	}
	String divide(String a, String b) {
		String num="a/b";
		return num;
	}
}
