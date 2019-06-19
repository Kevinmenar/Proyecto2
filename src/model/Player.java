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
	
	public List<Character> getCharacters() {
		return this.characters;
	}
	
	public ArrayList<Damage> getDamage(String pWeaponName, String pCharacterName) {
		ArrayList<Damage> damages = null;
		for(int i = 0; i < characters.size(); i++) {
			if (pCharacterName.equals(characters.get(i).getName())) {
				damages = characters.get(i).getDamges(pWeaponName);
			}
		} 
		return damages;
		
	}
	
	public boolean checkWin() {
		for(int i = 0; i < characters.size(); i++) {
			if(characters.get(i).getState()) {
				return false;
			}
		}
		return true;
	}
	
	public String changeStateAllWeapon() {
		for(int i = 0; i < characters.size(); i++) {
			return characters.get(i).enableAllWeapon();
		}
		return "Algo falló";
	}
	
	public String changeStateWeapon(String pWeaponName, String pCharacterName) {
		for(int i = 0; i < characters.size(); i++) {
			if (pCharacterName.equals(characters.get(i).getName())) {
				return characters.get(i).disableWeapon(pWeaponName);
			}
		}
		return "No existen armas que recargar";
	}
	
	public boolean existCharacterWeapon(String pWeaponName, String pCharacterName) {
		for(int i = 0; i < characters.size(); i++) {
			if (pCharacterName.equals(characters.get(i).getName())) {
				if(characters.get(i).validateWeapon(pWeaponName)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public String assingWeapon(String characterName, Weapon pWeapon) {
		for(int i = 0; i < characters.size(); i++) {
			if (characterName.equals(characters.get(i).getName())) {
				String text = characters.get(i).addWeapon(pWeapon);
				return text;
			}
		}
		return "No cuentas con ningun persojane llamado: " + characterName;
	}
	
	public String addCharacter(Character pCharacter) {
		String characterName = pCharacter.getName();
		if (characters.size()<=5) {
			for(int i = 0; i < characters.size(); i++) {
				if (characterName == characters.get(i).getName()) {
					return "Ya cuentas con un personaje con ese nombre";
				}
			}
			
			this.characters.add(pCharacter);
			
			return "El personaje se añadió a tu inventario";
		}
		
		return "Ya cuentas con el maximo de personajes"; 
	}
}
