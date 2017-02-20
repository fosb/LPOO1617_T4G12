package character_subclasses;

import logic.Character;

public class Ogre extends Character{

	public Ogre(Game g, int x, int y) {
		
		super(g, x, y);
		
		this.symbol = " O "; // O - Normal, $ - Guarding Key
	}

	
}
