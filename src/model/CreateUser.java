package model;

import java.io.OutputStream;

public class CreateUser extends BaseCommand{
	public static final String COMMAND_NAME = "user";
	
	@Override       
    public void execute(String[] args, OutputStream out) { 
		
	}
	
	@Override              
    public String getCommandName() {                  
        return COMMAND_NAME;              
    }
}
