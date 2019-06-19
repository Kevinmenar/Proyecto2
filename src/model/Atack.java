package model;

import java.io.OutputStream;

public class Atack extends BaseCommand{
	public static final String COMMAND_NAME = "atack";
	
	@Override       
    public void execute(String[] args, OutputStream out) { 
		if (args.length != 2) {               
            write(out, "Error con los parametros");               
            return;   
        }
		
		Room playRoom = Room.getInstance();
		String outPut = playRoom.makeAHit(args[1], args[0]);
		
		write(out, outPut);
	
	}
	
	@Override              
    public String getCommandName() {                  
        return COMMAND_NAME;              
    }
}