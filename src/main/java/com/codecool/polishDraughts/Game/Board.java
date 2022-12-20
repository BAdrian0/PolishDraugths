package com.codecool.polishDraughts.Game;

import java.awt.*;
import java.util.Arrays;

import static java.awt.Color.*;

public class Board {
    public static Pawn[][] board;

    public static Pawn[][] board(int n) {
        board = new Pawn[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j % 2 != 0) {
                    board[i][j] = new Pawn(BLACK);
                } else if (i == 1 && j % 2 == 0) {
                    board[i][j] = new Pawn(BLACK);
                } else if (i == n - 2 && j % 2 != 0) {
                    board[i][j] = new Pawn(WHITE);
                } else if (i == n - 1 && j % 2 == 0) {
                    board[i][j] = new Pawn(WHITE);
                } else if (i % 2 == 0 && j % 2 == 0) {
                    board[i][j] = new Pawn(BLUE);
                } else if (i % 2 != 0 && j % 2 != 0) {
                    board[i][j] = new Pawn(BLUE);
                } else {
                    board[i][j] = new Pawn(GREEN);
                }
            }
        }
        return board;
    }


    public String toString() {
        return "String toString()";
    }

//
//    public static void printBoard() {
//        System.out.println(board.toString());
//    }




    public static void printBoard() {
        String headBoard = " 1 2 3 4 5 6 7 8 9 1011121314151617181920";
        //one  space for lettersSideBoard and 2x spaces for each column
        String substr = headBoard.substring(0, board.length * 2 + 1);
        //initialize board2 used for display
        String[][] stringBoard = new String[board.length + 1][board.length + 1];

        for (int row = 0; row < stringBoard.length; row++) {
            for (int col = 0; col < stringBoard.length; col++) {
                String firstLetter = (char) (col + 64) + "";
                if (col == 0 && row > 0) {
                    stringBoard[row][col] = Integer.toString(row);
                } else if (col == 0) {
                    stringBoard[row][col] = "";
                } else if (row == 0) {
                    stringBoard[row][col] = firstLetter;
                } else {
                    if (board[col - 1][row - 1].pawnColor == BLUE) {
                        stringBoard[col][row] = ".";
                    } else if (board[col - 1][row - 1].pawnColor == GREEN) {
                        stringBoard[col][row] = ".";
                    } else if (board[col - 1][row - 1].pawnColor == WHITE) {
                        stringBoard[col][row] = "O";
                    } else if (board[col - 1][row - 1].pawnColor == BLACK) {
                        stringBoard[col][row] = "X";
                    }

                }
            }
        }

        System.out.println(Arrays.deepToString(stringBoard).replace("[[", " ").
                replace("], ", "\n").
                replace(","," ").
                replace("[","").
                replace("]]","").
                replace("10 ","10").
                replace("11 ","11").
                replace("12 ","12").
                replace("13 ","13").
                replace("14 ","14").
                replace("15 ","15").
                replace("16 ","16").
                replace("17 ","17").
                replace("18 ","18").
                replace("19 ","19").
                replace("20 ","20"));
    }


    public static void removePawn(int row, int col) {
        if (board[row][col].pawnColor == WHITE || board[row][col].pawnColor == BLACK) {
            board[row][col] = new Pawn(GREEN);
        } else {
            System.out.println("Try to select a Pawn");
        }
    }

    public void movePawn (int xi, int yi, int x, int y) {

    }



    //display board
    public static void displayBoard() {
        int count = 0;
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count++;
                System.out.println("count: " + count);
//                System.out.println("Board: "+ (Board.board[i][j].pawnColor));
                if (Board.board[i][j].pawnColor == Color.GREEN) {
                    System.out.println("You have green at: i=" + i + "  j=" + j);
                } else if (Board.board[i][j].pawnColor == Color.WHITE) {
                    System.out.println("You have white at: i=" + i + "  j=" + j);
                } else if (Board.board[i][j].pawnColor == Color.BLACK) {
                    System.out.println("You have black at: i=" + i + "  j=" + j);
                } else if (Board.board[i][j].pawnColor == Color.BLUE) {
                    System.out.println("You have blue at: i=" + i + "  j=" + j);
                }
            }
        }
    }

}
