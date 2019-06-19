package model;

import java.io.OutputStream;

public class Chat extends BaseCommand{
	public static final String COMMAND_NAME = "chat";
	
	@Override       
    public void execute(String[] args, OutputStream out) { 
		if(args.length!=1) {
			write(out, "Error con los parametros");
            return;
		}
		
		Room playRoom = Room.getInstance();
		String outPut = playRoom.setMessage(args[0]);
		
		write(out, outPut);
	}
	
	@Override              
    public String getCommandName() {                  
        return COMMAND_NAME;              
    }
}