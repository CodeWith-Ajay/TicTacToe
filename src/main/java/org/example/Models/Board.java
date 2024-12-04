package org.example.Models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Cell>>grid;
    public Board(int size) {
        grid=new ArrayList<>(size);
        for (int row = 0; row < size; row++) {
            List<Cell> rows=new ArrayList<>();
            for (int col = 0; col < size; col++) {
                rows.add(new Cell(row,col));

            }
            grid.add(rows);
        }
    }

    public void printBoard() {
        for(List<Cell> row:grid) {
            for(Cell cell:row) {
                cell.print();
                System.out.print(" | ");
            }
            System.out.println();
        }
    }

    public void setPlayer(int x, int y, Player player) {
        Cell cell=this.grid.get(x).get(y);
        cell.setPlayer(player);

    }

    public Cell getCell(int key, int value) {
        return this.grid.get(key).get(value);
    }
}
