package character_subclasses;

import logic.Character;

public class Hero extends Character{

	// H - Normal, K - Carrying Key, A - Armed w/Club
	Boolean armed = false;
	int savex = 0, savey = 0;
	
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

	public void checkForKey(Lever key){
		
		if(this.armed){
			Character blank = new Blank(this.g, this.savex, this.savey);
			this.g.setMap(key.getPosX(), key.getPosY(), blank);
			this.armed = false;
		}
		else if(key.checkKey(this)){
			this.symbol = " K ";
			this.armed = true;
			key.setPickup();
		}
		else
			return;
	}
}
