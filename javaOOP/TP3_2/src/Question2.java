
public class Question2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		nomPremier nomPre = new nomPremier();
		nomPre.num = 9;
		if(nomPre.estUnNombrePremier(nomPre.num) == true) {
			System.out.println(nomPre.num + " est un nombre premier.");
		}
		else {
			System.out.println(nomPre.num + " n'est pas un nombre premier.");
		}
	}

}
