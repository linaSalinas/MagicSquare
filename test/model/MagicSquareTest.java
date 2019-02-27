package model;

import model.MagicSquare;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MagicSquareTest {

	private void setupScenary1() {

	}

	private MagicSquare magicSquare;
	private void setupScenary2() {
		magicSquare = new MagicSquare();
	}
	private void setupScenary3() {
		magicSquare = new MagicSquare();
	}

	@Test
	void testMagicSquare() {
		setupScenary1();

		MagicSquare newMagicSquare = new MagicSquare();
		int order = 3;
		for (int i = 1; i< order; i++) {
				System.out.println("Hola Mundo");

		}
	}






}
