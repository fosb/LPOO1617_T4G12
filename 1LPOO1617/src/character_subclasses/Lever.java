package character_subclasses;

import logic.Character;
import logic.Game;

public class Lever extends Character{

	private int xSave, ySave;
	private boolean pickup = false;
	private boolean guarded = false;
	
	public Lever(Game g, int x, int y) {//Basic Constructor
		
		super(g, x, y);
		this.xSave = x;
		this.ySave = y;
		
		this.symbol = " k "; // O - Normal, $ - Guarding Key
	}

	public boolean checkForHero(Character hero){  // Checks Hero's distance to the Lever:
												    // TRUE if ON the Lever
		int x = hero.getPosX(), y = hero.getPosY(); // FALSE if adjacent(updates Map to ensure Lever doesn't vanish
													// FALSE if distant
		if(Math.abs(x-this.posx) == 0 && Math.abs(y-this.posy) == 0){
		
			return true;
		}
		else if(Math.abs(x-this.posx) == 1 && Math.abs(y-this.posy) == 0 ||
				Math.abs(x-this.posx) == 0 && Math.abs(y-this.posy) == 1){
			
			Character k = new Lever(this.g, this.xSave, this.ySave);
			this.g.setMap(this.xSave, this.ySave, k);
			return false;
		}
		else
			return false;
	}
	
	public boolean checkKey(Character chr){// Checks for chr distance to the Key:
												 // TRUE if ON the Key and considers Key "guarded"
		int x = chr.getPosX(), y = chr.getPosY();// FALSE if adjacent(updates Map to ensure the Key doesn't vanish
												 // FALSE if distant
		if(!this.pickup && Math.abs(x-this.posx) == 0 && Math.abs(y-this.posy) == 0){			
			this.guarded = true;
			return true;
		}
		else if(!this.guarded && (chr.getClass() == Ogre.class || chr.getClass() == Club.class) &&
				!this.pickup &&(Math.abs(x-this.posx) == 1 && Math.abs(y-this.posy) == 0 ||
				Math.abs(x-this.posx) == 0 && Math.abs(y-this.posy) == 1)){
			
			Character k = new Lever(this.g, this.xSave, this.ySave);
			this.g.setMap(this.xSave, this.ySave, k);
			return false;
		}
		else 
			return false;
	}

	public void setPickup(){
		this.pickup = true;
	}
	
	public void setGuarded(){
		this.guarded = false;
	}
	
	public boolean getPickup(){
		return this.pickup;
	}
}
