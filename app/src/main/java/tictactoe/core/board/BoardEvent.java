package tictactoe.core.board;

import lombok.experimental.SuperBuilder;

import tictactoe.core.Event;

@SuperBuilder
public abstract class BoardEvent extends Event {

    public abstract BoardState apply(BoardState state, BoardData data);
}
