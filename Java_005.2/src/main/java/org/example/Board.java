package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class Board {
    private int[] boardState;

    public Board(int[] boardState) {
        this.boardState = boardState;
    }


    public int enBoard() {
        int encodedBoard = 0;
        for (int i = 0; i < boardState.length; i++) {
            encodedBoard = encodedBoard << 2;
            encodedBoard = encodedBoard | boardState[i];
        }
        return encodedBoard;
    }


    public void deBoard(int encodedBoard) {
        for (int i = boardState.length - 1; i >= 0; i--) {
            int cellState = encodedBoard & 3;
            encodedBoard = encodedBoard >> 2;
            boardState[i] = cellState;
        }
    }


    public void writeF(String fileName) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeInt(enBoard());
        }
    }


    public void readF(String fileName) throws IOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            int readBoard = dis.readInt();
            deBoard(readBoard);
        }
    }


    public void printBoard() {
        for (int i = 0; i < boardState.length; i++) {
            char cellSymbol;
            switch (boardState[i]) {
                case 0:
                    cellSymbol = '.';
                    break;
                case 1:
                    cellSymbol = 'x';
                    break;
                case 2:
                    cellSymbol = 'o';
                    break;
                default:
                    cellSymbol = '?';
                    break;
            }
            System.out.print(cellSymbol + " ");
            if ((i + 1) % 3 == 0) {
                System.out.println();
            }
        }
    }
}