package character_subclasses;

import java.io.IOException;
import java.util.Random;

import logic.Character;

public class Ogre extends Character{

	private Random randomGen = new Random();
	private Ogre club = null;
	
	public Ogre(Game g, int x, int y) {
		
		super(g, x, y);
		
		this.symbol = " O "; // O - Normal, $ - Guarding Key
	}
	
	public Ogre(Game g, int x, int y, boolean club) {
		
		super(g, x, y);
		
		if(club){
			this.club = new Ogre(this.g, this.posx, this.posy);
			this.club.setSymbol(" * ");
		}
		
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
		
		int randomNum;
		
		while(true){
			randomNum = randomGen.nextInt(4) + 1;
			
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
		while(true){
			randomNum = randomGen.nextInt(4) + 1;
			
			if(randomNum == 1){
				if(this.canCharacterMove('w')){
					Character blank = new Blank(this.g, this.club.posx, this.club.posy);
					g.setMap(this.club.posx, this.club.posy, blank);
					this.club.setPosX(this.posx-1);
					this.club.setPosY(this.posy);
					this.g.setMap(this.posx-1, this.posy, this.club);
					break;
				}
			}
			else if(randomNum == 2){
				if(this.canCharacterMove('a')){
					Character blank = new Blank(this.g, this.club.posx, this.club.posy);
					g.setMap(this.club.posx, this.club.posy, blank);
					this.club.setPosX(this.posx);
					this.club.setPosY(this.posy-1);
					this.g.setMap(this.posx, this.posy-1, this.club);
					break;
				}
			}
			else if(randomNum == 3){
				if(this.canCharacterMove('s')){
					Character blank = new Blank(this.g, this.club.posx, this.club.posy);
					if(g.getMap().getCharacter(this.posx, this.posy).getClass() != Ogre.class)
						g.setMap(this.club.posx, this.club.posy, blank);
					this.club.setPosX(this.posx+1);
					this.club.setPosY(this.posy);
					this.g.setMap(this.posx+1, this.posy, this.club);
					break;
				}
			}
			else if(randomNum == 4){
				if(this.canCharacterMove('d')){
					Character blank = new Blank(this.g, this.club.posx, this.club.posy);
					g.setMap(this.club.posx, this.club.posy, blank);
					this.club.setPosX(this.posx);
					this.club.setPosY(this.posy+1);
					this.g.setMap(this.posx, this.posy+1, this.club);
					break;
				}
			}
			else{
				System.out.println("Error in ogrePatrol(), invalid randomNum generated!");
				break;
			}
		}
	}
	
	public void checkForKey(Lever key){
		
		if(key.checkKey(this))
			this.symbol = " $ ";
		else if(this.club != null)
			this.symbol = " O ";
		else
			this.symbol = " * ";
	}
	
	public Ogre getClub(){
		return this.club;
	}
}
