package org.example.WinningStrategies;

import org.example.Models.Cell;

public interface PlayerWonStrategy {

    boolean checkIfWon(Cell cell);
}
