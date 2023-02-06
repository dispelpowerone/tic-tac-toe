package tictactoe.core.board;

import lombok.experimental.SuperBuilder;
import lombok.Getter;
import lombok.ToString;

@SuperBuilder
@Getter
@ToString
public class EndOfTurnState extends BoardState {

    private BoardData.Player player;

    @Override
    public BoardEvent nextTransition(BoardData data) {
        // check winner condition
        // check parity condition
        final BoardData.Player nextPlayer =
            (player == BoardData.Player.PLAYER_A) ? BoardData.Player.PLAYER_B : BoardData.Player.PLAYER_A;
        return NextPickRequestedUpdate.builder()
                    .actorId(Long.valueOf(1))
                    .player(nextPlayer)
                    .build();
    }
}
