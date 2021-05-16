package coingame;

import coingame.state.GameState;
import coingame.state.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameStateTest {

    private GameState gameState;

    @BeforeEach
    public void setUP(){
        gameState = new GameState("p1", "p2");
        gameState.firstChoice(3);
    }

    @Test
    void testFirstChoice(){
        List<Integer> expected = Arrays.asList(8, 6, 4, 3, 1, 2, 2, 8, 1, 5, 6); //3
        List<Integer> expected2 = Arrays.asList(2, 8, 1, 5, 6, 4, 8, 6, 4, 3, 1); //9
        assertEquals(expected, gameState.getList());
        gameState.firstChoice(5);
        assertEquals(expected, gameState.getList());
    }

    @Test
    void testStep(){
        assertTrue(gameState.step(1));
        assertTrue(gameState.step(2));
        assertFalse(gameState.step(5));
        assertTrue(gameState.step(11));
        assertFalse(gameState.step(11));
        assertTrue(gameState.step(10));
        assertFalse(gameState.step(-47));
    }


    @Test
    void testWinner(){
        for(int i = 1; i<=11; i++){
            gameState.step(i);
        }
        assertEquals("p1",gameState.getWinnerName());
    }
}
