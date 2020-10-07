package com.example;
import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeGame {

	private char[] board = new char[10];
	private char player, computer;
	static Scanner in = new Scanner(System.in);
	
	public char[] initializeBoard() {
		Arrays.fill(board, ' ');
		return board;
	}

	public TicTacToeGame() {
		initializeBoard();
	}
	public void chooseLetter() {
		System.out.println("Enter either x or o what you want to choose");
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
			System.out.println("-------");
			System.out.println(board[i]+"  "+board[i+1]+"  "+board[i+2]);
		}
	}
	public void move() {
		int flag = 0;
		while(flag == 0) {
		System.out.println("Enter position : ");
		int position = in.nextInt();
		if(board[position] == ' ' && position >= 1 && position < 10) {
			System.out.println("Your Mark has been placed at position "+position);
			board[position] = player;
			flag = 1;
		}
		else
			System.out.println("This Position is nit vacant");
	}
	}
	public boolean toss() {
		int toss = (int)Math.floor(Math.random() * 10) % 2;
		if(toss == 0) {
			System.out.println("You are giving first move");
			chooseLetter();
		return true;
		}
		else {
			System.out.println("Computer is giving first move");
		return false;
	}
	}
	public static void main(String[] args) {
		System.out.println("Welcome to the game");
		TicTacToeGame game = new TicTacToeGame();
		int play = 1;
		if(game.toss()) {
		while(play == 1) {
		System.out.println("To Play enter 1");
		System.out.println("To exit enter 2");
		play = in.nextInt();
		if(play == 1) {
		game.showBoard();
		game.move();
		game.showBoard();
		}
		}
		}
	}
}
