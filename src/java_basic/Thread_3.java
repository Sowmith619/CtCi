package java_basic;

class Lock2 {
	private boolean isLocked=false;
	public synchronized void lock() throws InterruptedException {
		//System.out.println("inside lock():"+Thread.currentThread().getName()+":"+isLocked);
		System.out.println("inside lock():"+Thread.currentThread().getName()+":"+isLocked);
		while(isLocked) {
			wait();
		}	
		isLocked=true;
	}
	public synchronized void unlock() {
		isLocked=false;
		notify();
	}
}
public class Thread_3 implements Runnable{
	private static int count=0;
	public static Lock2 lock = new Lock2();
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread[] th = new Thread[5];
		for(int i=0;i<th.length;i++) {
			th[i]=new Thread(new Thread_3());
			th[i].setName(Integer.toString(i));
			th[i].start();
		}
		for(Thread t:th)
			t.join();
		System.out.println("Main Count::"+count);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Thread:"+Thread.currentThread().getName()+" count="+calcu1());
	}
	public synchronized int calcu1() {
		count++;
		return count;		
	}
	public int calcu2() {
		try {
			lock.lock();
			count++;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			/*if(Thread.currentThread().getName().equals("1"))
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				lock.unlock();
		}
		return count;		
	}
}
