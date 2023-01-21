package tictactoe.core.board;

import lombok.experimental.SuperBuilder;
import lombok.Getter;
import lombok.ToString;

@SuperBuilder
@Getter
@ToString
public class WaitPlayerChoiceState extends BoardState {

    private BoardState.Player player;

    @Override
    public BoardTransition nextTransition(BoardData data) {
        return null;
    }
}
