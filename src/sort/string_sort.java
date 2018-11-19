package sort;

public class string_sort {
	public static void main(String[] args) {
		System.out.println("String Sort: "+string());
	}
	public static int string() {
		String[] str = new String[] {"at","","","","ball","","","car","","","dad","",""};
		int start=0, end=str.length-1;
		String target = "ball";
		while(start<end) {
			int mid = (start+end)/2;
			//find the next mid from right or left side
			if(str[mid].isEmpty()) {
				int left = mid-1;
				int right = mid+1;
				while(true) {
					if(left<start && right>end)
						return -1;
					else if(right<=end && !str[right].isEmpty()) {
						mid=right;
						break;
					}else if(left>=start && !str[left].isEmpty()){
						mid=left;
						break;
					}
					left--; right++;
				}
				if(str[mid].equals(target))
					return mid;
				else if(str[mid].compareTo(target)>0)
					end=mid-1;
				else
					start=mid+1;
			}
		}
		return -1;
	}
}
