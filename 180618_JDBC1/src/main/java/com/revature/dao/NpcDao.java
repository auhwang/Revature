package com.revature.dao;

import java.util.List;

import com.revature.beans.Npc;
/*
 * Data Access Object
 * -A dao provies an abstract interface to some type of database
 * -Provides some specific data operations without exposing details of the database
 */
public interface NpcDao {
	public void insertNpc(Npc npc);
	public Npc selectNpcById(Integer id);
	public List<Npc> selectAllNpc();
	public Integer deleteNpcById(Integer id);
	public Boolean updateNpc(Npc npc);
	public Boolean insertNpcViaSp(Npc npc);
}