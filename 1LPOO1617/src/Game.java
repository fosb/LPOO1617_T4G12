
public class Game {

	public static void main(String args[]){
		
		String[][] map = {{" X "," X "," X "," X "," X "," X "," X "," X "," X "," X "},
				          {" X "," H ","   ","   "," I ","   "," X ","   "," G "," X "},
				          {" X "," X "," X ","   "," X "," X "," X ","   ","   "," X "},
				          {" X ","   "," I ","   "," I ","   "," X ","   ","   "," X "},
				          {" X "," X "," X ","   "," X "," X "," X ","   ","   "," X "},
				          {" I ","   ","   ","   ","   ","   ","   ","   ","   "," X "},
				          {" I ","   ","   ","   ","   ","   ","   ","   ","   "," X "},
				          {" X "," X "," X ","   "," X "," X "," X "," X ","   "," X "},
				          {" X ","   "," I ","   "," I ","   "," X "," K ","   "," X "},
				          {" X "," X "," X "," X "," X "," X "," X "," X "," X "," X "}};
		int i = 0;
		while(i < 10){
			int j = 0;
			while(j < 10){
				System.out.print(map[i][j]);
				j++;
			}
			System.out.println();
			i++;
		}
	}
}
