package model;

import java.io.OutputStream;

public class AsingWeapon extends BaseCommand{
	public static final String COMMAND_NAME = "asing";
	
	@Override       
    public void execute(String[] args, OutputStream out) { 
		if (args.length != 2) {
			write(out, "Error con los parametros");               
            return; 
		}
		
		Game game = Game.getInstance();
		String text = game.asingWeapon(args[0], args[1]);
		
		write(out, text); 
	}
	
	@Override              
    public String getCommandName() {                  
        return COMMAND_NAME;              
    }
}
