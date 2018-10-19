package com.revature.day5.threads;

/*
 * Multithreading
 * -Multiple executions in an application running concurrently
 * --Timesplicing
 * --Priority
 * 		-low 1
 * 		-max 10
 * 		-default 5
 * 
 * Thread States
 * -new				Thread created
 * -runnable		Thread.start()
 * -waiting			Thread.wait()
 * -timedwaiting	Thread.wait(50)
 * -blocked			
 * -terminated		End of execution
 * 
 * Synchronized
 * -No more than one thread may access this resource at a time IE threadsafe
 * Deadlock
 * -2 or more threads are requesting each other's resources, but not giving them up until
 * 	they get another
 * Livelock
 * -A thread can't go on until another thread takes itd resource, but the other threads want
 * their resource taken as well
 * Starvation
 * -2 or more threads are blocked and will never be unblocked
 * 
 * Producer
 * -fill the queue
 * -but do not overflow it
 * -if full
 * -notify
 * -sleep
 * -if not
 * -notify and produce
 * Consumer
 * -empty the queue
 * -but should not take when empty
 * -After every consumption check size()
 * -if 0
 * -notify
 * -sleep
 * -if above 0 
 * -notify and consume
 */
public class Driver {
	public static void main(String[] args) {
		/*
		 * With Threads, you create a Thread instance, and pass it our instance of
		 *  a class implementing runnable, or thread. Optionally, you can give it
		 *  a name as well. When you finally want to fork the thread on its own path,
		 *  you will use the start() method! ,---important
		 */
		
		Thread t1 = new Thread(new RunnableThread(),"Thread1");
		Thread t2 = new Thread(new ThreadThread(),"Thread2");
		System.out.println("Beginning Thread Execution");
		t1.start();
		t2.start();
		System.out.println("Ending Thread Execution");
	}
	/*
	 * Notable Thread methods
	 * -sleep: Put the thread in a wait state (can be interrupted
	 * -wait: Put the thread in a wait state (cannot be interrupted)
	 * -notify: Wake up one of the sleeping threads
	 * -notifyAll: Wake up all sleeping threads
	 * -isDaemon: Checks to see if a thread is a daemon thread
	 * 		-NOTE: Daemon meaning the thread runs, even after the main thread has ended
	 * -join(): Have a specific thread end execution and merge into another active thread
	 * -isAlive: Checks if thread is finished yet
	 * -start: start the thread
	 */
}
