package com.codecool.polishDraughts.Game;

import java.awt.*;
import java.util.Arrays;

import static java.awt.Color.*;

public class Board {
    public static Pawn[][] board;

    //generate board
    public static Pawn[][] board(int n) {
        board = new Pawn[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if ((row == 0 || row==2) && col % 2 != 0) {
                    board[row][col] = new Pawn(BLACK);
                } else if ((row == 1 || row==3) && col % 2 == 0) {
                    board[row][col] = new Pawn(BLACK);
                } else if ((row == n - 2 || row==n-4) && col % 2 != 0) {
                    board[row][col] = new Pawn(WHITE);
                } else if ((row == n - 1 || row==n-3) && col % 2 == 0) { //
                    board[row][col] = new Pawn(WHITE);
                } else if (col % 2 == 0 && row % 2 == 0) {//
                    board[row][col] = new Pawn(BLUE);
                } else if (col % 2 != 0 && row % 2 != 0) {//
                    board[row][col] = new Pawn(BLUE);
                } else {
                    board[row][col] = new Pawn(GREEN);//
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
        //initialize board2 used for display
        String[][] stringBoard = new String[board.length + 1][board.length + 1];

        for (int row = 0; row < stringBoard.length; row++) {
            for (int col = 0; col < stringBoard.length; col++) {
                String firstLetter = (char) (col + 64) + "";//
                if (col == 0 && row > 0) {//
                    stringBoard[row][col] = Integer.toString(row);//
                } else if (col == 0) {
                    stringBoard[row][col] = "";//
                } else if (row == 0) {
                    stringBoard[row][col] = firstLetter;
                } else {
                    if (board[row - 1][col - 1].pawnColor == BLUE) {
                        stringBoard[row][col] = ".";
                    } else if (board[row - 1][col - 1].pawnColor == GREEN) {
                        stringBoard[row][col] = ".";
                    } else if (board[row - 1][col - 1].pawnColor == WHITE) {
                        stringBoard[row][col] = "O";
                    } else if (board[row - 1][col - 1].pawnColor == GRAY) {
                        stringBoard[row][col] = "M";
                    } else {
                        stringBoard[row][col] = "X";
                    }

                }
            }
        }

        System.out.println(
                Arrays.deepToString(stringBoard)
                .replace("[[", " ")
                .replace("], ", "\n").
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
        System.out.println();
    }



    public static void removePawn(int col, int row) {
        if (board[row][col].pawnColor == GRAY) {
            board[row][col] = new Pawn(GREEN);
        } else {
            System.out.println("Try to select a M pawn");
        }
    }

    public static void choosePawn(int col, int row) {
        if (board[row][col].pawnColor == WHITE || board[col][row].pawnColor == BLACK) {
            board[row][col] = new Pawn(GRAY);
        } else {
            System.out.println("Try to select a Pawn");
        }
    }

    public static void setPawn(int col, int row, Color player) {
        board[row][col] = new Pawn(player);
    }

    public static void movePawn (int endCol, int endRow, Color player) {
//        removePawn(iniRow, iniCol);
        setPawn(endCol, endRow, player);
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
