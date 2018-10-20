package com.revature.main;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Npc;
import com.revature.service.NpcService;
import com.revature.util.Connections;

/*
 * JDBC - Java Database Connectivity
 * 				Java Application
 * 						|
 * 					JDBC API
 * 						|
 * 				JDBC Driver Manager
 * 						|
 * 					JDBC Driver
 * 						|
 * 					  Oracle
 * 
 * Components/interfaces
 * 				   Driver Manager - Manages the different database drivers
 * 						|
 * 					  Driver	- Interface that handles communications with a specific database
 * 						|
 * 					Connection	- Object in charge of establishing database communication
 * 						|
 * 					Statement	- Object that is used to submit sql statements
 * 						|
 * 				   Results Set	- Houses statement results
 * 						|
 * 				  SQL Exception
 * 
 * SQL Injection
 * -The act of a user inputting malicous data in order to compromise a database
 * 	-xkcd comic
 * -username
 * -password
 * 
 * Simple statement - compiled on sql side
 * -general purpose access to your database
 * -useful for simple statements with static queries
 * -risks sql injection with dynamic queries
 * 
 * prepared statement - precompiled on java side
 * -more dynamic
 * -parameterized
 * -accepts input at runtime
 * -prevents sql injection
 * 		-checks if table exists
 * 		-confirms parameter types
 * 		-parses correct syntax
 * 		-caches for reuse
 * 
 * callable statement - same as prepared statement, but used to invoke PL/SQL
 * -functions and stored procedures
 */

public class Driver {

	public static void main(String[] args) throws Exception{
		Connection conn = Connections.getConnection();
		if(conn!=null){
			conn.close();
		}
		
		NpcService ns = new NpcService();
		
		List<Npc> npcs = ns.getAllNpcsWithClass();
		
		displayNpcGroup(npcs);
		
		Npc npc = null;
		System.out.println("=============");
		System.out.println(npc = ns.getNpcById(3));
		ns.updateLvlById(3, npc.getLvl() + 1);
		System.out.println(npc = ns.getNpcById(3));
		
		Npc newnpc = new Npc("StoredProcPerson",
						(int)(Math.random()*100),
						(int)(Math.random()*999999),
						(int)(((Math.random())*3)+1));
		if(ns.insertNpc(newnpc)){
			npcs = ns.getAllNpcsWithClass();
			displayNpcGroup(npcs);				
		}else{
			System.err.println("STORED PROCEDURE FAILURE!");
		}
		
	}	
	
	public static void displayNpcGroup(List<Npc> npcs) {
		for(Npc npc: npcs){
			System.out.println(npc.getName() +
							", who is the class: " +
								npc.getJobClassString() +
								", who currently has " +
								npc.getCurrency() +
								" monies " +
								", who currently is lvl" +
								npc.getLvl());
		}
	}
}