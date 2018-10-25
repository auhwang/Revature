package com.luv2code.aopdemo.aspect;

public class Account {

	private String name;
	private String level;
	
	public Account() {
		
	}
	
	public Account(String name, String level) {
		this.name = name;
		this.level = level;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Account [name=" + name + ", level=" + level + "]";
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
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}
	
	/**
	 * @param level the level to set
	 */
	public void setLevel(String level) {
		this.level = level;
	}
	
}
