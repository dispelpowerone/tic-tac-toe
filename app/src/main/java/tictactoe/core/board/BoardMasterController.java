package tictactoe.core.board;

import tictactoe.core.InputEventStream;
import tictactoe.core.OutputEventStream;

import lombok.Setter;

public class BoardMasterController {

    private BoardData boardData = new BoardData();
    private BoardState boardState = new InitialState();

    @Setter
    private InputEventStream inputStream;

    @Setter
    private OutputEventStream outputStream;

    public void update() {
        applyExternalTransitions();
        applyMasterTransitions();
    }

    private void applyExternalTransitions() {
        BoardTransition transition;
        while ((transition = (BoardTransition)inputStream.read()) != null) {
            outputStream.write(transition);
            boardState = transition.apply(boardState, boardData);
        }
    }

    private void applyMasterTransitions() {
        BoardTransition transition;
        while ((transition = boardState.nextTransition(boardData)) != null) {
            outputStream.write(transition);
            boardState = transition.apply(boardState, boardData);
        }
    }
}
