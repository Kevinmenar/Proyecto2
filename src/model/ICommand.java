package model;

import java.io.OutputStream;

public interface ICommand {       
    public String getCommandName();       
    public void execute(String[] args, OutputStream out);   
}
