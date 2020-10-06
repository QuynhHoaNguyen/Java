
public class Question4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		palindromes palin = new palindromes();
		palin.num = 1234321;
		if(palin.num == 0) {
			System.out.println("un nombre non negatif, svp!");
		}
		if(palin.estPalindromes(palin.num)==true){
			System.out.println(palin.num + " est nombre palindromes.");
		}
		else {
			System.out.println(palin.num + " n'est pas un palindromes");
		}
		

	}

}
