package model;

import java.util.ArrayList;
import java.util.List;

public class Room extends AbstractObservable implements Cloneable{
	private List<Player> players = new ArrayList<Player>();
	private static Room room;
	
	private Room() { }          
    
    public static Room getInstance() {           
        if (room == null) {               
        	room = new Room();  
        }      
        return room;       
    }
    
    public void resetRoom() {
    	players = new ArrayList<Player>();
    }
    
    public void addPlayers(Player pPlayer) {
    	players.add(pPlayer);
    }
    
    //public void notifyPlayers() {
    	//notifyAllObservers("players", this); 
    //}
}
