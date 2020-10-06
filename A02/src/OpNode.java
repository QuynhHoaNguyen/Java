
public class OpNode implements Node{
	public char symbol;
	public Node left;
	public Node right;
	
	OpNode(char sym){
		this.symbol = sym;
	}
	
	public void addLeft(Node x) {
		this.left = x;
	}
	
	public void addRight(Node y) {
		this.right = y;
	}
	
	public double evaluate() {
		switch(this.symbol) {
		case '+':
			return (left.evaluate() + right.evaluate());
		case '-':
			return (left.evaluate() - right.evaluate()); 
		case '*':
			return (left.evaluate() * right.evaluate()); 
		case '/':
			return (left.evaluate() / right.evaluate()); 
		default:
			return 0;
		}

	}
}
