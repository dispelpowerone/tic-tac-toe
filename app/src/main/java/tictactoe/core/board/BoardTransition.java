package tictactoe.core.board;

import tictactoe.core.GameEvent;


public abstract class BoardTransition extends GameEvent {

    public abstract BoardState apply(BoardState state, BoardData data);
}
