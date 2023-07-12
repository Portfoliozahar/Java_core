package org.example;

import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        int[] initialState = {2, 1, 0, 2, 0, 2, 0, 1, 3};
        Board game = new Board(initialState);

        try {
            game.writeF("game.bin");
            game.readF("game.bin");
        } catch (IOException e) {
            e.printStackTrace();
        }

        game.printBoard();
    }
}