import java.io.IOException;

public class Character {
	
	int posx, posy;
	
	public Character(int x, int y){
		posx = x;
		posy = y;		
	}
	
	public boolean moveCharacter() throws IOException{
		
		char c = (char) System.in.read();
		
		switch (c){
		
		case 'u':	if(canCharacterMove(c))
						posx-=1;
					break;
					
		case 'd':	if(canCharacterMove(c))
						posx-=1;
					break;
		
		case 'l':	if(canCharacterMove(c))
						posx-=1;
					break;
		
		case 'r':	if(canCharacterMove(c))
						posx-=1;
					break;
		}
		
		return false;
	}
	
	public boolean canCharacterMove(char direction){
		
		switch (direction){
		
		case 'u':	if(Game.getMapCoordinates(this.posx-1,this.posy) != "  ")
						return true;
					break;
					
		case 'd':	if(Game.getMapCoordinates(this.posx+1,this.posy+1) != "  ")
						return true;
					break;
		
		case 'l':	if(Game.getMapCoordinates(this.posx,this.posy-1) != "  ")
						return true;
					break;
			
		case 'r':	if(Game.getMapCoordinates(this.posx,this.posy+1) != "  ")
					return true;
					break;
		}
		
		return false;
	}

}
