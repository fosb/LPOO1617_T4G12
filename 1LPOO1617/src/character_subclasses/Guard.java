package character_subclasses;

import java.io.IOException;

import logic.Game;

import logic.Character;

public class Guard extends Character{

	private int i;
	
	public Guard(Game g, int x, int y) {
		
		super(g, x, y);
		
		this.i = 1;
		this.symbol = " G "; // O - Normal, $ - Guarding Key
	}
	
	public boolean checkForHero(Character hero){
		
		int x = hero.getPosX(), y = hero.getPosY();
		
		if(Math.abs(x-this.posx)<=1 && Math.abs(y-this.posy)<=1)
			return true;
		
		else
			return false;
	}
	
	public void guardPatrol() throws IOException{
		
		if(this.i < 25){
			
			if(i == 1){
				this.moveCharacter('a');
				i++;
			}
			else if(i >= 2 && i <= 5){
				this.moveCharacter('s');
				i++;
			}
			else if(i >= 6 && i <= 11){
				this.moveCharacter('a');
				i++;
			}
			else if(i == 12){
				this.moveCharacter('s');
				i++;
			}
			else if(i >= 13 && i <= 19){
				this.moveCharacter('d');
				i++;
			}
			else if(i >= 20){
				this.moveCharacter('w');
				i++;
			}
		}
		else
			this.i = 1;
	}
}
