
public class palindromes {
	public int num;
	
	palindromes(){
		this.num = 102;
	}
	
	palindromes(int n){
		this.num = n;
	}
	
	public int inverse(int n) {
		int tmp;
		int numOut = 0;

		while (n > 0) {
			tmp = n % 10;
			numOut = numOut * 10 + tmp;
			n = n / 10;
		}
		return numOut;
	}
	
	public boolean estPalindromes(int n) {
		if(inverse(n)==n) {
			return true;
		}
		else {
			return false;
		}
	}
}
