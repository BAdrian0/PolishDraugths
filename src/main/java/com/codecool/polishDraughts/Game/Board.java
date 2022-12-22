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

    public static void removeTakenPawn() {
        int n = board.length;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (Board.board[row][col].pawnColor == MAGENTA) {
                    board[row][col] = new Pawn(GREEN);
                }
            }
        }
    }

    public static String checkForWinner() {
        int n = board.length;
        int X = 0;
        int O = 0;
        int KX = 0;//king X
        int KO = 0;//king O
        String returnedValue = "";
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (Board.board[row][col].pawnColor == WHITE) {
                    O += 1;
                } else if (Board.board[row][col].pawnColor == BLACK) {
                    X +=1;
                } else if (Board.board[row][col].pawnColor == RED) {
                    KX +=1;
                } else if (Board.board[row][col].pawnColor == ORANGE) {
                    KO +=1;
                }
            }
        }
        if (X==0) {
            returnedValue = "O";
        }
        if (O==0) {
            returnedValue = "X";
        }
        if (KX==1 && KO==1 && X==0 && O==0) {
            returnedValue = "DRAW";
        }
        return returnedValue;
    }


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
                    } else if (board[row - 1][col - 1].pawnColor == MAGENTA) {
                        stringBoard[row][col] = "T";
                    } else if (board[row - 1][col - 1].pawnColor == RED) {
                        stringBoard[row][col] = "#";
                    } else if (board[row - 1][col - 1].pawnColor == ORANGE) {
                        stringBoard[row][col] = "@";
                    } else {
                        stringBoard[row][col] = "X";
                    }

                }
            }
        }

        System.out.println(
                Arrays.deepToString(stringBoard)
                .replace("[[", " ")
                .replace("], ", "\n")
                .replace(","," ")
                .replace("[","")
                .replace("]]","")
                .replace("10 ","10")
                .replace("11 ","11")
                .replace("12 ","12")
                .replace("13 ","13")
                .replace("14 ","14")
                .replace("15 ","15")
                .replace("16 ","16")
                .replace("17 ","17")
                .replace("18 ","18")
                .replace("19 ","19")
                .replace("20 ","20"));
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
        if (board[row][col].pawnColor == WHITE || board[row][col].pawnColor == BLACK
            || board[row][col].pawnColor == RED || board[row][col].pawnColor == ORANGE) {
            board[row][col] = new Pawn(GRAY);
        } else {
            System.out.println("Try to select a Pawn");
        }
    }

//setting & crowning pawns
    public static void setPawn(int col, int row, Color player) {
        if (player==BLACK && row==board.length-1) {
            board[row][col] = new Pawn(RED);
            board[row][col].isCrowned = true;
        } else if (player==WHITE && row==0) {
            board[row][col].isCrowned = true;
            board[row][col] = new Pawn(ORANGE);
        } else {
            board[row][col] = new Pawn(player);
        }

    }


    public static void movePawn (int endCol, int endRow, Color player) {
//        removePawn(iniRow, iniCol);
        setPawn(endCol, endRow, player);
    }


}
