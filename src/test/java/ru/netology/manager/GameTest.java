package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Player;
import ru.netology.exception.NotRegisteredException;

public class GameTest {

    @Test
    public void shouldFirstPlayerWin() {
        Game game = new Game();
        Player p1 = new Player(1, "Ivan", 100);
        Player p2 = new Player(2, "Petr", 50);
        game.register(p1);
        game.register(p2);

        int actual = game.round("Ivan", "Petr");
        Assertions.assertEquals(1, actual);
    }

    @Test
    public void shouldSecondPlayerWin() {
        Game game = new Game();
        Player p1 = new Player(1, "Ivan", 50);
        Player p2 = new Player(2, "Petr", 100);
        game.register(p1);
        game.register(p2);

        int actual = game.round("Ivan", "Petr");
        Assertions.assertEquals(2, actual);
    }

    @Test
    public void shouldDraw() {
        Game game = new Game();
        Player p1 = new Player(1, "Ivan", 100);
        Player p2 = new Player(2, "Petr", 100);
        game.register(p1);
        game.register(p2);

        int actual = game.round("Ivan", "Petr");
        Assertions.assertEquals(0, actual);
    }

    @Test
    public void shouldThrowExceptionWhenFirstPlayerNotRegistered() {
        Game game = new Game();
        Player p2 = new Player(2, "Petr", 100);
        game.register(p2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Ivan", "Petr");
        });
    }

    @Test
    public void shouldThrowExceptionWhenSecondPlayerNotRegistered() {
        Game game = new Game();
        Player p1 = new Player(1, "Ivan", 100);
        game.register(p1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Ivan", "Petr");
        });
    }
}