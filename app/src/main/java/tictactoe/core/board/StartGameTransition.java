package tictactoe.core.board;


public class StartGameTransition extends BoardTransition {

    @Override
    public BoardState apply(BoardState state, BoardData data) {
        // Check preconditions
        // Update data
        data.reset();
        // Return next state
        return new WaitPlayerChoiceState(BoardState.Player.LEFT);
    }
}
