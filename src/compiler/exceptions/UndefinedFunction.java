package compiler.exceptions;

public class UndefinedFunction extends RuntimeException
{
    public UndefinedFunction(String message)
    {
        super(message);
    }
}