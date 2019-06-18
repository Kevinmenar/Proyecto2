package model;

public class Damage {
	private int damage;
	private Element element;
	
	Damage(int pDamage, Element pElement) {
		this.damage = pDamage;
		this.element = pElement;
	}
	
	public int getDamage() {
		return this.damage;
	}
	
	public void setDamage(int pDamage) {
		this.damage = pDamage;
	}
	
	public Element getElement() {
		return this.element;
	}
	
	public void setElement(Element pElement) {
		this.element = pElement;
	};
}
