package model;

import java.io.OutputStream;

public class SelectPlayer extends BaseCommand{
	public static final String COMMAND_NAME = "select";
	
	@Override       
    public void execute(String[] args, OutputStream out) { 
		if(args.length!=1) {
			write(out, "Error con los parametros");
            return;
		}
	}
	
	@Override              
    public String getCommandName() {                  
        return COMMAND_NAME;              
    }
}