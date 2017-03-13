package character_subclasses;

import logic.Character;

public class Door extends Character{

	
	private Boolean is_exit_door = false;
	
	public Door(Game g, int x, int y) {
		
		super(g, x, y);
		
		this.symbol = " I "; // I - Closed, S - Exit Stairs
	}

	
	public Door(Game g, int x, int y, Boolean exit) {
		
		super(g, x, y);
		
		if(exit)
			this.is_exit_door = true;
		
		this.symbol = " I ";
	}

	public void openDoors(){
		
		this.symbol = " S ";
	}
	
	public boolean checkExit(Character hero){
		
		int x = hero.getPosX(), y = hero.getPosY();
		
		if(Math.abs(x-this.posx) == 0 && Math.abs(y-this.posy) == 0 && this.is_exit_door && this.symbol == " S ")
			return true;
		else
			return false;
	}
}
