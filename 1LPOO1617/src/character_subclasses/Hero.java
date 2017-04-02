package character_subclasses;

import logic.Character;
import logic.Game;

public class Hero extends Character{

	// H - Normal, K - Carrying Key, A - Armed w/Club
	Boolean armed = false;
	int savex = 0, savey = 0;
	
	public Hero(Game g, int x, int y) {// Basic Constructor
		
		super(g, x, y);
		
		this.symbol = " H "; // O - Normal, $ - Guarding Key
	}

	
	public Hero(Game g, int x, int y, Boolean arm) {// Constructor for Armed Hero
		
		super(g, x, y);
		
		if(arm){
			this.symbol = " A ";
			this.armed = true;
		}
		else
			this.symbol = " H ";
	}

	public void checkForKey(Lever key){// Checks Hero's distance to the Key, "Picks up Key" if ON it 
									   // Updates Map accordingly
		if(!key.getPickup() && key.checkKey(this)){
			this.symbol = " K ";
			key.setPickup();
		}
	}
	
	public boolean getArmed(){
		return this.armed;
	}
}
