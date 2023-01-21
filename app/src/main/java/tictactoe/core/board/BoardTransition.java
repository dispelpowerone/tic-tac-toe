package tictactoe.core.board;

import lombok.experimental.SuperBuilder;
import lombok.ToString;

import tictactoe.core.GameEvent;

@SuperBuilder
public abstract class BoardTransition extends GameEvent {

    public abstract BoardState apply(BoardState state, BoardData data);
}
