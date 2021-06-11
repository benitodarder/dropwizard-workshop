package local.tin.tests.superheroes.model.persistence.exceptions;

/**
 *
 * @author benitodarder
 */
public class SuperException extends Exception {

    public SuperException() {
    }

    public SuperException(String message) {
        super(message);
    }

    public SuperException(String message, Throwable cause) {
        super(message, cause);
    }

    public SuperException(Throwable cause) {
        super(cause);
    }

    public SuperException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    
    
}
