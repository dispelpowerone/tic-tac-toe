package tictactoe.core.board;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class BoardData {

    public enum State {
        INITIAL,
        PICK_REQUESTED
    }

    public enum Player {
        NONE,
        PLAYER_A,
        PLAYER_B
    }

    private State state = State.INITIAL;
    private Player activePlayer = Player.NONE;
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
