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
		int position = 0;
		for (int i = 0; i < 10 && isAvailable(i); i++) {
			if (i == 1) {
				if ((board[2] == ch && board[3] == ch) || (board[4] == ch && board[7] == ch)
						|| (board[5] == ch && board[9] == ch))
					position = i;
			}
			if (i == 2) {
				if ((board[1] == ch && board[3] == ch) || (board[5] == ch && board[8] == ch))
					position = i;
			}
			if (i == 3) {
				if ((board[2] == ch && board[1] == ch) || (board[6] == ch && board[9] == ch)
						|| (board[5] == ch && board[7] == ch))
					position = i;
			}
			if (i == 4) {
				if ((board[1] == ch && board[7] == ch) || (board[5] == ch && board[6] == ch))
					position = i;
			}
			if (i == 5) {
				if ((board[1] == ch && board[9] == ch) || (board[3] == ch && board[7] == ch)
						|| (board[2] == ch && board[8] == ch) || (board[4] == ch && board[6] == ch))
					position = i;
			}
			if (i == 6) {
				if ((board[3] == ch && board[9] == ch) || (board[5] == ch && board[4] == ch))
					position = i;
			}
			if (i == 7) {
				if ((board[1] == ch && board[4] == ch) || (board[9] == ch && board[8] == ch)
						|| (board[5] == ch && board[3] == ch))
					position = i;
			}
			if (i == 8) {
				if ((board[2] == ch && board[5] == ch) || (board[7] == ch && board[9] == ch))
					position = i;
			}
			if (i == 9) {
				if ((board[7] == ch && board[8] == ch) || (board[3] == ch && board[6] == ch)
						|| (board[5] == ch && board[1] == ch))
					position = i;
			} else
				position = 0;
		}
		return position;
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

	public void computerMove() {
		int position = ifPossibleToWin(computer);
		if (position != 0) {
			System.out.println("Computer Mark has been placed at position " + position);
			board[position] = computer;
		} else {
			int flag = 0;
			while (flag == 0) {
				position = ((int) Math.floor(Math.random() * 10) % 9) + 1;
				if (isAvailable(position)) {
					System.out.println("Computer Mark has been placed at position " + position);
					board[position] = computer;
					flag = 1;
				}
			}

		}
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
