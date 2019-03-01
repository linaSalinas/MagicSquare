package model;

import model.MagicSquare;
import userInterface.MagicSquareController;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MagicSquareTest {
	
	private int order;
	private String direction;
	private String location;
	private MagicSquare magicSquare;

	private void setupScenary1() {
		
		magicSquare = new MagicSquare(order);
		
	}
	
	private void setupScenary2() {
		magicSquare = new MagicSquare(order);
	}
	
	@Test
	void testFillMatrix() {
		setupScenary2();
		String direction = "N_O";
		String location = "Upper Central";
		int order = 3;
		

		MagicSquare magicSquare = new MagicSquare(order);
		int [][] expected = {{6,1,8},{7,5,3},{2,9,4}};
		int [][] result = magicSquare.fillMatrix(direction, location);
		assertTrue("the matrix does not fill correctly", expected == result);

		}
	@Test
	void testFillMatrix2() {
		setupScenary2();
		String direction = "S_O";
		String location ="Lower Central";
		int order = 5;
		
		MagicSquare magicSquare = new MagicSquare(order);
		int [][] expected = {{22,2,7,12,17}, {3,8,13,18,23},{9,14,19,24,4},{15,10,25,5,10},{16,21,1,6,11}};
		int [][] result = magicSquare.fillMatrix(direction, location);
		assertTrue("the matrix does not fill correctly", expected == result);
	}
	
	}







