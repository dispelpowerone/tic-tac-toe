package tictactoe.core.board;

import lombok.ToString;

@ToString
public class InitialState extends BoardState {

    public InitialState() {
        super(StateId.INITIAL);
    }

    @Override
    public BoardTransition nextTransition(BoardData data) {
        return null;
    }
}
