package model;

import java.util.ArrayList;
import java.util.List;

public class Character {
	private String name;
	private List<Weapon> weapons = new ArrayList<>();
	private Element element;
	private Element weakness;
	private int life;
	
	public Character(String pName, Element pElement, Element pWeakness) {
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
	
	public Damage makeAShot(String pName, Element pElement) {
		Damage damage = null;
		
		for (int i = 0; i < weapons.size(); i++) {
			if (pName == weapons.get(i).getName(pName)) {
				damage = weapons.get(i).getDamage(pElement);
			}
		}
		
		return damage;
	}
	
	public void addWeapon(Weapon pWeapon) {
        weapons.add();
    }
}
