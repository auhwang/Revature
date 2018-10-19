package com.revature.day5.threads;

/*
 * There are 2 different ways to create a thread in java A thread is a simple
 * flow of execution
 * Multithreading is when multiple threads have breached off of the main thread and
 * execute concurrently
 * 
 * The goal of multithreading would be to share the work load among multiple threads in an
 * effort to finish a task faster
 * 
 * With threads, Java has 2 ways to create a thread. These two ways include:
 * -Implementing the Runnable interface
 * -Extending the Thread class
 */
public class RunnableThread implements Runnable{
	/*
	 * In either case for creating a thread, you must implement the run()
	 * method. This method contains the tasks your seperate thread will run
	 * When you start the Thread, it will execute the run method
	 */
	@Override
	public void run() {
		for(int i = 0; i < 20; i++) {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(50);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	
}
