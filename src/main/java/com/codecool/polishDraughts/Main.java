package com.codecool.polishDraughts;

import com.codecool.polishDraughts.Game.Board;
import com.codecool.polishDraughts.Game.Pawn;

import java.awt.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) { //throws InterruptedException
        int n = 6;
        Board.board = Board.board(n);

        Board.printBoard();


        //display board

        int count = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                count++;
                System.out.println("count: "+count);
//                System.out.println("Board: "+ (Board.board[i][j].pawnColor));
                if (Board.board[i][j].pawnColor == Color.GREEN) {
                    System.out.println("You have green at: i="+i+"  j="+j);
                }
                else if (Board.board[i][j].pawnColor == Color.WHITE) {
                    System.out.println("You have white at: i="+i+"  j="+j);
                }
                else if (Board.board[i][j].pawnColor == Color.BLACK) {
                    System.out.println("You have black at: i="+i+"  j="+j);
                }
                else if (Board.board[i][j].pawnColor == Color.BLUE) {
                    System.out.println("You have blue at: i="+i+"  j="+j);
                }
            }
        }


    }
}
