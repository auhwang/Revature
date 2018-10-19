package com.revature.week3.day1.misc.lambda;

public class DietNpc implements Comparable<DietNpc>{
	private int id;
	private String name;
	private int lvl;
	
	public DietNpc() {
		super();
	}
	
	public DietNpc(int id, String name,int lvl) {
		super();
		this.id = id;
		this.name = name;
		this.lvl = lvl;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the lvl
	 */
	public int getLvl() {
		return lvl;
	}

	/**
	 * @param lvl the lvl to set
	 */
	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the currency
	 */


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DietNpc [id=" + id + ", name=" + name + ", lvl=" + lvl + "]";
	}

	@Override
	public int compareTo(DietNpc npc) {
		//naturally sort by name
		return this.getName().compareTo(npc.getName());
	}
	
}
