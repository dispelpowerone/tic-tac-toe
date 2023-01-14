package tictactoe.core.board;

import java.util.Arrays;


public class BoardData {

    private char[] cells = new char[9];

    public void reset() {
        Arrays.fill(cells, ' ');
    }

    public void markCell(int index, char mark) {
        cells[index] = mark;
    }

    public char[] getCells() {
        return cells;
    }
}
