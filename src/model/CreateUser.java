package model;

import java.io.OutputStream;

public class CreateUser extends BaseCommand{
	public static final String COMMAND_NAME = "user";
	private Game game;
	
	@Override       
    public void execute(String[] args, OutputStream out) { 
		if (args.length != 1) {
			write(out, "Error con los parametros");               
            return; 
		}
		
		this.game = Game.getInstance();
		String result = game.loginUser(args[0]);
		
		write(out, result); 
	}
	
	@Override              
    public String getCommandName() {                  
        return COMMAND_NAME;              
    }
}
