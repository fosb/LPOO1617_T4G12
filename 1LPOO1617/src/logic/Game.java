package logic;
import java.awt.EventQueue;
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
	private boolean is_game_started = false;
	private int guard_personality = 0;
	private int number_of_ogres = 0;


	public Game(){

		map = new Map(this, 1, this.getGuardPersonality());
		this.game_state = 1;
		this.game_level = 1;
		
	}
	
	
	public Game(int g, String o, String l){// Basic Constructor
		
		this.guard_personality = g;
		try{
			this.number_of_ogres = Integer.parseInt(o);
		}catch (NumberFormatException e1){
			System.out.println("Invalid number of Ogres. Must be between 1 and 5!");
		}
		try{
			this.game_level = Integer.parseInt(l);
		}catch (NumberFormatException e1){
			System.out.println("Invalid Level number. Must be between 1 and 2!");
		}
		map = new Map(this, this.game_level, this.getGuardPersonality());
		if(this.game_level == 2)
			this.getMap().createOgreArmy(this.number_of_ogres);
		this.game_state = 1;
	}
	
	public boolean playGame(char dir) throws StringIndexOutOfBoundsException, IOException{
		
    			//ask for user input
    			System.out.println("Enter a direction:");
    			//tries to move character	
    			if(this.game_level == 1){ //Level 1
    				if(this.getMap().getHero().moveCharacter(dir) == 1){
    					this.getMap().getGuard().guardPatrol();
    					this.getMap().getGuard().checkForHero(this.getMap().getHero());
    					this.getMap().getLever().checkForHero(this.getMap().getHero());
    					this.getMap().getDoors().get(0).checkExit(this.getMap().getHero(), 0);
    					this.checkState();
    					return true;
    				}
    				else{
    					System.out.println("You can't go there...");
    					return false;
    				}
    				
    				//this.getMap().drawMap();
    			}
    			else if(this.game_level == 2){	//Level 2
    				if(this.getMap().getHero().moveCharacter(dir) == 1){
    					for(int i = 0; i < this.getMap().getOgres().size(); i++){
    						//this.checkState();
    						this.getMap().getOgres().get(i).ogrePatrol();
    						this.getMap().getOgres().get(i).checkForKey(this.getMap().getLever());
    						this.getMap().getOgres().get(i).checkForHero(this.getMap().getHero());
    						this.getMap().getOgres().get(i).getClub().swingClub(this.getMap().getOgres().get(i));
    						this.getMap().getOgres().get(i).getClub().checkForKey(this.getMap().getLever());
    						this.getMap().getOgres().get(i).getClub().checkForHero(this.getMap().getHero());
    					}
    					this.getMap().getHero().checkForKey(this.getMap().getLever());
    					this.getMap().getDoors().get(0).checkExit(this.getMap().getHero(), 1);
    					this.checkState();
    					return true;
    				}
    				else{
    					System.out.println("You can't go there...");
    					return false;
    				}
    				
    				//this.getMap().drawMap();
    			}
    			return false;
    			//restart
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
	
	public boolean checkState(){
		
		if(this.game_state == 0){
			System.out.println("Game Over...");
			return false;
		}
		if(this.game_state == 2 ){
			System.out.println("You win! Congratulations");
			
			return true;
		}
		else
			return true;
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
	
	public boolean getIsGameStarted(){
		
		return this.is_game_started;
	}
	
	public void startGame(){
		
		this.is_game_started = true;
	}
	
	public void endGame(){
		
		this.is_game_started = false;
	}
}
