package moderate;

public class string {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		longestCommonPrefix();
	}
	public static void longestCommonPrefix() {
		String[] strs = new String[] {"leetcode", "eleet", "lee"};
		String prefix=strs[0];
		if(strs==null || strs.length==0) {
			System.out.println("LowestCommonPrefix: ");
			return;
		}
		for(int i=1;i<strs.length;i++) {
			while(strs[i].indexOf(prefix)!=0) {
				System.out.println(prefix);
				prefix = prefix.substring(0, prefix.length()-1);
				if(prefix.isEmpty()) {
					System.out.println("LowestCommonPrefix: ");
					return;
				}
			}
		}
		System.out.println("LowestCommonPrefix:: "+prefix);		
	}

}
