package character_subclasses;

import logic.Character;
import logic.Game;

public class Blank extends Character{

	public Blank(Game g, int x, int y) {// Basic Constructor
		
		super(g, x, y);
		
		this.symbol = "   "; // O - Normal, $ - Guarding Key
	}


	
}
