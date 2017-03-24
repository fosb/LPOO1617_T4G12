package logic;
import java.io.IOException;

import gui.Map;
import logic.Character;

public class Game {
	
	private Map map;
	private int game_level = 0;
	private int game_state = 0;
	private int game_state1 = 0;
	private int game_state2 = 0;
	
	public static void main(String args[]) throws IOException{
		
		Game this_game = new Game(2);
		this_game.getMap().createOgreArmy();
		this_game.getMap().drawMap();
		
		while(this_game.game_state == 1){
			//ask for user input
			System.out.println("Enter a direction:");
			//tries to move character	
			if(this_game.game_level == 1){ //Level 1
				if(this_game.getMap().getHero().moveCharacter(this_game.getMap().getHero().checkDirection()) == 1){
					this_game.getMap().getGuard().guardPatrol();
					this_game.getMap().getGuard().checkForHero(this_game.getMap().getHero());
					this_game.getMap().getLever().checkForHero(this_game.getMap().getHero());
					this_game.getMap().getDoors().get(0).checkExit(this_game.getMap().getHero(), 0);
					this_game.checkState(this_game.getGameState2());
				}
				else
					System.out.println("You can't go there...");
				
				//this_game.getMap().drawMap();
			}
			else if(this_game.game_level == 2){	//Level 2
				if(this_game.getMap().getHero().moveCharacter(this_game.getMap().getHero().checkDirection()) == 1){
					for(int i = 0; i < this_game.getMap().getOgres().size(); i++){
						//this_game.checkState();
						this_game.getMap().getOgres().get(i).ogrePatrol();
						this_game.getMap().getOgres().get(i).checkForKey(this_game.getMap().getLever());
						this_game.getMap().getOgres().get(i).getClub().swingClub(this_game.getMap().getOgres().get(i));
						this_game.getMap().getOgres().get(i).getClub().checkForKey(this_game.getMap().getLever());
						this_game.getMap().getHero().checkForKey(this_game.getMap().getLever());
						this_game.getMap().getOgres().get(i).checkForHero(this_game.getMap().getHero());
						this_game.getMap().getOgres().get(i).getClub().checkForHero(this_game.getMap().getHero());
						this_game.getMap().getDoors().get(0).checkExit(this_game.getMap().getHero(), 1);
					}
					this_game.checkState(this_game.getGameState2());
				}
				else
					System.out.println("You can't go there...");
				
				//this_game.getMap().drawMap();
			}
			//restart
		}
	}

	public Game(int level){// Basic Constructor
		
		map = new Map(this, level);
		this.game_state = 1;
		this.game_level = level;
	}
	
	public String getMapCoordinates(int x, int y){
		
			return this.map.getCharacter(x, y).getSymbol();
		
	}
	
	public Map getMap(){
		
		return map;
	}
	
	public void setMap(int posx, int posy, Character chr){
		
		this.getMap().map[posx][posy] = chr;
	}
	
	public int getLevel(){
		
		return this.game_level;
	}
	
	public int getState(){
		return this.game_state;
	}
	
	public void setState(int x){
		this.game_state = x;
	}
	
	public void checkState(int i){
		
		if(this.game_state != 1 && i == 1){
			this.getMap().drawMap();
			System.out.println("Game Over...");
		}
		if(this.game_state != 1 && i == 2){
			this.getMap().drawMap();
			System.out.println("You win! Congratulations");
		}
		else 
			this.getMap().drawMap();
	}
	
	public void setLevel(int x){
		
		this.game_level = x;
	}
	
	public int getGameState1(){
		
		return this.game_state1;
	}
	
	public int getGameState2(){
		
		return this.game_state2;
	}
	
	public void setGameState1(){
		
		this.game_state1 = 1;
	}
	
	public void setGameState2(){
		
		this.game_state2 = 2;
	}
	
}
