package byr.util.math;

public class FractionException extends RuntimeException{
    private final FractionExceptionStatus m_status;

    public FractionException(String message, FractionExceptionStatus status)
    {
        super(message);
        m_status = status;
    }

    public String getMessage()
    {
        return String.format("Message:%s, Status:%s", super.getMessage(), m_status);
    }

}
