package character_subclasses;

import logic.Character;

public class Guard extends Character{

	public Guard(Game g, int x, int y) {
		
		super(g, x, y);
		
		this.symbol = " G "; // O - Normal, $ - Guarding Key
	}


	
}
