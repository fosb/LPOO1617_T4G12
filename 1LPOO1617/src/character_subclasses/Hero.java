package character_subclasses;

import logic.Character;

public class Hero extends Character{

	// H - Normal, K - Carrying Key, A - Armed w/Club
	Boolean armed = false;
	
	public Hero(Game g, int x, int y) {
		
		super(g, x, y);
		
		this.symbol = " H "; // O - Normal, $ - Guarding Key
	}

	
	public Hero(Game g, int x, int y, Boolean arm) {
		
		super(g, x, y);
		
		if(arm)
			this.symbol = " A ";
		else
			this.symbol = " H ";
	}

	
}
