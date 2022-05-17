package compiler.exceptions;

public class DuplicateDefinition extends RuntimeException
{
    public DuplicateDefinition(String message)
    {
        super(message);
    }
}