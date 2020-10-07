package com.example;

public class TicTacToeGame {

	private char[] board = new char[10];

	public char[] initializeBoard() {
		for (char ch : board) {
			board[ch] = ' ';

		}
		return board;
	}

	public TicTacToeGame() {
		initializeBoard();
	}

	public static void main(String[] args) {
		System.out.println("Welcome to the game");
		TicTacToeGame game = new TicTacToeGame();
	}
}
