package com.revature.day2.accessmods2;
import com.revature.day2.accessmods.Silence;
//Import to access classes from other packages
//ctrl + shift + o auto imports missing packages
public class Driver extends Silence{
	public static void main(String[] args) {
		//different package so doesn't work unless package is imported
		Silence silence = new Silence(); 
		silence.output();
		
		System.out.println("====ACCESS VIA METHOD OUTSIDE CLASS. OUTSIDE PACKAGE====");
		
		//System.out.println(priv);
		//System.out.println(def);
		//System.out.println(prot);
		System.out.println(silence.pub);	//only public is allowed outside of package without Inheritance
		Driver d = new Driver();
		
		System.out.println(d.pub);
		System.out.println(d.prot); //since driver inherits from silence, we have access to protected
									//elements as well
		//System.out.println(d.def);
		//System.out.println(d.priv);
	}
}
