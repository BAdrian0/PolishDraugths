package com.codecool.polishDraughts;

import com.codecool.polishDraughts.Game.Board;
import com.codecool.polishDraughts.Game.Pawn;

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) { //throws InterruptedException

        int n;
        Scanner keyboard = new Scanner(System.in);
        do {
            System.out.println("enter an integer between 10 and 20 for board size: ");
            n = keyboard.nextInt();
        } while (n<5 || n>20);
//        int n = 6;
        Board.board = Board.board(n);

        Board.printBoard();
//        Board.displayBoard();
        Board.removePawn(1, 0);
        Board.printBoard();



    }
}
