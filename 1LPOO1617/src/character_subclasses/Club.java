package character_subclasses;

import java.util.Random;

import logic.Game;
import logic.Character;

public class Club extends Character{

	private Random randomGen = new Random();
	
	public Club(Game g, int x, int y){// Basic Constructor
		
		super(g, x, y);
	}
	
	public void checkForKey(Lever key){// Changes Club to "guarding the key"(" $ ") if on top of it
		
		if(key.checkKey(this))
			this.symbol = " $ ";
		else
			this.symbol = " * ";
	}
	
	public boolean checkForHero(Character hero){// Checks Hero's distance to the Club: TRUE if in adjacent tile
		
		int x = hero.getPosX(), y = hero.getPosY();
		
		if(Math.abs(x-this.posx)<=1 && Math.abs(y-this.posy)<=1)
			return true;
		
		else
			return false;
	}
	
	public void clearClub(){// Removes Club's symbol from the Map
		Character blank = new Blank(this.g, this.posx, this.posy);
		g.setMap(this.posx, this.posy, blank);
	}
	
	public void swingClub(Ogre ogre){// Places Club in a random valid tile adjacent to the Ogre
		int randomNum ;
		
		while(true){
			randomNum = randomGen.nextInt(4) + 1;
			
			if(randomNum == 1){
				if(ogre.canCharacterMove('w')){
					this.posx = ogre.getPosX()-1;
					this.posy = ogre.getPosY();
					this.g.setMap(this.posx, this.posy, this);
					break;
				}
			}
			else if(randomNum == 2){
				if(ogre.canCharacterMove('a')){
					this.posx = ogre.getPosX();
					this.posy = ogre.getPosY()-1;
					this.g.setMap(this.posx, this.posy, this);
					break;
				}
			}
			else if(randomNum == 3){
				if(ogre.canCharacterMove('s')){
					this.posx = ogre.getPosX()+1;
					this.posy = ogre.getPosY();
					this.g.setMap(this.posx, this.posy, this);
					break;
				}
			}
			else if(randomNum == 4){
				if(ogre.canCharacterMove('d')){
					this.posx = ogre.getPosX();
					this.posy = ogre.getPosY()+1;
					this.g.setMap(this.posx, this.posy, this);
					break;
				}
			}
			else{
				System.out.println("Error in seingClub(), invalid randomNum generated!");
				break;
			}
		}
	}
}
