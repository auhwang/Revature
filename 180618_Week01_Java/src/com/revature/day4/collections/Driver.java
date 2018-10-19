package com.revature.day4.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

/*
 * ===Collections===
 * Collections - Utility class for interacting with collections
 * Collection - The base interface that houses most collection classes
 * 
 * 											Collection
 * 				/								|						  \
 * 			   Set			  				   List			  			Queue
 * 			/		\						/	|    \      \ /            |
 * 		SortedSet	HashSet			 Vector ArrayList Vector LinkedList  PriorityQueue
 * 			|
 * 		TreesSet
 * 
 * 											  Object
 * 								/								\
 * 							  Arrays							Collections
 * 
 * 											    Map
 * 								/		   /		    \			\
 * 							HashTable	LinkedHashMap	HashMap		SortedMap
 * 																		|
 * 																	 TreeMap						
 */			
public class Driver {
	public static void main(String[] args) {
		/*
		 * collection: A term for data structures
		 * Collection: The API for java collections
		 * Collections: Utility class for interacting with collections
		 */
		
		//NOTE: Collections only deal with objects. Therefore primitive values are
		// not allowed. But, they will still work because of autoboxing
		
		System.out.println("======LISTS======");
		
		ArrayList l1 = new ArrayList();
		l1.add("Bobbert");
		l1.add(12);
		l1.add(false);
		System.out.println(l1);
		
		/*
		 * Generics
		 * -enforce a type for a collection
		 * 		-This type, could be used as a variable, enforcing dynamically typed lists
		 * 		-In addition to making a strong collection, you can also use generics to
		 * 			dynamically type a collection at runtime. (Parametric polymorphism)
		 */
		
		List<Integer> ints = new ArrayList();
		ints.add(15);
		ints.add(new Integer(20));
		ints.add((int)10);
		ints.add(5);
		//ints.add((byte)39); 		//doesn't work
		System.out.println(ints);
		ints.remove(new Integer(15));
		ints.remove("ryan");
		System.out.println(ints);
		
		System.out.println(ints.get(1));		//retreive element at an index
		
		/*
		 * Methods of List;
		 * -add
		 * -remove
		 * -get
		 * -set	//Sets a specific index to a different number
		 * -listIterator	//Returns a ListIterator Object which iterate back AND forth
		 */
		
		/*
		 * Since all collections in Collection subclasses Iterable, we can use a foreach loop
		 * to iterate through it
		 */
		System.out.println("=====");
		for(int i:ints) {
			System.out.println(i*i);
		}
		
		/*
		 * Iterable offers us iterators, which are interactable cursors for a collection
		 */
		
		System.out.println("====");
		Iterator it1 = ints.iterator();
		System.out.println(it1.next());
		//it1.next(); 	no such element exception
		//To safely iterate through, make sure you use the hasNext() method in
		//conjunction with a while loop
		//put iterator back at element 0;
		it1 = ints.iterator();
		System.out.println(it1.next());
		
		System.out.println("======");
		//List offers us, specifically, a special iterator. The ListIterator
		ListIterator li = ints.listIterator();
		System.out.println(li.next());
		System.out.println(li.next());
		System.out.println(li.previous());
		System.out.println(li.previousIndex()); //retrieve next index called via previous
		
		//LinkedLists
		List ll = new LinkedList();	//linked list's implementation of list methods
		Queue ll2 = new LinkedList();	//linked list's implementation of queue methods
		LinkedList ll3 = new LinkedList();
		
		/*
		 * Doubly Linked List
		 * -Constant insert and deletion
		 * ArrayList
		 * -Random access (search time is faster)
		 * -Not thread safe
		 * -Size increases in +50% increments
		 * Vector
		 * -Thread safe/synchronized
		 * -More overhead
		 * -Size increases at +100% increments
		 */
		
		System.out.println("====SETS====");
		Set<Integer> set = new HashSet();
		set.add(5);
		set.add(10);
		set.add(4);
		set.add(5);
		set.add(1);
		set.add(53);
		set.add(24);
		set.add(132);
		System.out.println(set);
		/*
		 * Sets will not allow duplicate information
		 * In addition it will auto sort based on hash codes
		 */
		System.out.println("======");
		set = new TreeSet<>();
		set.add(5);
		set.add(10);
		set.add(4);
		set.add(5);
		set.add(1);
		set.add(53);
		set.add(24);
		set.add(132);
		System.out.println(set);
		
		System.out.println(set.contains(53));
		//NO RANDOM ACCESS for sets
		
		//TBD Hashcodes

		System.out.println("====Queue====");
		Queue<Integer> q = new LinkedList<>();
		q.offer(5);	//inserts an element from the back
		q.offer(10);
		q.offer(13);
		q.offer(1);
		System.out.println(q);
		System.out.println(q.poll());	//return and remove first item
		System.out.println(q);
		System.out.println(q.peek());	//return but maintain first item
		System.out.println(q);
		
		/*
		 * The queue methods have counterparts (brought from the list family
		 * remove() will remove an element, but throw an exception if queue is empty
		 * add() will add an element, but throw an exception if queue is full
		 * element() which shows the front element, but throws an exception if queue is empty
		 * The queue counterparts do not throw exceptions
		 */
	}
	/*
	 * Comparable Interface
	 * -compareTo
	 * --Define the natural order for that class
	 * Comparator Interface
	 * -Sole purpose is to order objects
	 * -compare
	 * --Designate a class that sorts specific objects in a specific way
	 */
}
