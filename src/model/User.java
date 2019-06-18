package model;

public class User {
	private int succesAtack;
	private int missAtack;
	private int deaths;
	private int win;
	private int loose;
	private int surrender;
	private String userName;
	
	public User(String pUserName) {
		this.userName = pUserName;
		this.deaths = 0;
		this.loose = 0;
		this.missAtack = 0;
		this.succesAtack = 0;
		this.surrender = 0;
		this.win = 0;
	}
	
	public String getName() {
		return this.userName;
	}
	
	public void setName(String pName) {
		this.userName = pName;
	}
	
	public int getDeaths() {
		return this.deaths;
	}
	
	public int getLoose() {
		return this.loose;
	}
	
	public int getMissAtack() {
		return this.missAtack;
	}
	
	public int getSuccesAtack() {
		return this.succesAtack;
	}
	
	public int getSurrender() {
		return this.surrender;
	} 
	
	public int getWin() {
		return this.win;
	}
	
	public void setDeaths() {
		this.deaths += 1;
	}
	
	public void setLoose() {
		this.loose += 1;
	}
	
	public void setMissAtack() {
		this.missAtack += 1;
	}
	
	public void setSuccesAtack() {
		this.succesAtack += 1;
	}
	
	public void setSurrender() {
		this.surrender += 1;
	}
	
	public void setWin() {
		this.win += 1;
	}
}
