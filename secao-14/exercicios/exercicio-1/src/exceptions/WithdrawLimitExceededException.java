package exceptions;

public class WithdrawLimitExceededException extends RuntimeException {
    public WithdrawLimitExceededException(String msg) {
        super(msg);
    }
}
