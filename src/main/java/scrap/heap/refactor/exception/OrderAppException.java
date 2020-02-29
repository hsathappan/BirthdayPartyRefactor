package scrap.heap.refactor.exception;

/**
 * Exception to throw and log Application specific exceptions
 */
public class OrderAppException
        extends RuntimeException {

    public OrderAppException(String msg) {
        super(msg);
    }
}
