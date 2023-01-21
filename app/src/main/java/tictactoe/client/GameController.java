package tictactoe.client;

import tictactoe.core.EventStream;
import tictactoe.core.GameEvent;
import tictactoe.core.board.BoardMasterController;
import tictactoe.core.board.BoardPlayerController;
import tictactoe.core.board.BoardData;
import tictactoe.core.board.BoardState;
// Transitions and states
import tictactoe.core.board.*;

import java.util.Scanner;

public class GameController {

    private BoardMasterController boardMasterController = new BoardMasterController();
    private BoardPlayerController boardPlayerController = new BoardPlayerController();
    private EventStream playerInputStream = new EventStream();
    private EventStream playerMasterStream = new EventStream();
    private EventStream masterPlayerStream = new EventStream();
    private Scanner inputScanner;
    private BoardState.Player currentPlayer;

    public GameController() {
        // Master controller
        boardMasterController.setInputStream(playerMasterStream);
        boardMasterController.setOutputStream(masterPlayerStream);

        // Player controller
        boardPlayerController.setOutputStream(playerMasterStream);
        boardPlayerController.setPlayerInputStream(playerInputStream);
        boardPlayerController.setMasterInputStream(masterPlayerStream);

        // Hook up stdin
        inputScanner = new Scanner(System.in);
    }

    public void update() {
        boardPlayerController.update();
        boardMasterController.update();
    }

    public void draw() {
        drawBoard(boardPlayerController.getBoardData());
        drawCommands(boardPlayerController.getBoardState());
        readPlayerCommand();
    }

    private void drawBoard(BoardData boardData) {
        char[] cells = boardData.getCells();
        System.out.printf("+---+---+---+\n");
        System.out.printf("| %s | %s | %s |\n", cells[0],  cells[1], cells[2]);
        System.out.printf("+---+---+---+\n");
        System.out.printf("| %s | %s | %s |\n", cells[3],  cells[4], cells[5]);
        System.out.printf("+---+---+---+\n");
        System.out.printf("| %s | %s | %s |\n", cells[6],  cells[7], cells[8]);
        System.out.printf("+---+---+---+\n");
    }

    private void drawCommands(BoardState boardState) {
        System.out.printf("State: %s\n", boardState.toString());
        if (boardState instanceof InitialState) {
            System.out.println("Commands: s");
        }
        else if (boardState instanceof WaitPlayerChoiceState) {
            currentPlayer = ((WaitPlayerChoiceState)boardState).getPlayer();
            System.out.println("Commands: 1-9");
        }
        else {
            System.out.println("Commands: none");
        }
    }

    private void readPlayerCommand() {
        String input = inputScanner.nextLine();
        if (input.isEmpty()) {
            return;
        }

        char command = input.charAt(0);

        GameEvent event = null;
        if (command == 's') {
            event = StartGameTransition.builder()
                .actorId(Long.valueOf(2))
                .build();
        }
        else if (command >= '1' && command <= '9') {
            event = PlayerMadeChoiceTransition.builder()
                .actorId(Long.valueOf(2))
                .player(currentPlayer)
                .cellIndex(command - '1')
                .build();
        }

        if (event != null) {
            playerInputStream.write(event);
        }
    }
}
