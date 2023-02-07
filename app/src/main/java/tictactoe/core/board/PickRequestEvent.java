package tictactoe.core.board;

import lombok.experimental.SuperBuilder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@SuperBuilder
public class PickRequestEvent extends BoardEvent {

    private BoardData.Player player;

    @Override
    public BoardError check(BoardData data) {
        return null;
    }

    @Override
    public BoardEvent apply(BoardData data) {
        data.setState(BoardData.State.PICK_REQUESTED);
        return null;
    }
}
