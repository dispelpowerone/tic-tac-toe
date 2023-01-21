package tictactoe.core.board;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class WaitPlayerChoiceState extends BoardState {

    private BoardState.Player player;

    WaitPlayerChoiceState(BoardState.Player player) {
        super(StateId.WAIT_PLAYER_CHOICE);
        this.player = player;
    }

    @Override
    public BoardTransition nextTransition(BoardData data) {
        return null;
    }
}
