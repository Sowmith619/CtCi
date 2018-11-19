package java_basic;
class Lock{
	  private boolean isLocked = false;
	  public synchronized void lock() throws InterruptedException{
		    while(isLocked){
		    	wait();
		    	System.out.println(Thread.currentThread().getName()+" waiting..");
		    }
		    isLocked = true;
	  }
	
	  public synchronized void unlock(){
		    isLocked = false;
		    notify();
	  }
}

public class Thread_2 implements Runnable{
static int count=0;
private Lock lock = new Lock();
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//If not extending the Thread class,the class object would not be treated as a thread object.
		//So need to explicitely create Thread class object. We pass the object of the class that implements Runnable 
		//so that the class run() method may execute.
		Thread[] th = new Thread[10]; 
		 
		for(int i=0; i<th.length; i++) { 
			th[i] = new Thread(new Thread_2());
			th[i].start();
		}
		
		/*Thread_2 o1 = new Thread_2();
		Thread t1 = new Thread(new Thread_2());
		Thread t2 = new Thread(new Thread_2());
		Thread t3 = new Thread(new Thread_2());
		Thread t4 = new Thread(new Thread_2());
		t1.start();
		t2.start();
		t3.start();
		t4.start();*/
		//t1.stopRunning();
		
		//wait for all thread to stop
		for(Thread t:th) {
			t.join();
		}
		Thread.sleep(500);
		System.out.println(Thread.currentThread().getName()+" main_count:"+count);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Thread running:"+Thread.currentThread().getName());
		for(int i=0;i<=0;i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println(i);
		}
		
		System.out.println(Thread.currentThread().getName()+"->count:: "+inc1());
	}
	public int inc1() {
		synchronized(this) {
		   return ++count;
		}
	}
	public int inc2() {
		 try {
			lock.lock();
			//Thread.sleep(1000);
			count++;
			return count;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		 return 0;
	}
}
