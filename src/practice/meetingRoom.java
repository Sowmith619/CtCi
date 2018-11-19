package practice;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Interval{
	int start,end;
	Interval(int start, int end){
		this.start = start;
		this.end = end;
	}
}
public class meetingRoom {
	public static List<Interval> init() {
		Interval i1 = new Interval(1,3);
		Interval i2 = new Interval(2,6);
		Interval i3 = new Interval(8,10);
		Interval i4 = new Interval(15,18);
		List<Interval> list = new LinkedList();
		list.add(i4);
		list.add(i1);  
		list.add(i3);  
		list.add(i2);
		return list;
	}
	public static void display(List<Interval> list) {
		for(Interval n:list)
			System.out.print("["+n.start+" "+n.end+"]");
		System.out.println("");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test();
		meetingRoom();
		meetingRoom2();
		mergeIntervals();
		insertInterval();
		meetingPlanner();
	}
	//test priority queue
	public static void test() {
		PriorityQueue<Integer> pqueue = new PriorityQueue<>(5,new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return b-a;
			}
		});  //Collections.reverseOrder()
		
		pqueue.add(5);
		pqueue.add(1);
		pqueue.add(4);
		pqueue.add(2);
		pqueue.add(3);
		for(int n:pqueue)
			System.out.print(n+"-");
		pqueue.removeAll(pqueue);
		System.out.println("size="+pqueue.size());
	}
	//Meeting Room: determine if a person can attend all meeting slots
	public static void meetingRoom() {
		List<Interval> input = init();
		Collections.sort(input, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
					return i1.start-i2.start;
			}
		});
		System.out.print("Sorted input=> ");
		display(input);
		for(int i=1;i<input.size();i++) {
			if(input.get(i).start < input.get(i-1).end) {
				System.out.println("Overlap exist: cannot attend all meeting");
				return;
			}
		}
		System.out.println("Can attend all meeting");
	}
	//find the minimun number of meeting room for the given intervals
	public static void meetingRoom2() {
		List<Interval> input = init();
		Collections.sort(input, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.end-i2.end;
			}
		});
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(input.get(0).end);
		int count=1;
		for(int i=1;i<input.size();i++) {
			if(input.get(i).start<queue.peek())
				count++;
			else
				queue.poll();
			queue.offer(input.get(i).end);
		}
		System.out.println("\nmeetingRoom2 rooms:"+count);
	}
	//merge input, compare overlapping inputs
	public static void mergeIntervals() {	
		List<Interval> input = init();
		List<Interval> result = new LinkedList<>();
		Collections.sort(input, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				if(i1.start>i2.start)
					return i1.start-i2.start;
				else
					return i1.end-i2.end;
			}
		});
		Interval prev = input.get(0);
		for(int i=1;i<input.size();i++) {
			Interval curr = input.get(i);
			if(curr.start>prev.end) {
				result.add(prev);
				prev = curr;
			}else {
				Interval merge = new Interval(prev.start, Math.max(prev.end, curr.end));
				prev=merge;
			}
		}
		result.add(prev);
		System.out.print("\nMerged Interval => ");
		display(result);
	}
	//Insert a new interval
	public static void insertInterval() {
		List<Interval> input = init();
		Collections.sort(input, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.start-i2.start;
			}
		});
		Interval newInterval = new Interval(2,8); //to insert	
		List<Interval> result = new LinkedList<>();
		
		for(Interval interval:input) {
			if(interval.end<newInterval.start) {
				result.add(interval);
			}else if(interval.start>newInterval.end) {
				result.add(newInterval);
				newInterval = interval;
			}else if(interval.end>=newInterval.start || interval.start<=newInterval.end) {
				newInterval = new Interval(Math.min(interval.start, newInterval.start),
						Math.max(interval.end, newInterval.end));
			}
		}
		result.add(newInterval);
		System.out.print("\ninsertInterval Interval => ");
		display(result);
	}
	//meetingPlanner that given the availability, slotsA & slotsB, of two people & a meeting duration 'dur', 
	//returns the earliest time slot that works for both of them and is of duration dur.
	public static void meetingPlanner() {
		List<Interval> input1 = new LinkedList<>();
		input1.add(new Interval(1,3));
		input1.add(new Interval(5,18));
		
		List<Interval> input2 = new LinkedList<>();
		input2.add(new Interval(1,5));
		input2.add(new Interval(9,18));
		int dur = 5;
		
		int p1=0, p2=0;
		while(p1<input1.size() && p2<input2.size()) {
			int start = Math.max(input1.get(p1).start, input2.get(p2).start);
			int end = Math.min(input1.get(p1).end, input2.get(p2).end);
			if(end-start>=dur) {
				int[] time = new int[] {start, start+dur};
				System.out.println("meetingPlanner time: ["+time[0]+" "+time[1]+"]");
				return;
			}
			if(input1.get(p1).end > input2.get(p2).end)
				p2++;
			else if(input1.get(p1).end < input2.get(p2).end)
				p1++;
			else {
				p1++; p2++;
			}
		}
		System.out.println("meetingPlanner: not suitable time found");
	}

}
