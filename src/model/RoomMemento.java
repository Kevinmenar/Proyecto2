package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RoomMemento {
	
	private String dateTime;
	private String command;
	private String result;
	
	public RoomMemento(String pCommand, String pResult){
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");  
		Date date = new Date(System.currentTimeMillis()); 
        this.dateTime = formatter.format(date); 
        this.command = pCommand;
        this.result = pResult;
    }
    
    public RoomMemento getMemento(){           
        return null;       
    } 
}
