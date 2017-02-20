package character_subclasses;

import logic.Character;

public class Door extends Character{

	
	Boolean armed = false;
	
	public Door(Game g, int x, int y) {
		
		super(g, x, y);
		
		this.symbol = " I "; // I - Closed, S - Exit Stairs
	}

	
	public Door(Game g, int x, int y, Boolean open) {
		
		super(g, x, y);
		
		if(open)
			this.symbol = " S ";
		else
			this.symbol = " I ";
	}

	
}
