package dcl.yche;

/**
 * Created by TheKing on 05/12/2016.
 */
/**
 * L'exception WrongScoreException est utilisée pour
 * gérer les erreurs de format ou de sémantique du
 * score de la partie de bowling.
 */
public class WrongScoreException extends Exception {
    /**
     * Constructor.
     * @param message the error message
     */
    public WrongScoreException(final String message) {
        super(message);
    }

}