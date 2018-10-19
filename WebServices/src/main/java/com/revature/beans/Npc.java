package com.revature.beans;

public class Npc {
	private Integer Id;
	private String name;
	private String job;
	private Integer currency;
	
	
	public Npc() {
		super();
		// REQUIRED
	}

	public Npc(Integer id, String name, String job, Integer currency) {
		super();
		Id = id;
		this.name = name;
		this.job = job;
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "Npc [Id=" + Id + ", name=" + name + ", job=" + job + ", currency=" + currency + "]";
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return Id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		Id = id;
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
	 * @return the job
	 */
	public String getJob() {
		return job;
	}
	/**
	 * @param job the job to set
	 */
	public void setJob(String job) {
		this.job = job;
	}
	/**
	 * @return the currency
	 */
	public Integer getCurrency() {
		return currency;
	}
	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(Integer currency) {
		this.currency = currency;
	}
	
	
}
