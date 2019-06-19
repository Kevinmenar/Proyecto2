package model;

import java.util.ArrayList;
import java.util.Random;

public class Weapon {
	private String name;
	private boolean state;
	private ArrayList<Damage> damages;
	
	public Weapon(String Name) {
		this.state = true;
		this.damages = new ArrayList<Damage>();
		this.name = Name;
		
		Random rand = new Random();
		Damage damageFire = new Damage((rand.nextInt(80)+21), Element.Fire);
		Damage damageAir = new Damage((rand.nextInt(80)+21), Element.Air);
		Damage damageWater = new Damage((rand.nextInt(80)+21), Element.Water);
		Damage damageWhiteMagic = new Damage((rand.nextInt(80)+21), Element.WhiteMagic);
		Damage damageBlackMagic = new Damage((rand.nextInt(80)+21), Element.BlackMagic);
		Damage damageLighting = new Damage((rand.nextInt(80)+21), Element.Lighting);
		Damage damageIce = new Damage((rand.nextInt(80)+21), Element.Ice);
		Damage damageAcid = new Damage((rand.nextInt(80)+21), Element.Acid);
		Damage damageForce = new Damage((rand.nextInt(80)+21), Element.Force);
		Damage damageIron = new Damage((rand.nextInt(80)+21), Element.Iron);
		
		damages.add(damageFire);
		damages.add(damageAir);
		damages.add(damageWater);
		damages.add(damageWhiteMagic);
		damages.add(damageBlackMagic);
		damages.add(damageLighting);
		damages.add(damageIce);
		damages.add(damageAcid);
		damages.add(damageForce);
		damages.add(damageIron);
	}
	
	public void changeState() {
		this.state = !this.state;
	}
	
	public ArrayList<Damage> getDamages() {
		return this.damages;
	}
	
	public boolean getState() {
		return this.state;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Damage getDamage(Element element) {
		Damage currDamage = null;
		
		for(int i = 0; i < this.damages.size(); i++) {
			if (element == damages.get(i).getElement()) {
				currDamage = damages.get(i);
				changeState();
			}
		}
		
		return currDamage;
	}
}
