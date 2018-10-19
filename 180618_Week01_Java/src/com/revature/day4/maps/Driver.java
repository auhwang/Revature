package com.revature.day4.maps;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Driver {
	public static void main(String[] args) {
		/*
		 * Maps are a collection of key/value pairs
		 * More specifically, a combination of a keyset and entry values
		 * It is worth noting that maps are NOT a part of the Collection API
		 */
		Map<Integer,String> map = new HashMap<>();
		map.put(1, "Dora");
		map.put(2, "Boots");
		map.put(3, "Map");
		map.put(4, "Diego");
		map.put(2, "Swiper");
		map.put(0, null);
		map.put(null, null);
		map.put(null, "zero");
		
		for(Integer i:map.keySet()) {
			System.out.println(i + ": " + map.get(i));
		}
		//If a key that already exists is entered, it is overwritten
		
		Hashtable<Integer,String> ht = new Hashtable();
		ht.put(1, "Dora");
		ht.put(2, "Boots");
		ht.put(3, "Map");
		ht.put(4, "Diego");
		ht.put(2, "Swiper");
		//ht.put(0, null);		//NPE
		//ht.put(null, null);	//NPE
		//ht.put(null, "zero");	//NPE
		
		/*
		 * Hashtable vs HashMap
		 * -The key difference between Hashtables and HashMaps is that Hashtables do not accept null
		 * keys OR values
		 * -Hashmaps are not synchronized, hashtables are
		 * -Hashtables are considered a legacy class
		 * 		-Legacy classes are classes that are from an older verion of java that have proper
		 * 		replacements (IE HashMap in this case) but they can still have use and therefore are
		 * 		not a candidate for deprecation. (In this case, Hashtable is threadsafe)
		 */
	}
}
