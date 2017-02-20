package character_subclasses;

import logic.Character;

public class Blank extends Character{

	public Blank(Game g, int x, int y) {
		
		super(g, x, y);
		
		this.symbol = "   "; // O - Normal, $ - Guarding Key
	}


	
}
