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

	public boolean winCondition(char player) {
		if ((board[1] == player && board[2] == player && board[3] == player)
				|| (board[4] == player && board[5] == player && board[6] == player)
				|| (board[7] == player && board[8] == player && board[9] == player)
				|| (board[1] == player && board[5] == player && board[9] == player)
				|| (board[3] == player && board[5] == player && board[7] == player)
				|| (board[1] == player && board[4] == player && board[7] == player)
				|| (board[2] == player && board[5] == player && board[8] == player)
				|| (board[3] == player && board[6] == player && board[9] == player)) {
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

	public void playerMove() {
		int flag = 0;
		while (flag == 0) {
			System.out.println("Enter position : ");
			int position = in.nextInt();
			if (board[position] == ' ' && position >= 1 && position < 10) {
				System.out.println("Your Mark has been placed at position " + position);
				board[position] = player;
				flag = 1;
			} else
				System.out.println("This Position is not vacant");
		}
	}

	public void computerMove() {
		int flag = 0;
		while (flag == 0) {
			int position = ((int) Math.floor(Math.random() * 10) % 9) + 1;
			if (board[position] == ' ' && position >= 1 && position < 10) {
				System.out.println("Computer Mark has been placed at position " + position);
				board[position] = computer;
				flag = 1;
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
		int play = 1;
		while(play == 1) {
		TicTacToeGame game = new TicTacToeGame();
		System.out.println("To play enter 1");
		System.out.println("To exit enter 2");
		play = in.nextInt();
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
}