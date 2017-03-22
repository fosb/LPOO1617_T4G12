package test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import logic.Game;

public class TestLevel2GameLogic {

	/*@Test
	public void testHeroNextToOgre() throws IOException{
		Game this_game = new Game(4);
		assertEquals(this_game.getMap().getCharacter(1, 1), this_game.getMap().getHero());
		this_game.getMap().getHero().moveCharacter('d');
		this_game.getMap().getOgre().checkForHero(this_game.getMap().getHero());
		assertEquals(0, this_game.getState());
	}*/
	@Test
	public void testHeroGrabsKey() throws IOException{
		Game this_game = new Game(4);
		assertEquals(this_game.getMap().getCharacter(1, 1), this_game.getMap().getHero());
		this_game.getMap().getHero().moveCharacter('s');
		this_game.getMap().getHero().moveCharacter('s');
		assertEquals(" H ", this_game.getMap().getHero().getSymbol());
		this_game.getMap().getHero().checkForKey(this_game.getMap().getLever());
		assertEquals(" K ", this_game.getMap().getHero().getSymbol());
	}
	@Test
	public void testHeroOpensDoorWithoutKey() throws IOException{
		Game this_game = new Game(4);
		assertEquals(this_game.getMap().getCharacter(1, 1), this_game.getMap().getHero());
		this_game.getMap().getHero().moveCharacter('s');
		this_game.getMap().getHero().moveCharacter('a');
		assertEquals(" H ", this_game.getMap().getHero().getSymbol());
		assertEquals(this_game.getMap().getCharacter(2, 1), this_game.getMap().getHero());
		assertEquals(" I ", this_game.getMap().getCharacter(2, 0).getSymbol());
	}
	@Test
	public void testHeroOpensDoorWithKey() throws IOException{
		Game this_game = new Game(4);
		assertEquals(this_game.getMap().getCharacter(1, 1), this_game.getMap().getHero());
		this_game.getMap().getHero().moveCharacter('s');
		this_game.getMap().getHero().moveCharacter('s');
		assertEquals(" H ", this_game.getMap().getHero().getSymbol());
		this_game.getMap().getHero().checkForKey(this_game.getMap().getLever());
		assertEquals(" K ", this_game.getMap().getHero().getSymbol());
		this_game.getMap().getHero().moveCharacter('a');
		assertEquals(this_game.getMap().getCharacter(3, 1), this_game.getMap().getHero());
		assertEquals(" S ", this_game.getMap().getCharacter(3, 0).getSymbol());
	}
	@Test
	public void testHeroUsesLeverAndLeaves() throws IOException{
		Game this_game = new Game(4);
		assertEquals(this_game.getMap().getCharacter(1, 1), this_game.getMap().getHero());
		this_game.getMap().getHero().moveCharacter('s');
		this_game.getMap().getHero().moveCharacter('s');
		this_game.getMap().getHero().checkForKey(this_game.getMap().getLever());
		this_game.getMap().getHero().moveCharacter('a');
		assertEquals(4, this_game.getLevel());
		this_game.getMap().getHero().moveCharacter('a');
		this_game.getMap().getDoors().get(0).checkExit(this_game.getMap().getHero());
		assertEquals(this_game.getMap().getCharacter(3, 0), this_game.getMap().getHero());
		assertEquals(2, this_game.getLevel());
	}
}
