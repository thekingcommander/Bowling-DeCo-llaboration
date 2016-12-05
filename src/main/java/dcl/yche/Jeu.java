package dcl.yche;

/**
 * Created by TheKing on 05/12/2016.
 * La classe Jeu permet de calculer le score au niveau d'un jeu.
 *
 */
public class Jeu {

    /**
     * Le nombre de frames(jeux) par partie.
     */
    private static final int NB_FRAMES = 10;

    /**
     * Le score obtenu avec un strike.
     */
    private static final int STRIKE_SCORE = 10;
    /**
     * Le score obtenu avec un spare.
     */
    private static final int SPARE_SCORE = 10;
    /**
     * Le score obtenu lorsqu'aucune quille n'est renversé.
     */
    private static final int HOLE_SCORE = 0;

    /**
     * Représentation d'un strike.
     */
    private static final char STRIKE = 'X';
    /**
     * Représentation d'un spare.
     */
    private static final char SPARE = '/';
    /**
     * Représentation d'un hole.
     */
    private static final char HOLE = '_';

    /**
     * Chaine de caractère représentant le score de la frame concernée.
     */
    private String scoreGame;

    /**
     * Constructor.
     * @param score la chaine représentant le score de la frame
     */
    public Jeu(final String score) {
        scoreGame = score;
    }

    /**
     * Cette méthode calcule la valeur du score d'une frame.
     * @return le score de la frame
     */
    public final int computeScore() {
        int res = 0;
        int number = 0;
        for (int i = 0; i < scoreGame.length(); i++) {
            char token = scoreGame.charAt(i);
            switch (token) {
                case STRIKE:
                    res += STRIKE_SCORE;
                    break;
                case SPARE:
                    res += SPARE_SCORE - number;
                    break;
                case HOLE:
                    res += HOLE_SCORE;
                    break;
                default:
                    number = Integer.parseInt(String.valueOf(token));
                    res += number;
            }
        }
        return res;

    }

}