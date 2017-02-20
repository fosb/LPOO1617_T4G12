package character_subclasses;

import logic.Character;

public class Lever extends Character{

	public Lever(Game g, int x, int y) {
		
		super(g, x, y);
		
		this.symbol = " k "; // O - Normal, $ - Guarding Key
	}


	
}
