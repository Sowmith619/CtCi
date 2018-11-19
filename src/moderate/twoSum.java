package moderate;

import java.util.Arrays;
import java.util.HashMap;

public class twoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i]))
                return new int[]{map.get(target-nums[i]), i};
            map.put(nums[i],i);
        }
        return new int[0];
    }
    //ice cream Problem - more then 1 occurance : using binarySearch
    //Can be done with hashMap as above
    public int[] twoSum2(int[] nums, int target){
        int[] sortedArr = nums.clone();
        Arrays.sort(sortedArr);
        
        for(int i=0;i<sortedArr.length;i++){
            int complement = target-sortedArr[i];
            int location = Arrays.binarySearch(sortedArr, i+1, sortedArr.length, complement);
            if(location >=0 && location<sortedArr.length && sortedArr[location]==complement){
                int[] indices = getIndicesFromValue(nums, sortedArr[i], complement);
                return indices;
            }
        }
        return new int[0];
    }
    public static int[] getIndicesFromValue(int[] arr, int val1, int val2){
        int index1=-1, index2=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==val1 && index1==-1)
                index1=i;
            if(arr[i]==val2 && index1!=i)
                index2=i;
        }
        int[] indices = new int[]{index1, index2};
        return indices;
    }
}
