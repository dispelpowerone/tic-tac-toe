package tictactoe.core.board;

import tictactoe.core.InputEventStream;
import tictactoe.core.OutputEventStream;

import lombok.Setter;
import lombok.Getter;

public class BoardPlayerController {

    @Getter
    private BoardData boardData = new BoardData();

    @Getter
    private BoardState boardState = new InitialState();

    @Setter
    private InputEventStream masterInputStream;

    @Setter
    private InputEventStream playerInputStream;

    @Setter
    private OutputEventStream outputStream;

    public void update() {
        applyExternalTransitions();
        applyPlayerTransitions();
    }

    private void applyExternalTransitions() {
        BoardTransition transition;
        while ((transition = (BoardTransition)masterInputStream.read()) != null) {
            boardState = transition.apply(boardState, boardData);
        }
    }

    private void applyPlayerTransitions() {
        BoardTransition transition;
        while ((transition = (BoardTransition)playerInputStream.read()) != null) {
            outputStream.write(transition);
            boardState = transition.apply(boardState, boardData);
        }
    }
}
