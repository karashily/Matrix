import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Matrix m1 = new Matrix(3,4);
		Matrix m2 = new Matrix(4,2);
		int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10,11,12};
		m1.SetNumbers(arr);
		m2.SetNumbers(arr);
		
		MultiplicationThread mt = new MultiplicationThread(m1, m2);
		Thread thread1 = new Thread(mt, "1");
		Thread thread2 = new Thread(mt, "2");
		
		long t1 = System.currentTimeMillis();
		thread1.start();
		thread2.start();
		// we don`t need joins here as the two threads 
		// results are independent of each other
		
		// but we need joins to calculate the right time
		try {
			thread1.join();
			thread2.join();
			t1 = System.currentTimeMillis() - t1;
			System.out.println("m1 * m2 time = " + t1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		Matrix m4 = new Matrix(500, 500);
		Matrix m5 = new Matrix(500, 500);
		
		int[] arr2 = new int[250000];
		
		Random rd = new Random();
		for (int i=0;i<250000;i++) {
			arr2[i] = rd.nextInt();
		}
		
		m4.SetNumbers(arr2);
		m5.SetNumbers(arr2);
		
		MultiplicationThread mt2 = new MultiplicationThread(m4, m5);
		Thread thread3 = new Thread(mt2, "1");
		Thread thread4 = new Thread(mt2, "2");
		
		long t2 = System.currentTimeMillis();
		thread3.start();
		thread4.start();
		
		try {
			thread3.join();
			thread4.join();
			t2 = System.currentTimeMillis() - t2;
			System.out.println("m4 * m5 time = " + t2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
