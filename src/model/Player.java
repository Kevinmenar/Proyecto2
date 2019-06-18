package model;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private List<Character> characters = new ArrayList<Character> ();
	private User user;
	
	public Player(User pUser) {
		this.user = pUser;
	}
	
	public User getUser() {
		return this.user;
	}
	
	public void setUser(User pUser) {
		this.user = pUser;
	}
	
	public void addCharacter(Character pCharacter) {
		this.characters.add(pCharacter);
	}
}
