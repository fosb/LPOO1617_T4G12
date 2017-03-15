package character_subclasses;

import logic.Character;
import logic.Game;

public class Door extends Character{
	
	private Boolean is_exit_door = false;
	
	public Door(Game g, int x, int y) {// Basic Constructor
		
		super(g, x, y);
		
		this.symbol = " I "; // I - Closed, S - Exit Stairs
	}

	
	public Door(Game g, int x, int y, Boolean exit) {// Constructor for Exit Doors according to the Level
		
		super(g, x, y);
		
		if(exit)
			this.is_exit_door = true;
		
		this.symbol = " I ";
	}

	public void openDoors(){// Updates Doors to "open"(" S ")
		
		this.symbol = " S ";
	}
	
	public boolean checkExit(Character hero){// Checks if Hero is ON an Exit Door
		
		int x = hero.getPosX(), y = hero.getPosY();
		
		if(Math.abs(x-this.posx) == 0 && Math.abs(y-this.posy) == 0 && this.is_exit_door && this.symbol == " S ")
			return true;
		else
			return false;
	}
}
