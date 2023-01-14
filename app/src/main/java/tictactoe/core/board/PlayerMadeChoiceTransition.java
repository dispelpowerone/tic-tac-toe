package tictactoe.core.board;


public class PlayerMadeChoiceTransition extends BoardTransition {

    private BoardState.Player player;
    private int cellIndex;

    @Override
    public BoardState apply(BoardState state, BoardData data) {
        // Check preconditions
        // Update data
        final char marker = (player == BoardState.Player.LEFT) ? 'X' : 'O';
        data.markCell(cellIndex, marker);
        // Return next state
        return new EndOfTurnState(player);
    }
}
