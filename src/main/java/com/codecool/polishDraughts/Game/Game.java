package com.codecool.polishDraughts.Game;

import java.awt.*;
import java.util.Objects;
import java.util.Scanner;

import static com.codecool.polishDraughts.Game.Board.board;
import static java.awt.Color.*;

public class Game {

    public static int[] startEndMove(Color player, String startEnd) {
        Scanner move = new Scanner(System.in);
        boolean validCoordinates = false;
        int rowsMove = 0;
        int colsMove;
        char playerSign;
        String stringMove;

        if (player == WHITE) {
            playerSign = 'O';
        } else {
            playerSign = 'X';
        }

        do {
            //start or end difference
            if (Objects.equals(startEnd, "start")) {
                System.out.println("Player " + playerSign + " select your pawn to move (A2): ");
            } else {
                System.out.println("Player " + playerSign + " select your pawn destination (A2): ");
            }

            stringMove = move.nextLine();
            stringMove = stringMove.toUpperCase();
            colsMove = ((int) stringMove.charAt(0)) - 65;

            //check for quit
            checkForQuit(stringMove);

            //check for string length max 3
            if (checkMaxLength(stringMove)) continue;

            //check for valid letter in first position
            if (checkLetter(colsMove)) continue;

            //set the coordinate number
            if (stringMove.length() == 2) {
                rowsMove = ((int) stringMove.charAt(1)) - 48 - 1;
            } else {
                String stringNumber = stringMove.substring(1);
                try {
                    rowsMove = Integer.parseInt(stringNumber) - 1;
                } catch (Exception e) {
                    System.out.println("Not a valid number!");
                    continue;
                }
            }

            //check the row number
            if (checkRowNumber(rowsMove)) continue;

            //start or end difference
            if (Objects.equals(startEnd, "start")) {
                //check for valid pawn or blue area
                validCoordinates = isValidCoordinates(player, rowsMove, colsMove);
            } else {
                //check for valid destination
                validCoordinates = isValidDestination(rowsMove, colsMove);
            }

        } while (!validCoordinates);

        return new int[]{colsMove, rowsMove};
    }

    //check for a valid destination for moving a pawn
    private static boolean isValidDestination(int rowsMove, int colsMove) {
        boolean validCoordinates = false;
        if (board[rowsMove][colsMove].pawnColor != GREEN) {
            System.out.println("Choose a valid place!");
        } else {
            validCoordinates = true;
        }
        return validCoordinates;
    }

    //check for a valid choice of pawn
    private static boolean isValidCoordinates(
            Color player,
            int rowsMove,
            int colsMove) {
        boolean validCoordinates = false;
        Color alternate;

        if (player == WHITE) {
            alternate = ORANGE;
        } else {
            alternate = RED;
        }

        if (board[rowsMove][colsMove].pawnColor != player &&
                board[rowsMove][colsMove].pawnColor != alternate) {
            System.out.println("Choose a valid pawn!");
            return validCoordinates;
        } else if (board[rowsMove][colsMove].pawnColor == BLUE) {
            System.out.println("Out of the valid filed");
            return validCoordinates;
        }

        if (0<rowsMove && rowsMove<board.length-1 && 0<colsMove && colsMove< board.length-1) {
            if (board[rowsMove - 1][colsMove - 1].pawnColor == player &&
                board[rowsMove - 1][colsMove + 1].pawnColor == player &&
                board[rowsMove + 1][colsMove - 1].pawnColor == player &&
                board[rowsMove + 1][colsMove + 1].pawnColor == player) {
                        System.out.println("No valid moves!");
                        return validCoordinates;
            }

        }

        if (rowsMove - 1 < 0) {
            if (colsMove - 1 < 0) {
                if (board[rowsMove+1][colsMove+1].pawnColor == player) {
                        System.out.println("No valid moves!");
                }
            } else if (colsMove + 1 > board.length-1) {
                if (board[rowsMove+1][colsMove-1].pawnColor == player) {
                    System.out.println("No valid moves!");
                }
            } else {
                if (board[rowsMove+1][colsMove-1].pawnColor == player &&
                    board[rowsMove+1][colsMove+1].pawnColor == player) {
                    System.out.println("No valid moves!");
                }
            }
        } else if (rowsMove + 1 > board.length-1) {
            if (colsMove - 1 < 0) {
                if (board[rowsMove-1][colsMove+1].pawnColor == player) {
                    System.out.println("No valid moves!");
                }
            } else if (colsMove + 1 > board.length-1) {
                if (board[rowsMove-1][colsMove-1].pawnColor == player) {
                    System.out.println("No valid moves!");
                }
            } else {
                if (board[rowsMove-1][colsMove-1].pawnColor == player &&
                    board[rowsMove-1][colsMove+1].pawnColor == player) {
                    System.out.println("No valid moves!");
                }
            }
        } else if (colsMove - 1 < 0) {
            if (rowsMove + 1 > board.length-1) {
                if (board[rowsMove-1][colsMove+1].pawnColor == player) {
                    System.out.println("No valid moves!");
                }
            } else {
                if (board[rowsMove-1][colsMove+1].pawnColor == player &&
                    board[rowsMove+1][colsMove+1].pawnColor == player) {
                    System.out.println("No valid moves!");
                }
            }
        } else if (colsMove + 1 > board.length-1) {
            if (rowsMove + 1 > board.length-1) {
                if (board[rowsMove-1][colsMove-1].pawnColor == player) {
                    System.out.println("No valid moves!");
                }
            } else {
                if (board[rowsMove-1][colsMove-1].pawnColor == player &&
                    board[rowsMove+1][colsMove-1].pawnColor == player) {
                    System.out.println("No valid moves!");
                }
            }
        } else {
                System.out.println("Valid Coordinates = true");
                validCoordinates = true;}

        return validCoordinates;
    }


    //check for valid number for coordinates
    private static boolean checkRowNumber(int rowsMove) {
        if (!(0<= rowsMove && rowsMove <(board.length))) {
            System.out.println("Not a valid number!");
            return true;
        }
        return false;
    }


    //check for a valid letter in coordinates
    private static boolean checkLetter(int colsMove) {
        if (!(0<= colsMove && colsMove <=(board.length-1))) {
            System.out.println("Not a valid letter!");
            return true;
        }
        return false;
    }

    //check for right number of chars in coordinates
    private static boolean checkMaxLength(String stringMove) {
        if (stringMove.length()>3 || stringMove.length()<2) {
            System.out.println("A letter between A and " + ((char) (board.length+65-1)) +
                    " and a number between 1 and "+ board.length + " please!");
            return true;
        }
        return false;
    }

    //check for the quit command
    private static void checkForQuit(String stringMove) {
        if (stringMove.equals("QUIT")) {
            System.out.println("You quit the game!");
            System.exit(0);
        }
    }


    public static boolean checkDestination(
            int selectionCol,
            int selectionRow,
            int destinationCol,
            int destinationRow,
            Color player) {
        boolean response = false;
        String vector = "";

        if (destinationRow>selectionRow) {
            vector += "S";
        } else {
            vector += "N";
        }
        if (destinationCol>selectionCol) {
            vector += "E";
        } else {
            vector += "W";
        }

        Color opposite;

        if (player == WHITE) {
            opposite = BLACK;
        } else {
            opposite = WHITE;
        }

        if (board[destinationRow][destinationCol].pawnColor==GREEN) {
            if (
                    Math.abs(selectionCol - destinationCol) == 1
                    && Math.abs(selectionRow - destinationRow) == 1) {
                response = true;
            }
            else if (
                    Math.abs(selectionCol - destinationCol) == 2 &&
                    Math.abs(selectionRow - destinationRow) == 2) {
                switch (vector) {
                    case "NE":
                        if (board[destinationRow + 1][destinationCol - 1].pawnColor == opposite) {
                            board[destinationRow + 1][destinationCol - 1] = new Pawn(MAGENTA);
                            response = true;
                        }
                        break;
                    case "NW":
                        if (board[destinationRow + 1][destinationCol + 1].pawnColor == opposite) {
                            board[destinationRow + 1][destinationCol + 1] = new Pawn(MAGENTA);
                            response = true;
                        }
                        break;
                    case "SE":
                        if (board[destinationRow - 1][destinationCol - 1].pawnColor == opposite) {
                            board[destinationRow - 1][destinationCol - 1] = new Pawn(MAGENTA);
                            response = true;
                        }
                        break;
                    case "SW":
                        if (board[destinationRow - 1][destinationCol + 1].pawnColor == opposite) {
                            board[destinationRow - 1][destinationCol + 1] = new Pawn(MAGENTA);
                            response = true;
                        }
                        break;
                }
            }
        }
        return response;
    }


    public static void start() {
        boolean validMove;
        int n;
        int[] selection;
        int[] destination;
        String winner;

        Scanner keyboard = new Scanner(System.in);
        do {
            System.out.println("enter an integer between 10 and 20 for board size: ");
            n = keyboard.nextInt();
        } while (n<10 || n>20);
        board = board(n);

        Color player = WHITE;

        do {

            Board.printBoard();
            selection = Game.startEndMove(player, "start");
            Board.choosePawn(selection[0], selection[1]);
            Board.printBoard();

            do {
                destination = Game.startEndMove(player, "end");
                validMove = Game.checkDestination(selection[0], selection[1], destination[0], destination[1],player);
            } while (!validMove);

            Board.removePawn(selection[0], selection[1]);
            Board.movePawn(destination[0], destination[1],player);
            Board.removeTakenPawn();
            winner = Board.checkForWinner();

            //change the player
            if (player == WHITE) {
                player = BLACK;
            } else {
                player = WHITE;
            }


        } while (!Objects.equals(winner, "X") && !Objects.equals(winner, "O") && !Objects.equals(winner, "DRAW"));
    }

}

