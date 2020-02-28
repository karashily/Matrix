
public class Main {

	public static void main(String[] args) {
		Matrix matrix = new Matrix(3,3);
		int[] nums = new int[]{0,1,2,3,4,5,6,7,8};
		boolean r = matrix.SetNumbers(nums);
		System.out.println(r);
		matrix.Print();
		matrix.Transpose();
		matrix.Print();
		
		
		IdentityMatrix identity = new IdentityMatrix(3);
		int[] rightNums = new int[] {1,0,0,0,1,0,0,0,1};
		int[] wrongNums = new int[] {1,0,0,0,2,0,0,0,1};		
		r = identity.SetNumbers(wrongNums);
		System.out.println(r);
		r = identity.SetNumbers(rightNums);
		System.out.println(r);
		identity.Print();
		identity.Transpose();
		identity.Print();
		
		matrix.Add(identity);
		matrix.Print();
		identity.Print();
	}

}
