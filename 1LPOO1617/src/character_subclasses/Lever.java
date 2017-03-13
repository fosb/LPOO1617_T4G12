package character_subclasses;

import logic.Character;

public class Lever extends Character{

	private int xSave, ySave;
	private boolean pickup = false;
	
	public Lever(Game g, int x, int y) {
		
		super(g, x, y);
		this.xSave = x;
		this.ySave = y;
		
		this.symbol = " k "; // O - Normal, $ - Guarding Key
	}

	public boolean checkForHero(Character hero){
		
		int x = hero.getPosX(), y = hero.getPosY();
		
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
	
	public boolean checkKey(Character chr){
		
		int x = chr.getPosX(), y = chr.getPosY();
		
		if(!this.pickup && Math.abs(x-this.posx) == 0 && Math.abs(y-this.posy) == 0)			
			return true;
		else if(chr.getClass() == Ogre.class && !this.pickup &&(Math.abs(x-this.posx) == 1 && Math.abs(y-this.posy) == 0 ||
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
}
