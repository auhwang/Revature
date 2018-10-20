package com.revature.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Item;
import com.revature.util.HibernateUtil;

public class ItemDaoImple {
	public List<Item> getAllitems(){
		List<Item> items = null; //At this point, we have a transient state.
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			items = session.createQuery("FROM Item").list(); //At this point, items is persistent
			items.toString();
			
		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close(); 
		}
		return items;
	}

	/*
	 * Get vs Load
	 * The key difference between these two retrieval methods is that one
	 * can be considered lazy, while the other can be considered eager
	 * Get: This is our eacher retrieval example. Get will hit the database
	 * immedietly and populate all the data on the spot for you. If no data 
	 * exists, it can provide 'null' in its place
	 * Typically you want to use this if you are not sure that the object
	 * exists in the DB
	 * 
	 * Load: This is considered our lazy retrieval. It provides back to us 
	 * a proxy of the object.
	 * -A proxy is just a simple pseudo implementation of the object structure
	 * that is provided for us to use. This is why we have access to the object's
	 * getters and setters
	 * The database is only hit when you need access to the actual data of the object.
	 * Since up to that point, hibernate assumed the object existed, and when it finds
	 * out that the data isn't actually there, we are greeted with the objectnotfound exception
	 */
	public Item getVsLoad(){
		Item item = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			System.out.println("------Get------");
			item = (Item)session.get(Item.class, 1);
			System.out.println("yo");
			System.out.println(item);
			
			System.out.println("----Load----");
			item = (Item)session.load(Item.class, 1);
			System.out.println("yo");
			System.out.println(item);
			
			System.out.println("====getvsload no data=====");
			System.out.println("------Get------");
			item = (Item)session.get(Item.class, 1000);
			System.out.println("yo");
			System.out.println(item);
			
			System.out.println("----Load----");
			//item = (Item)session.load(Item.class, 2000);
			System.out.println("yo");
			System.out.println(item);
			
			System.out.println("=====lvl1 caching====");
			item = (Item)session.load(Item.class, 4);
			System.out.println(item);
			item = (Item)session.load(Item.class, 4);
			System.out.println(item);
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close(); 
		}
		return item;
	}
	
	/*
	 * Save vs Persist
	 * -They are neither lazy nor eager, but could be compared to it
	 * -when you can save on an object, you persist it with the database
	 * -therefore, when calling save, you are returned a number that represents
	 *  a unique record in the database
	 * -However, with persist, it is not inserted into the database right away
	 *  A position is saved for the insert, it just doesn't have an Id yet.
	 *  The Id is assigned to the new record 'eventually', just not right away.
	 *  -The only guarantee you get is that the data will be completely inserted
	 *   before flush time at the latest. (Flush time means the point where the
	 *   database and persistent object are the same
	 */
	public void SaveVsPersist() {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
//			Item item = new Item("Premium Water", 900);
//			item.setShops(((Item)session.get(Item.class, 1)).getShops());
//			
//			
//			System.out.println( "BEFORE SAVE: " + item.getId());
//			System.out.println("-----SAVE-----");
//			System.out.println("ID IS:" + session.save(item));
//			//When saving we are returned the id.
//			System.out.println("AFTER SAVE:" + item.getId());
			

			
			Item item2 = new Item("Deluxe Premium Super Awesome Bargain Water", 12);
			System.out.println("-----persist-----");
			System.out.println( "BEFORE Persist: " + item2.getId());
			session.persist(item2);
			System.out.println("AFTER PERSIST:" + item2.getId());

			//We are not guaranteed an ID right away, so we have to return nothing.
			
			tx.commit();
			
		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close(); 
		}
	}
	
	public void mergeVsUpdate(){
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			Item item1 = new Item("Hairy Water", 1200);
			Item item2 = null;
			Integer ID;
			
			ID = (Integer) session.save(item1);			
			tx.commit();
			session.close();
			session = HibernateUtil.getSession();
			tx =session.beginTransaction();
			
			item2 = (Item)session.get(Item.class, ID);
			item1.setName("Crazy Water");
			session.merge(item1);
			System.out.println(item2.getName());
			tx.commit();
			session.close();
			
			session = HibernateUtil.getSession();
			tx =session.beginTransaction();
			item2.setName("Dasani");
			
			session.update(item2);
			
			
			
			
			
		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close(); 
		}
		/*
		 * Merge vs Updata
		 * -update and merge will re-attach a detached object to a persistent state
		 * -update throws an exception is you try to invoke it on an object when the session
		 * already has a persistent object for that record
		 * -Merge will follow through with the update by taking the contents of the object you
		 * are trying to update with an overwriting the contents of the current persistent
		 * object with its own
		 */
	}
}

