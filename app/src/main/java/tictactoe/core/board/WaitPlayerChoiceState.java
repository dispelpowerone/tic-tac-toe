package tictactoe.core.board;


public class WaitPlayerChoiceState extends BoardState {

    private BoardState.Player player;

    WaitPlayerChoiceState(BoardState.Player player) {
        this.player = player;
    }

    @Override
    public BoardTransition nextTransition(BoardData data) {
        return null;
    }
}
