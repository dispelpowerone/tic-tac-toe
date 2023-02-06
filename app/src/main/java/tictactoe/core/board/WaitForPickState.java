package tictactoe.core.board;

import lombok.experimental.SuperBuilder;
import lombok.Getter;
import lombok.ToString;

@SuperBuilder
@Getter
@ToString
public class WaitForPickState extends BoardState {

    private BoardData.Player player;

    @Override
    public BoardEvent nextTransition(BoardData data) {
        return null;
    }
}
