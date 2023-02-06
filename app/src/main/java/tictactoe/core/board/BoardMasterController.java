package tictactoe.core.board;

import tictactoe.core.InputEventStream;
import tictactoe.core.OutputEventStream;
import tictactoe.core.SystemMessage;

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
        BoardEvent transition;
        while ((transition = (BoardEvent)inputStream.read()) != null) {
            BoardState newBoardState = transition.apply(boardState, boardData);
            if (newBoardState != null) {
                boardState = newBoardState;
                outputStream.write(transition);
                System.out.printf("BoardMasterController::applyExternalTransitions: %s, %s\n", transition, boardState);
            }
            else {
                SystemMessage message = SystemMessage.builder()
                                .actorId(transition.getActorId())
                                .reason(transition)
                                .build();
                outputStream.write(message);
                System.out.printf("BoardMasterController::applyExternalTransitions: %s, %s\n", message, boardState);
            }
        }
    }

    private void applyMasterTransitions() {
        BoardEvent transition;
        while ((transition = boardState.nextTransition(boardData)) != null) {
            boardState = transition.apply(boardState, boardData);
            outputStream.write(transition);
            System.out.printf("BoardMasterController::applyMasterTransitions: %s, %s\n", transition, boardState);
        }
    }
}
