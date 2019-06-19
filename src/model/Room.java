package model;

import java.util.ArrayList;
import java.util.List;

public class Room extends AbstractObservable implements Cloneable, Runnable{
	private String currUser;
	private List<Player> players = new ArrayList<Player>();
	private static Room room;
	private boolean doublePlay = false;
	private List<String> chat = new ArrayList<String>();
	
	private Room() {
		Thread t1 =new Thread(this);  
		t1.start();
	}          
    
    public static Room getInstance() {           
        if (room == null) {               
        	room = new Room();  
        }      
        return room;       
    }
    
    public String getUser(User pUser) {
    	this.currUser = pUser.getName();
		Player newPlayer = new Player(pUser);
		players.add(newPlayer);
		
		User enemyUser = new User("Enemy");
		addPlayers(enemyUser);
		
		return "Un nuevo jugador a entrado a la sala";
    }
    
    public void resetRoom() {
    	room = null;
    }
    
    public String setMessage(String Message) {
    	chat.add(Message);
    	String text = "";
    	for (int i = 0; i < chat.size(); i++) {
    		text += chat.get(i) + '\n';
    	}
    	return text;
    }
    
    public void addPlayers(User pUser) {
    	if (players.size() < 2 ) {
    		Player newPlayer = new Player(pUser);
        	players.add(newPlayer);
        	
        	CharacterFactory factory = new CharacterFactory();
        	Character character1 = factory.factoryMethod("character1", Element.Acid, Element.Air);
    		Character character2 = factory.factoryMethod("character2", Element.BlackMagic, Element.Fire);
    		Character character3 = factory.factoryMethod("character3", Element.Force, Element.Ice);
    		Character character4 = factory.factoryMethod("character4", Element.Ice, Element.Iron);
    		Character character5 = factory.factoryMethod("character5", Element.Iron, Element.Lighting);
    		
    		addCharacter(character1, "Enemy");
    		addCharacter(character2, "Enemy");
    		addCharacter(character3, "Enemy");
    		addCharacter(character4, "Enemy");
    		addCharacter(character5, "Enemy");
    		
    		
    	}
    }
    
    public String assingWeapon(Weapon pWeapon, String pCharacter) {
    	Player player = null;
    	  
    	for(int i = 0; i < players.size(); i++) {
    		if (this.currUser == players.get(i).getUser().getName()) {
    			player = players.get(i);
    		}
    	}
    	
    	if(player == null) {
    		return "No se encuentra ningun usuario logueado";
    	}
    	
    	return player.assingWeapon(pCharacter, pWeapon);
    	
    }
    
    public String addCharacter(Character character, String pName) {
    	Player player = null;
  
    	for(int i = 0; i < players.size(); i++) {
    		if (pName == players.get(i).getUser().getName()) {
    			player = players.get(i);
    		}
    	}
    	
    	if(player == null) {
    		return "No se encuentra ningun usuario logueado";
    	}
    	
    	String outPutText = player.addCharacter(character);
    	return outPutText;
    }
    
    public String realodWeapons() {
    	Player player = null;
  
    	for(int i = 0; i < players.size(); i++) {
    		if (this.currUser == players.get(i).getUser().getName()) {
    			player = players.get(i);
    		}
    	}
    	
    	if(player == null) {
    		return "No se encuentra ningun usuario logueado";
    	}
    	
    	String outPutText = player.changeStateAllWeapon();
    	return outPutText;
    }
    
    public String addCharacter(Character character) {
    	Player player = null;
  
    	for(int i = 0; i < players.size(); i++) {
    		if (this.currUser == players.get(i).getUser().getName()) {
    			player = players.get(i);
    		}
    	}
    	
    	if(player == null) {
    		return "No se encuentra ningun usuario logueado";
    	}
    	
    	String outPutText = player.addCharacter(character);
    	return outPutText;
    }
    
    public String makeAHit(String pWeapon, String pCharacter) {
    	Player player = null;
    	Player enemy = null;
    	  
    	for(int i = 0; i < players.size(); i++) {
    		if (this.currUser == players.get(i).getUser().getName()) {
    			player = players.get(i);
    		} else {
    			enemy = players.get(i);
    		}
    	}
    	
    	if(player == null) {
    		return "No se encuentra el usuario logueado";
    	}
    	
    	if (!player.existCharacterWeapon(pWeapon, pCharacter)) {
    		return "Es imposible realizar la accion";
    	}
    	
    	List<Damage> damages = player.getDamage(pWeapon, pCharacter);
    	
    	if(enemy != null) {
    		List<Character> enemyCharacters = enemy.getCharacters();
        	
        	int totalDamage = 0;
        	String text = "";
        	
        	for (int i = 0; i < enemyCharacters.size(); i++) {
        		int damage = Damage(enemyCharacters.get(i).getWeakness(), damages);
        		text += enemyCharacters.get(i).makeAShot(damage);
        		totalDamage += damage;
        	}
        	
        	if(totalDamage<100) {
        		player.getUser().setMissAtack();
        		text += "El ataque falló" + '\n';
        	} else {
        		player.getUser().setSuccesAtack();
        		text += "El ataque fue un éxito" + '\n';
        	}
        	
        	if(enemy.checkWin()) {
        		text += "El juego ha terminado, el ganador es: " + this.currUser + '\n';
        		text += "El juego se reiniciará, por favor vuelva a loguear"+'\n';
        		player.getUser().setWin();
        		enemy.getUser().setLoose();
        		resetRoom();
        		
        	}
        	
        	text += player.changeStateWeapon(pWeapon, pCharacter);
        	
        	return text;
    	}
    	
    	return "No existe un rival digno";
    }
    
    private int Damage(Element pElement, List<Damage> pDamages) {
    	int damage = 0;
    	for (int i = 0; i < pDamages.size(); i++) {
    		if(pElement == pDamages.get(i).getElement()) {
    			damage = pDamages.get(i).getDamage();
    		}
    	}
    	return damage;
    }
    
    public String dobleAtack(String pWeapon0, String pCharacter0, String pWeapon1, String pCharacter1) {
    	if(this.doublePlay) {
    		String text = "";
        	text += makeAHit(pWeapon0, pCharacter0);
        	text += makeAHit(pWeapon1, pCharacter1);
        	return text;
    	}
    	return "El doble turno aun sigue cargandose";
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				Thread.sleep(300000);
				this.doublePlay = true;
				System.out.println("El doble turno esta disponible");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
    
    //public void notifyPlayers() {
    	//notifyAllObservers("players", this); 
    //}
}
