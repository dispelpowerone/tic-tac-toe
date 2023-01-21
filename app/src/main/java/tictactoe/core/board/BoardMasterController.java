package tictactoe.core.board;

import tictactoe.core.InputEventStream;
import tictactoe.core.OutputEventStream;

import lombok.Setter;

public class BoardMasterController {

    private BoardData boardData = new BoardData();
    private BoardState boardState = InitialState.builder().build();

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
            boardState = transition.apply(boardState, boardData);
            outputStream.write(transition);
            System.out.printf("BoardMasterController::applyExternalTransitions: %s, %s\n", transition, boardState);
        }
    }

    private void applyMasterTransitions() {
        BoardTransition transition;
        while ((transition = boardState.nextTransition(boardData)) != null) {
            boardState = transition.apply(boardState, boardData);
            outputStream.write(transition);
            System.out.printf("BoardMasterController::applyMasterTransitions: %s, %s\n", transition, boardState);
        }
    }
}
