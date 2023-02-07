package tictactoe.core.board;

import tictactoe.core.InputEventStream;
import tictactoe.core.OutputEventStream;

import lombok.Setter;
import lombok.Getter;

@Getter
public class BoardClientController {

    private BoardData boardData = new BoardData();

    @Setter
    private InputEventStream masterInputStream;

    @Setter
    private InputEventStream playerInputStream;

    @Setter
    private OutputEventStream outputStream;

    public void update() {
        applyLocalEvents();
        applyMaterEvents();
    }

    private void applyMaterEvents() {
        BoardEvent event;
        while ((event = (BoardEvent)masterInputStream.read()) != null) {
            event.apply(boardData);
        }
    }

    private void applyLocalEvents() {
        BoardEvent event;
        while ((event = (BoardEvent)playerInputStream.read()) != null) {
            outputStream.write(event);
        }
    }
}
