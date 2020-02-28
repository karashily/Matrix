
public class IdentityMatrix extends Matrix {

	public IdentityMatrix(int n) {
		super(n, n);
	}
	
	@Override
	public boolean SetNumbers(int[] nums) {
		if(n != m) return false;
		for(int i=0;i<n*n;i++) {
			if( i%(n+1)!=0 && nums[i] != 0 || i%(n+1)==0 && nums[i] != 1) {
				return false;
			}
		}
		return super.SetNumbers(nums);
	}
	
	@Override
	public void Transpose() {
		
	}
	
}
