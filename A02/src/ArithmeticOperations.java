
public class ArithmeticOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OpNode n1 = new OpNode('+');
		n1.addLeft(new NumNode(3));
		n1.addRight(new NumNode(4));
		
		OpNode n2 = new OpNode('*');
		n2.addLeft(new NumNode(2));
		n2.addRight(n1);
		double x = n2.evaluate();
		System.out.println("Ket qua phep tinh la: " + x);

	}

}
