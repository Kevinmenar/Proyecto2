package model;

import java.util.HashMap;

public class CommandManager {       
    private static CommandManager commandManager;       
    private static final HashMap<String, Class<? extends ICommand>> COMMANDS =          
            new HashMap<String, Class<? extends ICommand>>();       
    
    private CommandManager() {           
        registCommand(AsingWeapon.COMMAND_NAME, AsingWeapon.class);           
        registCommand(Atack.COMMAND_NAME, Atack.class);           
        registCommand(Chat.COMMAND_NAME, Chat.class);           
        registCommand(CreateUser.COMMAND_NAME, CreateUser.class);           
        registCommand(Draw.COMMAND_NAME, Draw.class);           
        registCommand(ExitCommand.COMMAND_NAME, ExitCommand.class);           
        registCommand(GetCharacter.COMMAND_NAME, GetCharacter.class);           
        registCommand(Pass.COMMAND_NAME, Pass.class);
        registCommand(ReloadWeapons.COMMAND_NAME, ReloadWeapons.class);
        registCommand(SelectPlayer.COMMAND_NAME, SelectPlayer.class);
        registCommand(Surrender.COMMAND_NAME, Surrender.class);
        registCommand(WildCard.COMMAND_NAME, WildCard.class);
    }       
    
    public static synchronized CommandManager getIntance() {           
        if (commandManager == null) {               
            commandManager = new CommandManager();   
        }
        return commandManager;   
    }       
    
    public ICommand getCommand(String commandName) {           
        if (COMMANDS.containsKey(commandName.toUpperCase())) {               
            try {                   
                return COMMANDS.get(commandName.toUpperCase()).newInstance();
            } catch (Exception e) {   e.printStackTrace();                   
            return new ErrorCommand();   
            }           
        } 
        else {
            return new NotFoundCommand();   
        }   
    }       
    
    public void registCommand(String commandName, Class<? extends ICommand> command) {   
        COMMANDS.put(commandName.toUpperCase(), command);   
    }   
}