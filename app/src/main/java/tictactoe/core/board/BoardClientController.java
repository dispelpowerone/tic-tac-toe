package tictactoe.core.board;

import tictactoe.core.InputEventStream;
import tictactoe.core.OutputEventStream;

import lombok.Setter;
import lombok.Getter;

@Getter
public class BoardClientController {

    private BoardData boardData = new BoardData();
    private BoardState boardState = InitialState.builder().build();

    @Setter
    private InputEventStream masterInputStream;

    @Setter
    private InputEventStream playerInputStream;

    @Setter
    private OutputEventStream outputStream;

    public void update() {
        applyPlayerTransitions();
        applyExternalTransitions();
    }

    private void applyExternalTransitions() {
        BoardEvent transition;
        while ((transition = (BoardEvent)masterInputStream.read()) != null) {
            boardState = transition.apply(boardState, boardData);
        }
    }

    private void applyPlayerTransitions() {
        BoardEvent transition;
        while ((transition = (BoardEvent)playerInputStream.read()) != null) {
            outputStream.write(transition);
        }
    }
}
