package hard;

public class appointment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		maxMinutes();
	}
	//Given a sequence of back-to-back appointment requests (all multiples of 15 minutes, none overlap, and none can be moved), 
	//find the optimal(highest total booked minutes) set the masseuse can honor. Return the number of minutes.
	//RT: O(n)  space:O(1)
	public static void maxMinutes() {
		int[] massages = new int[] {15,30,15,15};
		int oneAway=0;
		int twoAway=0;
		for(int i=massages.length-1;i>=0;i--) {
			int bestWith = massages[i]+twoAway;
			int bestWithout = oneAway;
			int curr = Math.max(bestWith, bestWithout);
			twoAway = oneAway;
			oneAway = curr;
		}
		System.out.println("max="+oneAway);
	}

}
