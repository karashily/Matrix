
public class Matrix implements Addable {
	public int n, m;
	public int[][] numbers;
	
	static final class MultiplicationException extends Exception {
		public String errorMessage;
		
		public MultiplicationException(String msg) {
			errorMessage = msg;
		}
		
		public void message() {
			System.out.println(errorMessage);
		}
	}
	
	
	@Override
	public Addable Add(Addable a) {
		Matrix matrix = (Matrix) a;
		Matrix result = new Matrix(n, m);
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				result.numbers[i][j]= numbers[i][j] + matrix.numbers[i][j];
			}
		}
		return result;
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
	
	public Matrix multiply(Matrix B) throws MultiplicationException {
		if(this.m != B.n) {
			throw new MultiplicationException("Exception Occured while trying to multiply matricies of dimensions (" + this.n +"," + this.m + ") and (" + B.n + "," + B.m + ")");
		}
		int resultRows = this.n;
		int resultCols = B.m;
		int thirdDim = this.m;
		Matrix result = new Matrix(resultRows, resultCols);
		for(int i=0;i<resultRows;i++) {
			for(int j=0;j<resultCols;j++) {
				int element = 0;
				for(int k=0;k<thirdDim;k++) {
					element += this.numbers[i][k] * B.numbers[k][j];
				}
				result.numbers[i][j] = element;
			}
		}
		return result;
	}
}
