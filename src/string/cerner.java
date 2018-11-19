package string;

import java.util.HashMap;

public class cerner {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		/*sum_2();
		sum_3();
		sum_4();*/
		throw new Exception();
		/*try {
			System.out.println("Inside try");
			throw new Exception();
		}catch(Exception e){
			System.out.println(e);
			//e.printStackTrace();
		}*/
	}
	public static void sum_2() {
		HashMap<Integer, Integer> map = new HashMap<>();
		int[] nums = new int[] {1,2,3,4,5,6,7};
		int target = 10;
		for(int i=0;i<nums.length;i++) {
			if(map.containsKey(target-nums[i])) {
				System.out.println(i+":"+ map.get(target-nums[i]));
			}
			map.put(nums[i], i);
		}
	}
	public static void sum_3() {
		int[] arr = new int[] {1,2,3,4,5};
		int target=10;
		for(int i=0;i<arr.length;i++) {
			int p1=i+1;
			int p2=arr.length-1;
			while(p1<p2) {
				int sum=arr[i]+arr[p1]+arr[p2];
				if(sum==target) {
					System.out.println("Target found:"+target);
					System.out.println(arr[i]+":"+arr[p1]+":"+arr[p2]);
					return;
				}
				if(sum<target)
					p1++;
				else
					p2--;
			}
		}
	}
	public static void sum_4() {
		int[] arr = new int[] {1,2,3,4,5,6,7,8};
		int target=17;
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				int p1=j+1;
				int p2=arr.length-1;
				while(p1<p2) {
					int sum = arr[i]+arr[j]+arr[p1]+arr[p2];
					if(sum==target) {
						System.out.println("Target found:"+target);
						System.out.println(arr[i]+":"+arr[j]+":"+arr[p1]+":"+arr[p2]);
						return;
					}
					if(sum<target)
						p1++;
					else
						p2--;						
				}
			}
		}
	}
	
	

}
