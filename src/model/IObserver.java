package model;

public interface IObserver {              
    public void notifyObserver(String command, Object source);   
}

