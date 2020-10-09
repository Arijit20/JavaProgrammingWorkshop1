package com.example;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeGame {

	private char[] board = new char[10];
	static private char player, computer;
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
		while (flag == 0) {
			char option = in.next().charAt(0);
			if (option == 'o' || option == 'x') {
				player = option;
				computer = player == 'o' ? 'x' : 'o';
				flag = 1;
			} else
				System.out.println("Enter either o or x");
		}
		System.out.println("Player :" + player);
		System.out.println("Computer : " + computer);
	}

	public boolean winCondition(char ch) {
		if ((board[1] == ch && board[2] == ch && board[3] == ch) || (board[4] == ch && board[5] == ch && board[6] == ch)
				|| (board[7] == ch && board[8] == ch && board[9] == ch)
				|| (board[1] == ch && board[5] == ch && board[9] == ch)
				|| (board[3] == ch && board[5] == ch && board[7] == ch)
				|| (board[1] == ch && board[4] == ch && board[7] == ch)
				|| (board[2] == ch && board[5] == ch && board[8] == ch)
				|| (board[3] == ch && board[6] == ch && board[9] == ch)) {
			System.out.println("congrats");
			return true;
		} else
			return false;
	}

	public boolean drawCondition() {
		for (int i = 1; i < 10; i++) {
			if (board[i] == ' ') {
				return false;
			}
		}
		return true;
	}

	public void showBoard() {
		System.out.println("Showing Board");
		for (int i = 1; i < 10; i = i + 3) {
			System.out.println("-------");
			System.out.println(board[i] + "  " + board[i + 1] + "  " + board[i + 2]);
		}
	}

	public boolean isAvailable(int position) {
		if (board[position] == ' ' && position >= 1 && position < 10)
			return true;
		else
			return false;
	}

	public int ifPossibleToWin(char ch) {
		if (isAvailable(1) && ((board[2] == ch && board[3] == ch) || (board[4] == ch && board[7] == ch)
				|| (board[5] == ch && board[9] == ch)))
			return 1;
		
		if (isAvailable(2) && ((board[1] == ch && board[3] == ch) || (board[5] == ch && board[8] == ch)))
			return 2;
		
		if (isAvailable(3) && ((board[2] == ch && board[1] == ch) || (board[6] == ch && board[9] == ch)
				|| (board[5] == ch && board[7] == ch)))
			return 3;
		
		if (isAvailable(4) && ((board[1] == ch && board[7] == ch) || (board[5] == ch && board[6] == ch)))
			return 4;
		
		if (isAvailable(5) && ((board[1] == ch && board[9] == ch) || (board[3] == ch && board[7] == ch)
				|| (board[2] == ch && board[8] == ch) || (board[4] == ch && board[6] == ch)))
			return 5;
		
		if (isAvailable(6) && ((board[3] == ch && board[9] == ch) || (board[5] == ch && board[4] == ch)))
			return 6;
		
		if (isAvailable(7) && ((board[1] == ch && board[4] == ch) || (board[9] == ch && board[8] == ch)
				|| (board[5] == ch && board[3] == ch)))
			return 7;
		
		if (isAvailable(8) && ((board[2] == ch && board[5] == ch) || (board[7] == ch && board[9] == ch)))
			return 8;
		
		if (isAvailable(9) && ((board[7] == ch && board[8] == ch) || (board[3] == ch && board[6] == ch)
				|| (board[5] == ch && board[1] == ch)))
			return 9;
		
		else
			return 0;

	}

	public void playerMove() {
		int flag = 0;
		while (flag == 0) {
			System.out.println("Enter position : ");
			int position = in.nextInt();
			if (isAvailable(position)) {
				System.out.println("Your Mark has been placed at position " + position);
				board[position] = player;
				flag = 1;
			} else
				System.out.println("This Position is not vacant");
		}
	}

	public int blockPlayer() {
		int position = ifPossibleToWin(player);
		if (position == 0) 
			position = takeCorner();
		return position;
	}

	public int takeCorner() {
		if(isAvailable(1))
			return 1;
		else if(isAvailable(3))
			return 3;
		else if(isAvailable(7))
			return 7;
		else if(isAvailable(9))
			return 9;
		else 
			return midOrSidePosition();
	}

	public int midOrSidePosition() {
		if(isAvailable(5))
			return 5;
		else {
			int flag = 0, position = 0;
			while(flag == 0) {
				position = ((int)Math.floor(Math.random()* 10) % 9) + 1;
				if(isAvailable(position))
					flag = 1;
			}
			return position;
		}
	}

	public void computerMove() {
		int position = ifPossibleToWin(computer);
		if (position == 0) {
			position = blockPlayer();
		}
		System.out.println("Computer Mark has been placed at position " + position);
		board[position] = computer;
	}

	public boolean toss() {
		int toss = (int) Math.floor(Math.random() * 10) % 2;
		if (toss == 0) {
			System.out.println("You are giving first move");
			return true;
		} else {
			System.out.println("Computer is giving first move");
			return false;
		}
	}

	public void playerTurn() {
		playerMove();
		showBoard();
		if (winCondition(player)) {
			System.out.println("Player has won");
		} else if (drawCondition())
			System.out.println("Its a draw.");
		else
			computerTurn();
	}

	public void computerTurn() {
		computerMove();
		showBoard();
		if (winCondition(computer)) {
			System.out.println("Computer has won");
		} else if (drawCondition())
			System.out.println("Its a draw.");
		else
			playerTurn();
	}

	public static void main(String[] args) {
		System.out.println("Welcome to the game");
		TicTacToeGame game = new TicTacToeGame();
		System.out.println("To play enter 1");
		System.out.println("To exit enter 2");
		int play = in.nextInt();
		if (play == 1) {
			if (game.toss()) {
				game.chooseLetter();
				game.playerTurn();
			} else {
				game.chooseLetter();
				game.computerTurn();
			}
		}
	}
}
