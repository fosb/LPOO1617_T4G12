
public class Door extends Character{

	String caracter; // I - Closed, S - Exit Stairs
	Boolean armed = false;
	
	public Door(Game g, int x, int y) {
		
		super(g, x, y);
	}
	
	public Door(Game g, int x, int y, Boolean open) {
		
		super(g, x, y);
		
		if(open)
			caracter = " S ";
		else
			caracter = " I ";
	}

	
}
