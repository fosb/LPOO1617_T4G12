package character_subclasses;

import java.io.IOException;
import java.util.Random;

import logic.Character;

public class Ogre extends Character{

	private Random randomGen = new Random();
	
	public Ogre(Game g, int x, int y) {
		
		super(g, x, y);
		
		this.symbol = " O "; // O - Normal, $ - Guarding Key
	}

	public boolean checkForHero(Character hero){
		
		int x = hero.getPosX(), y = hero.getPosY();
		
		if(Math.abs(x-this.posx)<=1 && Math.abs(y-this.posy)<=1)
			return true;
		
		else
			return false;
	}
	
	public void ogrePatrol() throws IOException{
		
		int randomNum = randomGen.nextInt(4) + 1;
		System.out.println(randomNum);
		while(true){
			if(randomNum == 1){
				if(this.moveCharacter('w') == 1)
					break;
			}
			else if(randomNum == 2){
				if(this.moveCharacter('a') == 1)
					break;
			}
			else if(randomNum == 3){
				if(this.moveCharacter('s') == 1)
					break;
			}
			else if(randomNum == 4){
				if(this.moveCharacter('d') == 1)
					break;
			}
			else{
				System.out.println("Error in ogrePatrol(), invalid randomNum generated!");
				break;
			}
		}
	}	
}
