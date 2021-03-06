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
	
	public void checkExit(Character hero){// Checks if Hero is ON an Exit Door
		
		int x = hero.getPosX(), y = hero.getPosY();
		
		for(int i = 0; i < this.g.getMap().getDoors().size(); i++){
			if(Math.abs(x-this.g.getMap().getDoors().get(i).getPosX()) == 0 
				&& Math.abs(y-this.g.getMap().getDoors().get(i).getPosY()) == 0 
				&& this.g.getMap().getDoors().get(i).getIsExit()
				&& this.g.getMap().getDoors().get(i).getSymbol() == " S "){
					this.g.setState(2);
					if(this.g.getLevel() == 2)
						this.g.setState(3);
			}
		}
	}
	
	public boolean getIsExit(){
		return this.is_exit_door;
	}
}
