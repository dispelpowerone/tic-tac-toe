package tictactoe.core.board;

import tictactoe.core.InputEventStream;
import tictactoe.core.OutputEventStream;
import tictactoe.core.SystemMessage;

import lombok.Setter;

public class BoardMasterController {

    private BoardData boardData = new BoardData();

    @Setter
    private InputEventStream inputStream;

    @Setter
    private OutputEventStream outputStream;

    public void update() {
        applyEvents();
    }

    private void applyEvents() {
        BoardEvent event;
        BoardEvent reaction;
        while ((event = (BoardEvent)inputStream.read()) != null) {
            do {
                // Check event to keep data valid
                BoardError error = event.check(boardData);
                if (error != null) {
                    SystemMessage message = SystemMessage.builder()
                        .actorId(0L)
                        .reason(event)
                        .build();
                    outputStream.write(message);
                    // Stop reactions loop
                    break;
                }
                else {
                    reaction = event.apply(boardData);
                    outputStream.write(event);
                }
            } while ((event = reaction) != null);
        }
    }
}
