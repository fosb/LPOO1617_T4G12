
public class Hero extends Character{

	String caracter; // H - Normal, K - Carrying Key, A - Armed w/Club
	Boolean armed = false;
	
	public Hero(Game g, int x, int y) {
		
		super(g, x, y);
	}
	
	public Hero(Game g, int x, int y, Boolean arm) {
		
		super(g, x, y);
		
		if(arm)
			caracter = " A ";
		else
			caracter = " H ";
	}

	
}
