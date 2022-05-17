package compiler.exceptions;

public class UndefinedVariable extends RuntimeException
{
    public UndefinedVariable(String message)
    {
        super(message);
    }
}