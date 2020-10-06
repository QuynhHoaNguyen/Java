
public class NumNode implements Node{
	public double NumNode;
	
	NumNode(double num){
		this.NumNode = num;
	}
	public double evaluate() {
		return this.NumNode;
	}
}
