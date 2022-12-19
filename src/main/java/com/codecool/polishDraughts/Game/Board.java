package com.codecool.polishDraughts.Game;

import java.awt.*;
import java.util.Arrays;

import static java.awt.Color.*;

public class Board {
    public static Pawn[][] board;

    public static Pawn[][] board(int n) {
        board = new Pawn[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i==0 && j%2!=0) {
                    board[i][j] = new Pawn(BLACK);
                }
                else if (i==1 && j%2==0) {
                    board[i][j] = new Pawn(BLACK);
                }
                else if (i==n-2 && j%2!=0) {
                    board[i][j] = new Pawn(WHITE);
                }
                else if (i==n-1 && j%2==0) {
                    board[i][j] = new Pawn(WHITE);
                }
                else if (i%2==0 && j%2==0) {
                    board[i][j] = new Pawn(BLUE);
                }
                else if (i%2!=0 && j%2!=0) {
                    board[i][j] = new Pawn(BLUE);
                }
                else {
                    board[i][j] = new Pawn(GREEN);
                }
            }
        }
        return board;
    }

    public String toString() {
        return "toString";
    }





    public static void printBoard() {
        String headBoard = " 1 2 3 4 5 6 7 8 9 1011121314151617181920";
        //one  space for lettersSideBoard and 2x spaces for each column
        String substr = headBoard.substring(0, board.length * 2 + 1);
        //initialize board2 used for display
//        String[][] stringBoard = new String[board.length][board.length];
//        Pawn[][] board2 = new Pawn[board.length][board.length+1];
        String[][] stringBoard = new String[board.length + 1][board.length + 1];

//        for (int row=0; row<board.length; row++) {
//            for (int col=0; col < board[0].length; col++) {
//                stringBoard[row][col] = Integer.toString(board[row][col]);
//            }
//        }

        for (int row = 0; row < stringBoard.length; row++) {
            for (int col = 0; col < stringBoard.length; col++) {
                String firstLetter = (char) (row + 65) + "";
                if (col == 0 && row > 0) {
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
        System.out.println(Arrays.deepToString(stringBoard));

/*
        System.out.println(" "+substr.replace(",","").
                replace("[","").replace("]","")
                +
                "\n"+
                Arrays.deepToString(stringBoard2).replace("0], ", "."+"\n").
                        replace("[[", "").replace("0]]", ".").
                        replace("[","").replace("0,",".").
                        replace("1,", "X").replace("2,","O").
                        replace("1],","X"+"\n").replace("2],","O"+"\n").
                        replace(",","").replace("2]]","0").
                        replace("1]]","X").replace(" B","B").
                        replace(" C","C").replace(" D","D").
                        replace(" E","E").replace(" F","F").
                        replace(" G","G").replace(" H","H").
                        replace(" I","I").replace(" J","J").
                        replace(" K","K")+"\n");

    }



    public void removePawn (int x, int y) {

    }

    public void movePawn (int xi, int yi, int x, int y) {

    }
*/
    }
}
