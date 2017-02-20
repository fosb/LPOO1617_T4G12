import java.io.IOException;

public class Character {
	
	//pode ser Hero Ogre Guard Wall Lever OpenDoor ClosedDoor Blank
	int posx, posy;
	Game g;
	
	public Character(Game game, int x, int y){
		g = game;
		posx = x;
		posy = y;
		
	}
	
	public int returnPosX(){
		
		return posx;
	}
	
	public int returnPosY(){
		
		
		return posy;
	}
	
	public int moveCharacter() throws IOException{
		
		char c = (char) System.in.read();
		
		/*if(c == 'u'){
			if(canCharacterMove(c)){
				posx-=1;
				return 1;
			}
		}
		else if(c == 'd'){
			if(canCharacterMove(c)){
				posx-=1;
				return 2;
			}
		}
		else if(c == 'l'){
			if(canCharacterMove(c)){
				posx-=1;
				return 3;
			}
		}
		else if(c == 'r'){
			if(canCharacterMove(c)){
				posx-=1;
				return 4;
			}
		}*/

		
		switch (c){
		
		case 'u':	if(canCharacterMove(c)){
						posx-=1;
						return 1;
					}
					break;
					
		case 'd':	if(canCharacterMove(c)){
						posx-=1;
						return 1;
					}
					break;
		
		case 'l':	if(canCharacterMove(c)){
						posx-=1;
						return 1;
					}
					break;
		
		case 'r':	if(canCharacterMove(c)){
						posx-=1;
						return 1;
					}
					break;
		}
		
		return 0;
	}
	
	public boolean canCharacterMove(char direction){
		
		switch (direction){
		
		case 'u':	if(g.getMapCoordinates(this.posx-1,this.posy) != "  ")
						return true;
					break;
					
		case 'd':	if(g.getMapCoordinates(this.posx+1,this.posy+1) != "  ")
						return true;
					break;
		
		case 'l':	if(g.getMapCoordinates(this.posx,this.posy-1) != "  ")
						return true;
					break;
			
		case 'r':	if(g.getMapCoordinates(this.posx,this.posy+1) != "  ")
						return true;
					break;
		}
		
		return false;
	}

}
