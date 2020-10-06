
public class ExcTest1 {
	static void genException() {
		int nums[] = new int[4];
		System.out.println("Before exception is generated");
		//generatie an index out-of-bounds exception
		nums[3]=10;
		System.out.println("this won't be displayed");
	}
}
