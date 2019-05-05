package edu.dmacc.codedsm;

        import org.junit.Before;
        import org.junit.Test;

        import static org.junit.Assert.*;

public class GameLogicTest {

    GameLogic gameLogic;
    GameRunner gameRunnerFF;
    GameRunner gameRunnerTF;
    GameRunner gameRunnerFT;
    GameRunner gameRunnerTT;

    @Before
    public void setUp() throws Exception {
        gameRunnerFF = new StubGameRunnerFF();
        gameRunnerFT = new StubGameRunnerFT();
        gameRunnerTF = new StubGameRunnerTF();
        gameRunnerTT = new StubGameRunnerTT();
    }

    @Test
    public void testBuildResult() {
        gameLogic = new GameLogic(gameRunnerFF);
        GameResult gr = new GameResult();
        gr.setPlayer("Edith");
        gr.setScore(5);
        GameResult br = gameLogic.buildResult("Edith", 5);
        assertEquals(gr.getPlayer(), br.getPlayer());
        assertEquals(gr.getScore(), br.getScore());
    }

    @Test
    public void testRunGameFF() {
        gameLogic = new GameLogic(gameRunnerFF);
        GameResult gr = gameLogic.runGame("Barbara");
        assertEquals("Barbara", gr.getPlayer());
        assertEquals(new Integer(0), gr.getScore());
    }

    @Test
    public void testRunGameTF() {
        gameLogic = new GameLogic(gameRunnerTF);
        assertEquals(gameLogic.buildResult("Nellie", 10000), gameLogic.runGame("Nellie"));
    }

    @Test
    public void testRunGameFT() {
        gameLogic = new GameLogic(gameRunnerFT);
        assertEquals(gameLogic.buildResult("Bess", 100), gameLogic.runGame("Bess"));
        //assertEquals(new Integer(100), gameLogic.runGame());
    }

    @Test
    public void testRunGameTT() {
        gameLogic = new GameLogic(gameRunnerTT);
        assertEquals(gameLogic.buildResult("Jackie", 10000), gameLogic.runGame("Jackie"));
    }

    private class StubGameRunnerFF implements GameRunner {
        public boolean isVictorious() {
            return false;
        }
        public boolean isDefeated() {
            return false;
        }
    }

    private class StubGameRunnerTF implements GameRunner {
        public boolean isVictorious() {
            return true;
        }
        public boolean isDefeated() {
            return false;
        }
    }
    private class StubGameRunnerFT implements GameRunner {
        public boolean isVictorious() {
            return false;
        }
        public boolean isDefeated() {
            return true;
        }
    }
    private class StubGameRunnerTT implements GameRunner {
        public boolean isVictorious() {
            return true;
        }
        public boolean isDefeated() {
            return true;
        }
    }
    }