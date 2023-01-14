package tictactoe.core.board;

public class RequestPlayerChoiceTransition extends BoardTransition {

    private BoardState.Player player;

    RequestPlayerChoiceTransition(BoardState.Player player) {
        this.player = player;
    }

    @Override
    public BoardState apply(BoardState state, BoardData data) {
        // Check preconditions
        // Update data
        // Return next state
        return new WaitPlayerChoiceState(player);
    }
}
