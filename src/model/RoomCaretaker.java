package model;

import java.util.LinkedList;


public class RoomCaretaker {
	private int currentIndex = -1;              
    private final LinkedList<RoomMemento> states = new LinkedList<>();          
    
    public void addNewMemento(RoomMemento m) {
        states.add(m);           
        currentIndex++;       
    }       
    
    public RoomMemento getCurrentMemento() {           
        return states.get(currentIndex);       
    }
    
    public RoomMemento getNextMemento() {           
        int newIndex = currentIndex +1;           
        if( newIndex >= states.size()){               
            return null;           
        }
        
        currentIndex = newIndex;           
        return states.get(currentIndex);       
    }              
    
    public RoomMemento getPreviousMemento() {           
        int newIndex = currentIndex-1;                      
        
        if(newIndex  <= -1 || newIndex >= states.size()-1){               
            return null;           
        }
        currentIndex= newIndex;           
        
        return states.get(currentIndex);       
    }
}
