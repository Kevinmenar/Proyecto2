package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {
	private List<User> users = new ArrayList<User>();
	private List<Weapon> weapons = new ArrayList<Weapon>();
	private List<Character> characters = new ArrayList<Character>();
	private Room playRoom;
	private static Game game;
	
	private Game () {
		//WeaponFactory.enableFlyweight = false;
		
		Weapon weapon1 = WeaponFactory.createWeapon("weapon1");
		Weapon weapon2 = WeaponFactory.createWeapon("weapon2");
		Weapon weapon3 = WeaponFactory.createWeapon("weapon3");
		Weapon weapon4 = WeaponFactory.createWeapon("weapon4");
		Weapon weapon5 = WeaponFactory.createWeapon("weapon5");
		Weapon weapon6 = WeaponFactory.createWeapon("weapon6");
		Weapon weapon7 = WeaponFactory.createWeapon("weapon7");
		
		weapons.add(weapon7);
		weapons.add(weapon6);
		weapons.add(weapon5);
		weapons.add(weapon4);
		weapons.add(weapon3);
		weapons.add(weapon2);
		weapons.add(weapon1);
		
		User user1 = new User("User1");
		User user2 = new User("User2");
		User user3 = new User("User3");
		User user4 = new User("User4");
		User user5 = new User("User5");
		User user6 = new User("User6");
		User user7 = new User("User7");
		
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		users.add(user5);
		users.add(user6);
		users.add(user7);
		
		CharacterFactory factory = new CharacterFactory();
		
		Character character1 = factory.factoryMethod("character1", Element.Acid, Element.Air);
		Character character2 = factory.factoryMethod("character2", Element.BlackMagic, Element.Fire);
		Character character3 = factory.factoryMethod("character3", Element.Force, Element.Ice);
		Character character4 = factory.factoryMethod("character4", Element.Ice, Element.Iron);
		Character character5 = factory.factoryMethod("character5", Element.Iron, Element.Lighting);
		Character character6 = factory.factoryMethod("character6", Element.Lighting, Element.Water);
		Character character7 = factory.factoryMethod("character7", Element.Water, Element.WhiteMagic);
		
		characters.add(character1);
		characters.add(character2);
		characters.add(character3);
		characters.add(character4);
		characters.add(character5);
		characters.add(character6);
		characters.add(character7);
		
	}
	
	public static Game getInstance() {
		if (game == null) {
			game = new Game();
		}
		return game;
	}
	
	public String asingWeapon(String pCharacter, String weapon) {
		for(int i = 0; i < weapons.size(); i++) {
			if (weapon.equals(weapons.get(i).getName())) {
				this.playRoom = Room.getInstance();
				String text = this.playRoom.assingWeapon(weapons.get(i), pCharacter);
				return text;
			}
		}
		
		return "La arma "+ weapon + " no existe";
	}
	
	public String getCharacter(String character) {
		
		for(int i = 0; i < characters.size(); i++) {
			if (character.equals(characters.get(i).getName())) {
				this.playRoom = Room.getInstance();
				String text = this.playRoom.addCharacter(characters.get(i));
				return text;
			}
		}
		
		return "No existe ningun Personaje con el nombre " + character + '\n';
	}
	
	public String loginUser(String user) {
		
		for(int i = 0; i < users.size(); i++) {
			if (user.equals(users.get(i).getName())) {
				this.playRoom = Room.getInstance();
				this.playRoom.getUser(users.get(i));
				return "Usuario encontrado, Bienvenido";
			}
		}
		
		User newUser = new User(user);
		users.add(newUser);
		this.playRoom = Room.getInstance();
		this.playRoom.getUser(newUser);
		
		return "Usuario no encontrado, creando cuenta nueva. Bienvenido";
	}
	
	public void playGame() {
		System.out.println("El juego ha iniciado");  
        
        // obtiene el commandManager
        CommandManager manager = CommandManager.getIntance();           
        Scanner in = new Scanner(System.in);           
        
        while (true) {   
            String line = in.nextLine();               
            if (line.trim().length() == 0) {                   
                continue;   
            }   
            String[] commands = CommandUtil.tokenizerArgs(line);               
            String commandName = commands[0];               
            String[] commandArgs = null;               
            
            if (commands.length > 1) {                   
                commandArgs = Arrays.copyOfRange(commands, 1, commands.length);   
            }   
            
            ICommand command = manager.getCommand(commandName);   
            command.execute(commandArgs, System.out);               
            System.out.println("");   
        }   
	}

}
