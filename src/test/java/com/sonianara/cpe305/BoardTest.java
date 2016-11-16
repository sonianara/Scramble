package com.sonianara.cpe305;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;


public class BoardTest {

	@Test
	public void testHeight() {
		Board board = new Board(0, 10);
		assertEquals(0, board.getHeight());
	}
	
	@Test
	public void testWidth() {
		Board board = new Board(3, 5);
		assertEquals(5, board.getWidth());
	}
	
	@Test
	public void testEmptyBoard() {
		Board board = new Board(1, 1);
		board.createBoard();
		assertEquals(true, board.isEmpty());
	}
}
