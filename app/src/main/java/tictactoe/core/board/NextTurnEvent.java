package tictactoe.core.board;

import lombok.experimental.SuperBuilder;
import lombok.ToString;

import tictactoe.core.board.BoardData.Player;

@ToString
@SuperBuilder
public class NextTurnEvent extends BoardEvent {

    @Override
    public BoardError check(BoardData data) {
        return null;
    }

    @Override
    public BoardEvent apply(BoardData data) {
        Player nextPlayer = data.getActivePlayer() == Player.PLAYER_A ?
                                Player.PLAYER_B :
                                Player.PLAYER_A;
        data.setActivePlayer(nextPlayer);
        return PickRequestEvent.builder()
            .actorId(0L)
            .player(nextPlayer)
            .build();
    }
}
