
public class Matrix implements Addable {
	public int n, m;
	public int[][] numbers;
	
	@Override
	public void Add(Addable a) {
		Matrix matrix = (Matrix) a;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				numbers[i][j]+= matrix.numbers[i][j];
			}
		}
	}
	
	public Matrix(int n, int m) {
		this.n = n;
		this.m = m;
		this.numbers = new int[n][m];
	}
	
	public boolean SetNumbers(int[] nums) {
		try {	
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					 numbers[i][j] = nums[i*m+j];
				}
			}
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	public void Print() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				 System.out.print(numbers[i][j]);
				 System.out.print(" ");
			}
			System.out.print("\n");
		}
	}
	
	public void Transpose() {
		int[][] matrix = new int[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				matrix[i][j] = numbers[j][i];
			}
		}
		numbers = matrix;
		int temp = n;
		n = m;
		m = temp;
	}
}
