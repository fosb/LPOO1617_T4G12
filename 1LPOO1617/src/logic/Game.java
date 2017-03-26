package logic;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import gui.Map;
import gui.truegui;
import logic.Character;

public class Game {
	
	private Map map;
	private int game_level = 0;
	private int game_state = 0;
	private int game_state1 = 0;
	private int game_state2 = 0;
	private static int guard_personality = 0;
	private static int number_of_ogres = 0;
	
	public static void main(String args[]) throws IOException{
		
		
		Game this_game = new Game(number_of_ogres, guard_personality);
	    SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	            truegui gui = new truegui();
	        }
	    });
		
		//this_game.getMap().createOgreArmy(this_game.getNumberOfOgres());
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

	public Game(int numberOfOgres, int guardPersonality){// Basic Constructor
		
		this.number_of_ogres = numberOfOgres;
		this.guard_personality = guardPersonality;
		map = new Map(this, 1, this.getGuardPersonality());
		this.game_state = 1;
		this.game_level = 1;
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
	
	public int getNumberOfOgres(){
		
		return this.number_of_ogres;
	}
	
	public void setNumberOfOgres(int i){
		
		this.number_of_ogres = i;
	}
	
	public int getGuardPersonality(){
		
		return this.guard_personality;
	}
	
	public void setGuardPersonality(int i){
		
		this.guard_personality = i;
	}
}
