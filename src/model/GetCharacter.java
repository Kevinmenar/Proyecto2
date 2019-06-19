package model;

import java.io.OutputStream;

public class GetCharacter extends BaseCommand {
	public static final String COMMAND_NAME = "character";
	
	@Override       
    public void execute(String[] args, OutputStream out) { 
		if (args.length != 1) {
			write(out, "Error con los parametros");               
            return; 
		}
		
		Game game = Game.getInstance();
		String outPut = game.getCharacter(args[0]);
		
		write(out, outPut); 
		
	}
	
	@Override              
    public String getCommandName() {                  
        return COMMAND_NAME;              
    }
}