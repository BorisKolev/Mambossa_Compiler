package compiler.expressions;

import compiler.other.ArithmeticEnum;
import compiler.other.INode;

public class BinaryExpression extends INode {
    public final INode leftNode, rightNode;
    public final ArithmeticEnum operation;

    public BinaryExpression(INode left, INode right, ArithmeticEnum operation) {
        super();
        leftNode = left;
        rightNode = right;
        this.operation = operation;
    }

    @Override
    public String getDisplayName() {
        return String.format("%s(operation: %s)", BinaryExpression.class.getSimpleName(), operation);
    }
}