
public class LogicalOpTable_1752017 {
	public static void main(String[] args) {
		  boolean P1 = true, P0 = false;
		  boolean Q1 = true, Q0 = false;
		  int Ptrue = 1, Pfalse = 0;
		  int Qtrue = 1, Qfalse = 0;
		  
		  System.out.println("P \t Q \t AND \t OR \t XOR \t NOT \t");
		  System.out.println(P1 +"\t" + Q1 +"\t" + (P1 & Q1) +"\t" + (P1 | Q1) +"\t" + (P1 ^ Q1) +"\t" + !(P1 & Q1));
		  System.out.println(P1 +"\t" + Q0 +"\t" + (P1 & Q0) +"\t" + (P1 | Q0) +"\t" + (P1 ^ Q0) +"\t" + !(P1 & Q0));
		  System.out.println(P0 +"\t" + Q1 +"\t" + (P0 & Q1) +"\t" + (P0 | Q1) +"\t" + (P0 ^ Q1) +"\t" + !(P0 & Q1));
		  System.out.println(P0 +"\t" + Q0 +"\t" + (P0 & Q0) +"\t" + (P0 | Q0) +"\t" + (P0 ^ Q0) +"\t" + !(P0 & Q0));
		  
		  System.out.println("\n");
		  
		  System.out.println("P \t Q \t AND \t OR \t XOR \t NOT \t");
		  System.out.println(Ptrue +"\t " + Qtrue +"\t " + (Ptrue & Qtrue) +"\t " + (Ptrue | Qtrue) +"\t " + (Ptrue ^ Qtrue) +"\t " + ((1- Ptrue) & Qtrue));
		  System.out.println(Ptrue +"\t " + Qfalse +"\t " + (Ptrue & Qfalse) +"\t " + (Ptrue | Qfalse) +"\t " + (Ptrue ^ Qfalse) +"\t " + ((1-Ptrue) & Qfalse));
		  System.out.println(Pfalse +"\t " + Qtrue +"\t " + (Pfalse & Qtrue) +"\t " + (Pfalse | Qtrue) +"\t " + (Pfalse ^ Qtrue) +"\t " + ((1- Pfalse) & Qtrue));
		  System.out.println(Pfalse +"\t " + Qfalse +"\t " + (Pfalse & Qfalse) +"\t " + (Pfalse | Qfalse) +"\t " + (Pfalse ^ Qfalse) +"\t " + ((1 - Pfalse) & Qfalse));
		 }
}
