package dcl.yche;

/**
 * Created by TheKing on 05/12/2016.
 */


/**
 * La classe Partie représente un partie de Bowling
 * composée de FRAMES_NUMBER frames.
 */
public class Partie {

    /**
     * Nombre de frame par partie.
     */
    private static final int FRAMES_NUMBER = 10;

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
     * Expression régulière définissant les caractères autorisés pour le score.
     */
    private static final String REGEX = "["
            + STRIKE
            + SPARE
            + HOLE
            + "0-9]{1,21}";

    /**
     * Chaine de caractère réprésentant le score de la partie.
     */
    private String score;

    /**
     * Ensemble des frames composant la partie.
     */
    private Jeu[] frames = new Jeu[FRAMES_NUMBER];

    /**
     * Constructeur.
     * @param scoreStr chaine représentant le score de la partie.
     * @throws WrongScoreException erreur de format pour le score.
     */
    public Partie(final String scoreStr) throws WrongScoreException {
        this.score = scoreStr;
        initTab();
    }

    /**
     * Construit le tableau de frames composant la partie.
     * @throws WrongScoreException erreur de format du score.
     */
    private void initTab() throws WrongScoreException {
        if (!score.matches(REGEX)) {
            throw new WrongScoreException("Invalid expression for the score");
        }
        int iFrame = 0;
        int i = 0;
        final int delta = 3;
        char token;
        while (i < score.length() && iFrame < FRAMES_NUMBER) {
            token = score.charAt(i);
            switch (token) {
                case STRIKE:
                    if (i + delta < score.length()) {
                        frames[iFrame++] =
                                new Jeu(score.substring(i, i + delta));
                    } else {
                        frames[iFrame++] = new Jeu(score.substring(i));
                    }
                    i++;
                    break;
                default:
                    if (score.charAt(i + 1) == SPARE) {
                        if (i + delta < score.length()) {
                            frames[iFrame++] =
                                    new Jeu(score.substring(i, i + delta));
                        } else {
                            frames[iFrame++] = new Jeu(score.substring(i));
                        }
                    } else if (i + 2 < score.length()) {
                        frames[iFrame++] = new Jeu(score.substring(i, i + 2));
                    } else {
                        frames[iFrame++] = new Jeu(score.substring(i));
                    }
                    i += 2;
                    break;
            }
        }
    }

    /**
     * Calcule le score final de la partie.
     * @return le score final
     */
    public final int computFinalScore() {
        int res = 0;
        for (int i = 0; i < frames.length; i++) {
            res += frames[i].computeScore();
        }
        return res;
    }
}