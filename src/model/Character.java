package model;

import java.util.ArrayList;
import java.util.List;

public class Character {
	private String name;
	private List<Weapon> weapons = new ArrayList<>();
	private Element element;
	private Element weakness;
	private int life;
	private boolean state;
	
	public Character(String pName, Element pElement, Element pWeakness) {
		this.state = true;
		this.life = 100;
		this.name = pName;
		this.element = pElement;
		this.weakness = pWeakness;
	}
	
	public void setName(String pName) {
		this.name = pName;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setWeakness(Element pElement) {
		this.weakness = pElement;
	}
	
	public int getLife() {
		return this.life;
	}
	
	public void setLife(int pLife) {
		this.life = pLife;
	}
	
	public Element getWeakness() {
		return this.weakness;
	}
	
	public boolean validateWeapon(String pName) {
		for(int i = 0; i < weapons.size(); i++) {
			if(pName.equals(weapons.get(i).getName()) && weapons.get(i).getState()) {
				return true;
			}
		}
		
		return false;
	}
	
	public String enableAllWeapon(){
		for (int i = 0; i < weapons.size(); i++) {
			weapons.get(i).changeState();
		}
		return "Se han vuelto a activar todas las armas";
	}
	
	public String disableWeapon(String pName){
		for (int i = 0; i < weapons.size(); i++) {
			if (pName.equals(weapons.get(i).getName())) {
				weapons.get(i).changeState();
				return "Se ha cambiado el estado del arma " + pName;
			}
		}
		return "No se ha podido cambiar el estado del arma " + pName;
	}
	
	public ArrayList<Damage> getDamges(String pName){
		ArrayList<Damage> damages = null;
		for (int i = 0; i < weapons.size(); i++) {
			if (pName.equals(weapons.get(i).getName())) {
				damages = weapons.get(i).getDamages();
			}
		}
		return damages;
	}
	
	public String makeAShot(int pHit) {
		this.life -= pHit;
		if(this.life < 0) {
			this.state = false;
			return "El Personaje " + this.name + " Ha muerto" + '\n'; 
		}
		return "El personaje " + this.name + " sufrió " + pHit + " de daño, le restan " + this.life + " puntos de vida" + '\n';
	}
	
	public String addWeapon(Weapon pWeapon) {
		if (weapons.size() <= 5) {
			weapons.add(pWeapon);
			return "La arma se a añadido a " + this.name;
		}
		return "No se pueden añadir más armas a " + this.name;
        
    }
	
	public boolean getState() {
		return this.state;
	}
}
