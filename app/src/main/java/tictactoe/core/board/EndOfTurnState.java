package tictactoe.core.board;

public class EndOfTurnState extends BoardState {

    private BoardState.Player player;

    EndOfTurnState(BoardState.Player player) {
        super(StateId.END_OF_TURN);
        this.player = player;
    }

    @Override
    public BoardTransition nextTransition(BoardData data) {
        // check winner condition
        // check parity condition
        final BoardState.Player nextPlayer =
            (player == BoardState.Player.LEFT) ? BoardState.Player.RIGHT : BoardState.Player.LEFT;
        return RequestPlayerChoiceTransition.builder()
                    .player(nextPlayer)
                    .build();
    }
}
