package tictactoe.core.board;

import lombok.experimental.SuperBuilder;

import tictactoe.core.Event;

@SuperBuilder
public abstract class BoardUpdate extends Event {

    public abstract BoardState apply(BoardState state, BoardData data);
}