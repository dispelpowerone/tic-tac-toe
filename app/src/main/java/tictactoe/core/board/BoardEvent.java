package tictactoe.core.board;

import lombok.experimental.SuperBuilder;

import tictactoe.core.Event;

@SuperBuilder
public abstract class BoardEvent extends Event {

    public abstract BoardError check(BoardData data);
    public abstract BoardEvent apply(BoardData data);
}
