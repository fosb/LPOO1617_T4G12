package character_subclasses;

import logic.Character;
import logic.Game;

public class Door extends Character{
	
	private Boolean is_exit_door = false;
	
	public Door(Game g, int x, int y) {// Basic Constructor
		
		super(g, x, y);
		
		this.symbol = " I "; // I - Closed, S - Exit Stairs
	}

	
	public Door(Game g, int x, int y, Boolean exit) {// Constructor for Exit Doors according to the Level
		
		super(g, x, y);
		
		if(exit)
			this.is_exit_door = true;
		
		this.symbol = " I ";
	}

	public void openDoors(){// Updates Doors to "open"(" S ")
		
		this.symbol = " S ";
	}
	
	public void checkExit(Character hero, int k){// Checks if Hero is ON an Exit Door
		
		int x = hero.getPosX(), y = hero.getPosY();
		
		if(k == 0){
			for(int i = 0; i < this.g.getMap().getDoors().size(); i++){
				if(Math.abs(x-this.g.getMap().getDoors().get(i).getPosX()) == 0 
					&& Math.abs(y-this.g.getMap().getDoors().get(i).getPosY()) == 0 
					&& this.g.getMap().getDoors().get(i).getIsExit()
					&& this.g.getMap().getDoors().get(i).getSymbol() == " S "){
						this.g.setLevel(2);
						this.g.getMap().setType(2);
						this.g.getMap().getLever().setGuarded();
						this.g.getMap().createOgreArmy(g.getNumberOfOgres());
						g.setGameState1();
				}
			}			
		}
		else if(k == 1){
			for(int i = 0; i < this.g.getMap().getDoors().size(); i++){
				if(Math.abs(x-this.g.getMap().getDoors().get(i).getPosX()) == 0 
					&& Math.abs(y-this.g.getMap().getDoors().get(i).getPosY()) == 0 
					&& this.g.getMap().getDoors().get(i).getIsExit()
					&& this.g.getMap().getDoors().get(i).getSymbol() == " S "){
						this.g.setGameState2();
						this.g.setState(0);
						return;
				}
			}
		}
		else
			System.out.println("This isn't supposed to happen.");

	}
	
	public boolean getIsExit(){
		return this.is_exit_door;
	}
}
