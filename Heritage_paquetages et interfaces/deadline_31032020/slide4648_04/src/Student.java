
public class Student {
	public String i_StudentID;
	public String i_FullName;
	public String i_DateOfBirth;
		
	Student(){
		i_StudentID = "1752017";
		i_FullName = "Nguyen Thi Quynh Hoa";
		i_DateOfBirth = "02/11/1998";
	}
	Student(String id, String name, String date){
		i_StudentID = id;
		i_FullName = name;
		i_DateOfBirth = date;
	}
	
	public String toString(){
		return i_StudentID + "\n" +  i_FullName + "\n" +  i_DateOfBirth;
	}
	
	public static void main(String args[]) {
		Student st1 = new Student("1553002", "Le Cong Canh", "01/10/1997");
		System.out.println(st1);
		Student st2 = new Student("1553007", "Nguyen Thanh Du", "28/12/1997");
		System.out.println(st2);
	}
}

