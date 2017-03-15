package logic;
import java.io.IOException;

import gui.Map;
import logic.Character;

public class Game {
	
	private Map map;
	private int game_level = 0;
	
	public static void main(String args[]) throws IOException{
		
		int game_state = 1;
		Game this_game = new Game(1);
		this_game.getMap().drawMap();
		
		while(game_state == 1){
			//ask for user input
			System.out.println("Enter a direction:");
			//tries to move character			
			if(this_game.getMap().getType() == 1){ //Level 1
			if(this_game.getMap().getHero().moveCharacter(this_game.getMap().getHero().checkDirection()) == 1){
				this_game.getMap().getGuard().guardPatrol();
				if(this_game.getMap().getGuard().checkForHero(this_game.getMap().getHero())){
					System.out.println("The Guard caught you!");
					game_state = 0;
				}
				else if(this_game.getMap().getLever().checkForHero(this_game.getMap().getHero())){
					
					for(int i = 0; i < this_game.getMap().getDoors().size(); i++){
						
						this_game.getMap().getDoors().get(i).openDoors();
						/*this.g.setMap(this.g.getMap().getDoors()[i].getPosX(), 
								this.g.getMap().getDoors()[i].getPosY(), this.g.getMap().getDoors()[i]);*/
					}
				}
				else{
					for(int i = 0; i < this_game.getMap().getDoors().size(); i++){
						
						if(this_game.getMap().getDoors().get(i).checkExit(this_game.getMap().getHero())){
							System.out.println("You Win! Level 1 Completed!");
							this_game = new Game(2);
							System.out.println();
							System.out.println("And just when you thought your captivity had ended, you realise "
									+"you still have another challenge to overcome...");
							System.out.println("go through the Keep's Crazy Ogre(O). Don't forget he uses a Massive Club(*)!");
							System.out.println();
						}
					}
				}
						
				this_game.getMap().drawMap();
						
			}
			}
			else if(this_game.getMap().getType() == 2){	//Level 2
				this_game.getMap().getLever().setGuarded();
				if(this_game.getMap().getHero().moveCharacter(this_game.getMap().getHero().checkDirection()) == 1){
					this_game.getMap().getOgre().ogrePatrol();
					this_game.getMap().getOgre().checkForKey(this_game.getMap().getLever());
					this_game.getMap().getOgre().getClub().swingClub(this_game.getMap().getOgre());
					this_game.getMap().getOgre().getClub().checkForKey(this_game.getMap().getLever());
					this_game.getMap().getHero().checkForKey(this_game.getMap().getLever());
					if(this_game.getMap().getOgre().checkForHero(this_game.getMap().getHero())){
						System.out.println("The Ogre caught you!");
						game_state = 0;
					}
					else if(this_game.getMap().getOgre().getClub().checkForHero(this_game.getMap().getHero())){
						System.out.println("The Club hit you!");
						game_state = 0;
					}
					else{
						for(int i = 0; i < this_game.getMap().getDoors().size(); i++){
							
							if(this_game.getMap().getDoors().get(i).checkExit(this_game.getMap().getHero())){
								game_state = 0;
								System.out.println("You Win! Level 2 Completed!");
							}
							
						}
					}
					this_game.getMap().drawMap();
				}
				else{
					this_game.getMap().drawMap();
					System.out.println("You can't go there...");
				}
			}	
			//restart
		}
	}

	public Game(int level){
		
		map = new Map(this, level);
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
}
