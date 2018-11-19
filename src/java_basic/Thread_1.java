package java_basic;

public class Thread_1 extends Thread{
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread_1 t1 = new Thread_1();
		Thread_1 t2 = new Thread_1();
		t1.start();
		//t1.join(1000);
		t2.start();
		//t1.setName("Thread1");
		//System.out.println(t1.getName()+":"+t1.getId());
		//System.out.println(Thread.currentThread().getName());  
		//t1.stop();
	}
	@Override
	public void run() {
		//System.out.println("Thread running..");
		System.out.println(Thread.currentThread().getName());  
		for(int i=0;i<=5;i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}

}
