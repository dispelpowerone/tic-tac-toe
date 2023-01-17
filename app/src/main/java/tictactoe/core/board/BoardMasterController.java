package tictactoe.core.board;

import tictactoe.core.InputEventStream;
import tictactoe.core.OutputEventStream;

public class BoardMasterController {

    private BoardData boardData = new BoardData();
    private BoardState boardState = new InitialState();
    private InputEventStream inputStream;
    private OutputEventStream outputStream;

    public void setInputEventStream(InputEventStream inputStream) {
        this.inputStream = inputStream;
    }

    public void setOutputEventStream(OutputEventStream outputStream) {
        this.outputStream = outputStream;
    }

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
