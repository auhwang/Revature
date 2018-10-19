package com.revature.day2.garbagecollection;

/*
 * Java does not let you, the developer, handle memory. Java takes full control of that itself.
 * This is done using the garbage collector. An execution which serves to only ensure that we don't
 * have any unreachable, unreferenced objects sitting around cluttering up memory
 * 
 * Any object in Java is eligible for garbage collection if one of the following criteria are met:
 * -Reference points to null
 * --Object o = new Object()
 * --Object o = null;	//the new object is eligible for collection at this point
 * -method that created object ends;
 * --method(){
 * 		object o = new object()
 *  }
 *  //at this point, o can be collected
 *  -Object is reassigned
 *  --Object o = new Object();
 *  --o = new Object(); <-- at this point the previous object is eligible
 */
public class CrumpledNewspaper {
	public int id;
	public CrumpledNewspaper(int id) {
		this.id = id;
		System.out.println("created");
	}
	@Override	//override means to give your own implementation to a method inherited from a parent
	protected void finalize() throws Throwable {
		/*
		 * This method does nothing for garbage collection
		 * However, this method will be executed by the garbage collector before the object
		 * is finally collected. It will be the last method this object ever executes
		 */
		System.out.println("\t\t" + id + " Collected");
		super.finalize();
	}
}
