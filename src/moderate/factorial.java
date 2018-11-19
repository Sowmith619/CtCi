package moderate;

public class factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		countFact();
		countFactZeros();
	}
	public static void countFact() {
		int num=19;
		int count=0;
		for(int i=2;i<=num;i++) {
			count+=factOf5(i);
		}
		System.out.println("Fact trailing zero for "+num+" = "+count);
	}
	public static int factOf5(int n) {
		int count=0;
		while(n%5==0) {
			count++;
			n=n/5;
		}
		return count;
	}
	//optimized
	public static void countFactZeros() {
		int num=19;
		int count=0;
		for(int i=5;num/i>0;i*=5)
			count+=num/i;
		System.out.println("(2)Fact trailing zero for "+num+" = "+count);
	}
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0]=1;
        for(int i=1;i<nums.length;i++){
            res[i]=res[i-1]*nums[i-1];
        }
        // 1 2 3 4 = 1 1 2 6
        // 1 2 3 4 = 12 8 6
        int temp=1;
        for(int i=nums.length-1;i>=0;i--){
            res[i]=res[i]*temp;
            temp*=nums[i];
        }
        return res;
    }

}
