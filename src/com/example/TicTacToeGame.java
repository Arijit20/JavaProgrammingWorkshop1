package com.example;
import java.util.Scanner;

public class TicTacToeGame {

	private char[] board = new char[10];
	private char player, computer;
	Scanner in = new Scanner(System.in);
	
	public char[] initializeBoard() {
		for (char ch : board) {
			board[ch] = ' ';
		}
		return board;
	}

	public TicTacToeGame() {
		initializeBoard();
	}
	public void chooseLetter() {
		System.out.println("Enter either x or o what yoy want to choose");
		int flag = 0;
		while(flag == 0) {
		char option = in.next().charAt(0);
		if(option == 'o' || option == 'x') {
			player = option;
			computer = player == 'o' ? 'x' : 'o';
			flag = 1;
		}
		else
			System.out.println("Enter either o or x");
	}
		System.out.println("Player :" + player);
		System.out.println("Computer : " +computer);
}
	public void showBoard() {
		for(int i =1; i < 10 ; i= i+3) {
			System.out.println("--------------");
			System.out.println(board[1]+"  "+board[i+1]+"  "+board[i+2]);
		}
	}
	public static void main(String[] args) {
		System.out.println("Welcome to the game");
		TicTacToeGame game = new TicTacToeGame();
		game.chooseLetter();
		game.showBoard();
	}
}
