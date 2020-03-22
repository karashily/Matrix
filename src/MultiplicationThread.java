
public class MultiplicationThread implements Runnable {
	private Matrix A;
	private Matrix B;
	private Matrix result;
	
	public MultiplicationThread (Matrix firstMatrix, Matrix secondMatrix) {
		A = firstMatrix;
		B = secondMatrix;
		result = new Matrix(A.n, B.m);
	}
	
	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		if (threadName.equals("1")) {
			Matrix newA = new Matrix(A.n, A.m);
			
			for (int i=0;i<A.n/2;i++) {
				for (int j=0;j<A.m;j++) {
					newA.numbers[i][j] = A.numbers[i][j];
				}
			}
			
			for (int i=A.n/2;i<A.n;i++) {
				for (int j=0;j<A.m;j++) {
					newA.numbers[i][j] = 0;
				}
			}
			
			try {
				Matrix newRes = new Matrix(result.n, result.m);
				newRes = newA.multiply(B);
				result = (Matrix) newRes.Add(result);
			} catch (Matrix.MultiplicationException e) {
				e.message();
			}
			
		} else if (threadName.equals("2")) {
			Matrix newA = new Matrix(A.n, A.m);
			
			for (int i=0;i<A.n/2;i++) {
				for (int j=0;j<A.m;j++) {
					newA.numbers[i][j] = 0;
				}
			}
			
			for (int i=A.n/2;i<A.n;i++) {
				for (int j=0;j<A.m;j++) {
					newA.numbers[i][j] = A.numbers[i][j];
				}
			}
			
			try {
				Matrix newRes = new Matrix(result.n, result.m);
				newRes = newA.multiply(B);
				result = (Matrix) newRes.Add(result);
			} catch (Matrix.MultiplicationException e) {
				e.message();
			}
			
		}
	}

}
