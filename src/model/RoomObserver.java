package model;

import java.util.Date;

public class RoomObserver implements IObserver{          
    @Override       
    public void notifyObserver(String command, Object source) {           
        if(command.equals("SomeCommand")){                         
        }
    }
}
