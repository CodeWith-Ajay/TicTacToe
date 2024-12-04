package org.example.WinningStrategies;

import org.example.Models.Cell;
import org.example.Models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneWinningStrategy implements PlayerWonStrategy {
    List<HashMap<Character,Integer>>rowmaps;
    List<HashMap<Character,Integer>>colMaps;
    HashMap<Character,Integer>diagonalMap;
    HashMap<Character,Integer>reversediagonalMap;
    int size;

    public OrderOneWinningStrategy(int size) {
        this.size = size;

        this.rowmaps=new ArrayList<>();
        for (int i = 0; i < size; i++) {
            rowmaps.add(new HashMap<>());
        }
        this.colMaps=new ArrayList<>();
        for (int i = 0; i < size; i++) {
            colMaps.add(new HashMap<>());
        }


        this.diagonalMap = new HashMap<>();
        this.reversediagonalMap = new HashMap<>();
    }

    @Override
    public boolean checkIfWon(Cell cell) {
        int x=cell.getX();
        int y=cell.getY();
        char symbol=cell.getPlayer().getSymbol();
        rowmaps.get(x).put(symbol, rowmaps.get(x).getOrDefault(symbol, 0) + 1);
        colMaps.get(y).put(symbol, colMaps.get(y).getOrDefault(symbol, 0) + 1);
        if(checkIfCellIsOnDiagonal(x,y)){
            diagonalMap.put(symbol, diagonalMap.getOrDefault(symbol, 0) + 1);
        }
        if(checkIfCellIsOnReverseDiagonal(x,y)){
            reversediagonalMap.put(symbol, reversediagonalMap.getOrDefault(symbol, 0)+ 1);
        }
        if(rowmaps.get(x).get(symbol)==size){
            return true;
        }
        if(colMaps.get(y).get(symbol)==size){
            return true;
        }
        if(checkIfCellIsOnDiagonal(x,y)){
            return diagonalMap.get(symbol) == size;
        }
        if(checkIfCellIsOnReverseDiagonal(x,y)){
            return reversediagonalMap.get(symbol) == size;
        }
        return false;
    }

    private boolean checkIfCellIsOnDiagonal(int x, int y) {
        return x==y;
    }
    private boolean checkIfCellIsOnReverseDiagonal(int x, int y) {
        return x+y==this.size-1;
    }
    }


