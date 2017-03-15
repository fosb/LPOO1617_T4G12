package character_subclasses;

import logic.Character;
import logic.Game;

public class Wall extends Character{

	public Wall(Game g, int x, int y) {
		
		super(g, x, y);
		
		this.symbol = " X "; // O - Normal, $ - Guarding Key
	}


	
}
