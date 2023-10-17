package GomokuGame.game;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class GameUITest {

    @Test
    void welcomeUser() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        GameUI gameUI = new GameUI(null, System.in, new PrintStream(outputStream));

        gameUI.welcomeUser();
        assertEquals("Welcome to Gomoku / Omok", outputStream.toString());
    }

    @Test
    void promptForGameMode() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("1\n".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        GameUI gameUI = new GameUI(null, inputStream, new PrintStream(outputStream));

        int mode = gameUI.promptForGameMode();
        assertEquals(1, mode);
    }
    @Test
    void placeStone() {

    }
}