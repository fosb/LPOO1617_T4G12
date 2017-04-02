package test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import logic.Game;

public class TestLevel1GameLogic {
	
	@Test
	public void testHeroMoveToBlank() throws IOException{
		Game this_game = new Game(3);
		assertEquals(this_game.getMap().getCharacter(1, 1), this_game.getMap().getHero());
		this_game.getMap().getHero().moveCharacter('s');	
		assertEquals(this_game.getMap().getCharacter(2, 1), this_game.getMap().getHero());
	}
	@Test
	public void testHeroMoveIntoWall() throws IOException{
		Game this_game = new Game(3);
		assertEquals(this_game.getMap().getCharacter(1, 1), this_game.getMap().getHero());
		this_game.getMap().getHero().moveCharacter('a');
		assertEquals(this_game.getMap().getCharacter(1, 1), this_game.getMap().getHero());
	}
	@Test
	public void testHeroMoveNextToGuard() throws IOException{
		Game this_game = new Game(3);
		assertEquals(this_game.getMap().getCharacter(1, 1), this_game.getMap().getHero());
		this_game.getMap().getHero().moveCharacter('d');
		this_game.getMap().getGuard().checkForHero(this_game.getMap().getHero());
		assertEquals(0, this_game.getState());
	}
	@Test
	public void testHeroMoveIntoClosedExit() throws IOException{
		Game this_game = new Game(3);
		assertEquals(this_game.getMap().getCharacter(1, 1), this_game.getMap().getHero());
		this_game.getMap().getHero().moveCharacter('s');
		this_game.getMap().getHero().moveCharacter('a');
		assertEquals(this_game.getMap().getCharacter(2, 1), this_game.getMap().getHero());
		assertEquals(3, this_game.getLevel());
	}
	@Test
	public void testHeroUsesLever() throws IOException{
		Game this_game = new Game(3);
		assertEquals(this_game.getMap().getCharacter(1, 1), this_game.getMap().getHero());
		this_game.getMap().getHero().moveCharacter('s');
		this_game.getMap().getHero().moveCharacter('s');
		this_game.getMap().getLever().checkForHero(this_game.getMap().getHero());
		assertEquals(" S ", this_game.getMap().getCharacter(2, 0).getSymbol());
		assertEquals(" S ", this_game.getMap().getCharacter(3, 0).getSymbol());
	}
	@Test
	public void testHeroUsesLeverAndLeaves() throws IOException{
		Game this_game = new Game(3);
		assertEquals(this_game.getMap().getCharacter(1, 1), this_game.getMap().getHero());
		this_game.getMap().getHero().moveCharacter('s');
		this_game.getMap().getHero().moveCharacter('s');
		this_game.getMap().getLever().checkForHero(this_game.getMap().getHero());
		assertEquals(3, this_game.getLevel());
		this_game.getMap().getHero().moveCharacter('a');
		this_game.getMap().getDoors().get(0).checkExit(this_game.getMap().getHero());
		assertEquals(2, this_game.getState());
	}
}
