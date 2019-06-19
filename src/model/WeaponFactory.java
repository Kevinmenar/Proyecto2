package model;

import java.util.HashMap;
import java.util.Map;

public class WeaponFactory {
    public static boolean enableFlyweight = true;
    
    private static final Map<String,Weapon> WEAPONS = new HashMap<>();
    
    public static Weapon createWeapon(String weaponName){
        if(enableFlyweight && WEAPONS.containsKey(weaponName)){
            return WEAPONS.get(weaponName);
        }
        else{
        	Weapon weapon = new Weapon(weaponName);
        	WEAPONS.put(weaponName, weapon);
            return weapon;
        }
    }
}
