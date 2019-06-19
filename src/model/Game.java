package model;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private User currUser;
	private List<User> users = new ArrayList<User>();
	private List<Weapon> weapons = new ArrayList<Weapon>();
	private List<Character> characters = new ArrayList<Character>();
	
	public Game () {
		Weapon weapon1 = WeaponFactory.createPlayItem("weapon1");
		Weapon weapon2 = WeaponFactory.createPlayItem("weapon2");
		Weapon weapon3 = WeaponFactory.createPlayItem("weapon3");
		Weapon weapon4 = WeaponFactory.createPlayItem("weapon4");
		Weapon weapon5 = WeaponFactory.createPlayItem("weapon5");
		Weapon weapon6 = WeaponFactory.createPlayItem("weapon6");
		Weapon weapon7 = WeaponFactory.createPlayItem("weapon7");
		
		weapons.add(weapon7);
		weapons.add(weapon6);
		weapons.add(weapon5);
		weapons.add(weapon4);
		weapons.add(weapon3);
		weapons.add(weapon2);
		weapons.add(weapon1);
		
		
	}

}
