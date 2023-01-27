package tictactoe.core.board;

import lombok.Getter;

import java.util.Arrays;

public class BoardData {

    @Getter
    private char[] cells = new char[9];

    public BoardData() {
        reset();
    }

    public void reset() {
        Arrays.fill(cells, ' ');
    }

    public void markCell(int index, char mark) {
        cells[index] = mark;
    }
}
