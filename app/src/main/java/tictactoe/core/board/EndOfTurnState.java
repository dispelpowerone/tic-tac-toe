package tictactoe.core.board;

import lombok.experimental.SuperBuilder;
import lombok.Getter;
import lombok.ToString;

@SuperBuilder
@Getter
@ToString
public class EndOfTurnState extends BoardState {

    private BoardState.Player player;

    @Override
    public BoardTransition nextTransition(BoardData data) {
        // check winner condition
        // check parity condition
        final BoardState.Player nextPlayer =
            (player == BoardState.Player.LEFT) ? BoardState.Player.RIGHT : BoardState.Player.LEFT;
        return RequestPlayerChoiceTransition.builder()
                    .actorId(Long.valueOf(1))
                    .player(nextPlayer)
                    .build();
    }
}
