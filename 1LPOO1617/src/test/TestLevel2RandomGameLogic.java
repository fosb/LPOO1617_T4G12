package test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import logic.Game;

public class TestLevel2RandomGameLogic {

	@Test
	public void testOgreRandomMovement() throws IOException{
		Game this_game = new Game(2);
		int i, w = 0, a = 0, s = 0, d = 0, desvio = -1;
		int N = 1000;
		
		for(i = 0; i < N; i++){
			this_game.getMap().getOgres().get(0).ogrePatrol();
			
			if(this_game.getMap().getOgres().get(0).getRandomNum() == 1)
				w++;
			if(this_game.getMap().getOgres().get(0).getRandomNum() == 2)
				a++;
			if(this_game.getMap().getOgres().get(0).getRandomNum() == 3)
				s++;
			if(this_game.getMap().getOgres().get(0).getRandomNum() == 4)
				d++;
		}
		if(Math.abs(w-N/4) >= desvio)
			desvio = Math.abs(w-N/4);
		else if(Math.abs(a-N/4) >= desvio)
			desvio = Math.abs(a-N/4);
		else if(Math.abs(s-N/4) >= desvio)
			desvio = Math.abs(s-N/4);
		else if(Math.abs(d-N/4) >= desvio)
			desvio = Math.abs(d-N/4);
		
		System.out.println(desvio);
		
		assertEquals(desvio >= 0 && desvio <= 25, true);
	}
}
