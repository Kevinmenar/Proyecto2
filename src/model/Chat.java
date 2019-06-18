package model;

import java.io.OutputStream;

public class Chat extends BaseCommand{
	public static final String COMMAND_NAME = "chat";
	
	@Override       
    public void execute(String[] args, OutputStream out) { 
		
	}
	
	@Override              
    public String getCommandName() {                  
        return COMMAND_NAME;              
    }
}