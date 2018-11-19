package java_basic;

public class ThreadTest extends Thread{

	public synchronized void run() {
		System.out.println("running");
		try {
			System.out.println("currentThread(): "+Thread.currentThread().getName());
			if(Thread.currentThread().isDaemon()) {
				System.out.println("DAEMON: "+Thread.currentThread().getName());
			}else {
			for(int i=0;i<=5;i++) {
				Thread.sleep(0);
				System.out.print(i+" - ");
			}
		}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("running, after sleeping");
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ThreadTest t1 = new ThreadTest(); //Thread-0
		ThreadTest t2 = new ThreadTest(); //Thread-1
		ThreadTest t3 = new ThreadTest(); //Thread-2
		
		t1.setPriority(MIN_PRIORITY);
		t2.setPriority(MAX_PRIORITY);
		t3.setPriority(MAX_PRIORITY);
		
		//Deamon are service threads
		t1.setDaemon(true);
		
		t1.start(); 
		t2.start();
		t3.start();
		
		Runtime r = Runtime.getRuntime();
		r.addShutdownHook(new ThreadTest());
		
		System.out.println("\n\nNow main sleeping... press ctrl+c to exit");
		try {
			//Runtime.getRuntime().exec("notepad");
			Thread.sleep(3000);
		}catch(Exception e) {
			
		}
	}

}
