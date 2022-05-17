package compiler.exceptions;

public class UnsupportedNode extends RuntimeException
{
    public UnsupportedNode(String message)
    {
        super(message);
    }
}