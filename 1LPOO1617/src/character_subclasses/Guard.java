package character_subclasses;

import logic.Character;

public class Guard extends Character{

	public Guard(Game g, int x, int y) {
		
		super(g, x, y);
		
		this.symbol = " G "; // O - Normal, $ - Guarding Key
	}
	
	public boolean checkForHero(Character hero){
		
		int x = hero.getPosX(), y = hero.getPosY();
		
		if(Math.abs(x-this.posx)<=1 && Math.abs(y-this.posy)<=1)
			return true;
		
		else
			return false;
	}

	
}
