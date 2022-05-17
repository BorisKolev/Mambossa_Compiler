package compiler.exceptions;

public class UndefinedFunctionReturn extends RuntimeException
{
    public UndefinedFunctionReturn(String message)
    {
        super(message);
    }
}