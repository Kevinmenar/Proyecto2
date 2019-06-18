package model;

import java.util.HashMap;
import java.util.Map;

public class WeaponFactory {
    public static boolean enableFlyweight = true;
    
    private static final Map<String,Weapon> PLAY_ITEMS = new HashMap<>();
    
    public static Weapon createPlayItem(String weaponName){
        if(enableFlyweight && PLAY_ITEMS.containsKey(weaponName)){
            return PLAY_ITEMS.get(weaponName);
        }
        else{
        	Weapon weapon = new Weapon(weaponName);
            PLAY_ITEMS.put(weaponName, weapon);
            return weapon;
        }
    }
}
