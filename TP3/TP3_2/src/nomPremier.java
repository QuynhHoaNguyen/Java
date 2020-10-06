//import java.util.Math;
public class nomPremier {
	public int num;
	
	nomPremier(){
		this.num = 1;
	}
	
	nomPremier(int n){
		this.num = n;
	}
	
	public boolean estUnNombrePremier(int n) {
		if(n<2) {
			return false;
		}
		
		for(int i = 2;i<=(int)Math.sqrt(n);i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}
}
