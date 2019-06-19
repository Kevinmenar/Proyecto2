package model;

import java.io.OutputStream;

public class ReloadWeapons extends BaseCommand{
	public static final String COMMAND_NAME = "reload";
	
	@Override       
    public void execute(String[] args, OutputStream out) { 
		if(args!=null) {
			write(out, "Error con los parametros");               
            return;
		}
		
		Room playRoom = Room.getInstance();
		String outPut = playRoom.realodWeapons();
		
		write(out, outPut);
		
	}
	
	@Override              
    public String getCommandName() {                  
        return COMMAND_NAME;              
    }
}