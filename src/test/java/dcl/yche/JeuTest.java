package dcl.yche;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by TheKing on 05/12/2016.
 */
public class JeuTest {
    @Test
    public void computeScore() throws Exception {
        Jeu j= new Jeu("XXXXXXXXXXXX");
        assertEquals(300,j.computeScore());
        Jeu i= new Jeu("9_9_9_9_9_9_9_9_9_9_");
        assertEquals(90,i.computeScore());
        Jeu k= new Jeu("5/5/5/5/5/5/5/5/5/5/5");
        assertEquals(150,computeScore());
    }

}