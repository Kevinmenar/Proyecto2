package model;

import java.io.OutputStream;

public class WildCard extends BaseCommand{
	public static final String COMMAND_NAME = "wild";
	
	@Override       
    public void execute(String[] args, OutputStream out) { 
		if(args.length!=4) {
			write(out, "Error con los parametros");
            return;
		}
		
		Room playRoom = Room.getInstance();
		String outPut = playRoom.dobleAtack(args[0], args[1], args[2], args[3]);
		
		write(out, outPut);
	}
	
	@Override
    public String getCommandName() {   
        return COMMAND_NAME;
    }
}
